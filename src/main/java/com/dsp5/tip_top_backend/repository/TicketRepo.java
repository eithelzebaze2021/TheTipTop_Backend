package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    List<Ticket> findByIdClient(Long idClient);

    List<Ticket> findByIdGain(Long idGain);
}
