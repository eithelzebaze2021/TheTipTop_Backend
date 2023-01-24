package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getTicketById(Long idTicket);
    Ticket saveTicket(Ticket t, List<Gain> listgainDispo);
    List<Ticket> getAllTicket();
    List<Ticket> getAllTicketOfClient(Long idClient);
    List<Ticket> getAllTicketOfGain(Long idGain);
    Gain attribuerGain(List<Gain> listGain);

}
