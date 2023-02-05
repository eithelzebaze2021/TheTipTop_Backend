package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Gain;
import com.dsp5.tip_top_backend.model.Utilisateur;

import java.util.List;

public interface ClientService {

    Client getClientByIdClient(Long idClient);
    Client getClientByIdUser(Long idUser);
    Boolean saveClient(Client c);
    List<Client> getAllClient();

}
