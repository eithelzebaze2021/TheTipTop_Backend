package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Employe;
import com.dsp5.tip_top_backend.model.Gain;

import java.util.List;

public interface GainService {

    Gain getGainById(Long idGain);
    Gain saveGain(Gain G);
    Boolean UpdateGainTicketRestant(Long idGain, Long nbreTicketRestant);
    List<Gain> getAllGain();
    List<Gain> getAllGainDispo();

}
