package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getTicketById(Long idTicket);
    Boolean saveTicketClient(String numTicket, Client C);
    Boolean saveTicketMagasin(Ticket t);
    List<Ticket> getAllTicket();
    List<Ticket> getAllTicketOfClient(Long idClient, Integer first,Integer last);
    List<Ticket> getAllTicketOfGain(Long idGain);
    Gain attribuerGain(List<Gain> listGain);

}
