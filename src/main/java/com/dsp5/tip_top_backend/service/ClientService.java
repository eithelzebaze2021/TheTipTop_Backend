package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Utilisateur;

import java.util.List;

public interface ClientService {

    Client getClientById(Long idClient);
    Boolean saveClient(Client c);
    List<Client> getAllClient();
    List<Gain> getAllGain(Long idClient, Integer first, Integer last);

}
