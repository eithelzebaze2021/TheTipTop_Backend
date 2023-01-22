package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.model.Utilisateur;

import java.util.List;

public interface ClientService {

    Client getClientById(Long idClient);
    Client saveClient(Client c);
    Boolean UpdateClient(Client c);
    List<Client> getAllClient();

}
