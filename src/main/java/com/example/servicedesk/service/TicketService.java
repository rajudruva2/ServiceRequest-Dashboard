package com.example.servicedesk.service;

import com.example.servicedesk.dto.SummaryResponse;
import com.example.servicedesk.dto.TicketPageResponse;
import com.example.servicedesk.dto.TicketRequest;
import com.example.servicedesk.entity.ServiceTicket;
import com.example.servicedesk.repository.ServiceTicketRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private final ServiceTicketRepository repository;

    public TicketService(ServiceTicketRepository repository) {
        this.repository = repository;
    }

    public TicketPageResponse findTickets(int page, int size, String search,
                                          String status, String priority, String category) {
        Pageable pageable = PageRequest.of(Math.max(page, 0), Math.min(Math.max(size, 1), 100),
                Sort.by(Sort.Direction.DESC, "updatedAt"));

        Page<ServiceTicket> result;

        if (search != null && !search.isBlank()) {
            result = repository.findByTitleContainingIgnoreCaseOrRequesterContainingIgnoreCase(
                    search.trim(), search.trim(), pageable);
        } else {
            result = repository.findAll(pageable);
        }

        var filtered = result.getContent().stream()
                .filter(t -> status == null || status.isBlank() || t.getStatus().equalsIgnoreCase(status))
                .filter(t -> priority == null || priority.isBlank() || t.getPriority().equalsIgnoreCase(priority))
                .filter(t -> category == null || category.isBlank() || t.getCategory().equalsIgnoreCase(category))
                .toList();

        return new TicketPageResponse(
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages(),
                filtered
        );
    }

    public ServiceTicket get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found: " + id));
    }

    public ServiceTicket create(TicketRequest request) {
        long next = repository.count() + 1001;

        ServiceTicket ticket = new ServiceTicket(
                "INC-" + next,
                request.title(),
                request.requester(),
                request.category(),
                request.priority(),
                "OPEN",
                request.assignedTo(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        return repository.save(ticket);
    }

    public ServiceTicket update(Long id, TicketRequest request) {
        ServiceTicket ticket = get(id);
        ticket.setTitle(request.title());
        ticket.setCategory(request.category());
        ticket.setPriority(request.priority());
        ticket.setAssignedTo(request.assignedTo());
        ticket.setUpdatedAt(LocalDateTime.now());
        return repository.save(ticket);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Ticket not found: " + id);
        }
        repository.deleteById(id);
    }

    public SummaryResponse summary() {
        return new SummaryResponse(
                repository.count(),
                repository.countByStatus("OPEN"),
                repository.countByStatus("IN_PROGRESS"),
                repository.countByStatus("RESOLVED"),
                repository.countByPriority("HIGH")
        );
    }
}
