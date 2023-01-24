package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Ticket;
import com.dsp5.tip_top_backend.repository.ClientRepo;
import com.dsp5.tip_top_backend.repository.GainRepo;
import com.dsp5.tip_top_backend.repository.TicketRepo;
import com.dsp5.tip_top_backend.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @Transactional
public class ClientServiceImpl implements ClientService {

    private final Logger log = LogManager.getLogger("Client SERVICE");

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private GainRepo gainRepo;

    @Override
    public Client getClientById(Long idClient) {
        return clientRepo.findById(idClient).get();
    }

    @Override
    public Client saveClient(Client c) {
        return clientRepo.save(c);
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }

    @Override
    public List<Gain> getAllGain(Long idClient, Integer first, Integer last) {

        Pageable limit = PageRequest.of(first,last);

        List<Ticket> allTicketClient = ticketRepo.findAll(limit).getContent();

        List<Gain> allGainClient = new ArrayList<Gain>();

        for (Ticket ticket : allTicketClient) {
            allGainClient.add(gainRepo.findById(ticket.getIdGain()).get());
        }

        return allGainClient;
    }
}
