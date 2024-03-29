package com.dsp5.tip_top_backend.repository;

import com.dsp5.tip_top_backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query(name = "Ticket.findByIdClient", value = "select * from Ticket t where t.id_client=:idClient", nativeQuery = true)
    List<Ticket> findByIdClient(@Param("idClient")Long idClient);

    @Query(name = "Ticket.findByIdGain", value = "select * from Ticket t where t.id_gain=:idGain", nativeQuery = true)
    List<Ticket> findByIdGain(@Param("idGain")Long idGain);

    @Query(name = "Ticket.findByIdGainNotNull", value = "select * from Ticket t where t.id_gain IS NOT NULL", nativeQuery = true)
    List<Ticket> findByIdGainNotNull();

    @Query(name = "Ticket.findByNumTicket", value = "select * from Ticket t where t.numero=:numTicket", nativeQuery = true)
    Ticket findByNumTicket(@Param("numTicket")String numTicket);

    @Query(name = "Ticket.findByIdMagasin", value = "select * from Ticket t where t.id_magasin=:idM", nativeQuery = true)
    List<Ticket> findByIdMagasin(@Param("idM")Long idM);
}
