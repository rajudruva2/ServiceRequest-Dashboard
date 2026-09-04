package com.example.servicedesk.dto;

import jakarta.validation.constraints.NotBlank;

public record TicketRequest(
        @NotBlank String title,
        @NotBlank String requester,
        @NotBlank String category,
        @NotBlank String priority,
        @NotBlank String assignedTo
) {}
