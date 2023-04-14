package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.repository.GainRepo;
import com.dsp5.tip_top_backend.service.GainService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class GainServiceImpl implements GainService {

    private final Logger log = LogManager.getLogger("GAIN SERVICE");

    @Autowired
    private GainRepo gainRepo;

    public GainServiceImpl() {
    }

    public GainServiceImpl(GainRepo gainRepo) {
        this.gainRepo = gainRepo;
    }

    @Override
    public Gain getGainById(Long idGain) {
        return gainRepo.findById(idGain).get();
    }

    @Override
    public Gain saveGain(Gain G) {
        return gainRepo.save(G);
    }

    @Override
    public Boolean UpdateGainTicketRestant(Long idGain, Long nbreTicketRestant) {
        Optional<Gain> gainBDRepo = gainRepo.findById(idGain);
        if(gainBDRepo.isPresent()){
            Gain gainBD = gainBDRepo.get();
            gainBD.setNbreTicketRestant(nbreTicketRestant);
            gainRepo.save(gainBD);
            return true;
        }
        return false;
    }

    @Override
    public List<Gain> getAllGain() {
        return gainRepo.findAllOrder();
    }

    @Override
    public List<Gain> getAllGainDispo() {
        List<Gain> listGain = gainRepo.findAll();
        return listGain.stream().filter(g -> g.getNbreTicketRestant()>0).toList();
    }
}
