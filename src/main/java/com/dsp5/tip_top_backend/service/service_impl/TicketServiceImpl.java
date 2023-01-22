package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Ticket;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.repository.TicketRepo;
import com.dsp5.tip_top_backend.repository.UtilisateurRepo;
import com.dsp5.tip_top_backend.service.TicketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    private final Logger log = LogManager.getLogger("TICKET SERVICE");
    @Override
    public Ticket getTicketById(Long idTicket) {
        return ticketRepo.findById(idTicket).get();
    }

    @Override
    public Ticket saveTicket(Ticket t) {
        return ticketRepo.save(t);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> getAllTicketOfClient(Long idClient) {
        return ticketRepo.findByIdClient();
    }

    @Override
    public List<Ticket> getAllTicketOfGain(Long idGain) {
        return ticketRepo.findByIdGain();
    }
}
