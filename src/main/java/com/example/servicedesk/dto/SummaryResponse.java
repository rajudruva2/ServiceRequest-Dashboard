package com.example.servicedesk.dto;

public record SummaryResponse(
        long total,
        long open,
        long inProgress,
        long resolved,
        long highPriority
) {}
