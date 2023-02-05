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
    public Client getClientByIdClient(Long idClient) {
        log.debug("Trouver le client dont l'idClient est : {} ", idClient);
        return clientRepo.findById(idClient).get();
    }

    @Override
    public Client getClientByIdUser(Long idUser) {
        log.debug("Trouver le client dont l'idClient est : {} ", idUser);
        return clientRepo.findByIdUser(idUser).get();
    }

    @Override
    public Boolean saveClient(Client c) {
        log.debug("Enregistrer le client dont le mail est : {}", c.getUser_client().getMail());

        if(clientRepo.save(c)!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepo.findAll();
    }
}
