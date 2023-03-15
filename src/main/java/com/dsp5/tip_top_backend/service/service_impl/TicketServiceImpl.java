package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Ticket;
import com.dsp5.tip_top_backend.repository.GainRepo;
import com.dsp5.tip_top_backend.repository.TicketRepo;
import com.dsp5.tip_top_backend.service.GainService;
import com.dsp5.tip_top_backend.service.TicketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service @Transactional
public class TicketServiceImpl implements TicketService {

    private final Logger log = LogManager.getLogger("TICKET SERVICE");
    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private GainRepo gainRepo;

    @Autowired
    private GainService gainService;

    @Override
    public Ticket getTicketById(Long idTicket) {
        return ticketRepo.findById(idTicket).get();
    }

    @Override
    public Boolean saveTicketClient(String numTicket, Long idClient) {

        List<Gain> listgainDispo = gainRepo.findGainDispo();

        Client C = clientRepo.findById(idClient).get();

        Gain gainClient = attribuerGain(listgainDispo);

        gainClient.setNbreTicketRestant(gainClient.getNbreTicketRestant()-1);

        Ticket t = ticketRepo.findByNumTicket(numTicket);

        if(t!=null){
            var g = gainService.saveGain(gainClient);
            t.setGain(g);
            t.setClient(C);
            t.setIdGain(g.getIdGain());
            t.setIdClient(C.getIdClient());
            ticketRepo.save(t);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean saveTicketMagasin(Ticket t) {
        if (ticketRepo.save(t) != null) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> getAllTicketOfClient(Long idClient) {

        return ticketRepo.findByIdClient(idClient);
    }

    @Override
    public List<Ticket> getAllTicketOfGain() {
        return ticketRepo.findByIdGainNotNull();
    }

    @Override
    public Gain attribuerGain(List<Gain> listGain) {

        Random r = new Random();
        int n = r.nextInt(listGain.size());
        return listGain.get(n);
    }

    @Override
    public List<Ticket> getTicketByIdMagasin(Long idM) {
        return ticketRepo.findByIdMagasin(idM);
    }
}
