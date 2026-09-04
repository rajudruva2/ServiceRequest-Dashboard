let page=0, size=10;

const $ = id => document.getElementById(id);

async function loadSummary(){
    const r=await fetch('/api/tickets/summary');
    const d=await r.json();
    $('total').textContent=d.total;
    $('open').textContent=d.open;
    $('progress').textContent=d.inProgress;
    $('resolved').textContent=d.resolved;
    $('high').textContent=d.highPriority;
}

async function loadTickets(){
    const p=new URLSearchParams({page,size});
    const search=$('search').value.trim();
    const status=$('status').value;
    const priority=$('priority').value;
    const category=$('category').value;
    if(search)p.set('search',search);
    if(status)p.set('status',status);
    if(priority)p.set('priority',priority);
    if(category)p.set('category',category);

    const r=await fetch('/api/tickets?'+p);
    if(!r.ok)throw new Error('Could not load tickets');
    const d=await r.json();

    $('rows').innerHTML=d.data.length?d.data.map(t=>`
        <tr>
            <td><strong>${esc(t.ticketNumber)}</strong></td>
            <td>${esc(t.title)}</td>
            <td>${esc(t.requester)}</td>
            <td>${esc(t.category)}</td>
            <td><span class="badge ${esc(t.priority)}">${esc(t.priority)}</span></td>
            <td><span class="badge ${esc(t.status)}">${esc(t.status.replace('_',' '))}</span></td>
            <td>${esc(t.assignedTo)}</td>
            <td>${new Date(t.updatedAt).toLocaleString()}</td>
        </tr>`).join(''):
        '<tr><td colspan="8" style="text-align:center;padding:30px">No tickets found</td></tr>';

    const first=d.totalRecords?d.page*d.pageSize+1:0;
    const last=Math.min((d.page+1)*d.pageSize,d.totalRecords);
    $('info').textContent=`Showing ${first}-${last} of ${d.totalRecords}`;
    $('page').textContent=`Page ${d.totalPages?d.page+1:0} of ${d.totalPages}`;
    $('prev').disabled=d.page<=0;
    $('next').disabled=d.page>=d.totalPages-1;
}

function esc(v){return String(v).replaceAll('&','&amp;').replaceAll('<','&lt;').replaceAll('>','&gt;').replaceAll('"','&quot;').replaceAll("'","&#039;")}

async function refresh(){
    $('error').style.display='none';
    try{await Promise.all([loadSummary(),loadTickets()])}
    catch(e){$('error').textContent=e.message;$('error').style.display='block'}
}

$('prev').onclick=()=>{if(page>0){page--;loadTickets()}};
$('next').onclick=()=>{page++;loadTickets()};
$('clear').onclick=()=>{$('search').value='';$('status').value='';$('priority').value='';$('category').value='';page=0;refresh()};
['status','priority','category'].forEach(id=>$(id).onchange=()=>{page=0;loadTickets()});
let timer;
$('search').oninput=()=>{clearTimeout(timer);timer=setTimeout(()=>{page=0;loadTickets()},300)};
$('newTicket').onclick=()=>alert('POST /api/tickets can be used to create a new ticket.');

refresh();
