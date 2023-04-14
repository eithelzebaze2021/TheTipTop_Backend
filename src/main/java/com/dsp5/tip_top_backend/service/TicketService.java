package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getTicketById(Long idTicket);
    Boolean saveTicketClient(String numTicket, Long idClient);
    Boolean saveTicketMagasin(Ticket t);
    List<Ticket> getAllTicket();
    List<Ticket> getAllTicketOfClient(Long idClient);
    List<Ticket> getAllTicketOfGain();
    Gain attribuerGain(List<Gain> listGain);
    List<Ticket> getTicketByIdMagasin(Long idM);
    Ticket updateTicket(Long t);
}
