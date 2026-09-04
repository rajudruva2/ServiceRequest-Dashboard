package com.example.servicedesk.repository;

import com.example.servicedesk.entity.ServiceTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTicketRepository extends JpaRepository<ServiceTicket, Long> {

    Page<ServiceTicket> findByTitleContainingIgnoreCaseOrRequesterContainingIgnoreCase(
            String title, String requester, Pageable pageable);

    long countByStatus(String status);

    long countByPriority(String priority);
}
