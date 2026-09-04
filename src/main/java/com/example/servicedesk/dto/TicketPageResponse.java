package com.example.servicedesk.dto;

import com.example.servicedesk.entity.ServiceTicket;
import java.util.List;

public record TicketPageResponse(
        int page,
        int pageSize,
        long totalRecords,
        int totalPages,
        List<ServiceTicket> data
) {}
