package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getTicketById(Long idTicket);
    Ticket saveTicket(Ticket t);
    List<Ticket> getAllTicket();

}
