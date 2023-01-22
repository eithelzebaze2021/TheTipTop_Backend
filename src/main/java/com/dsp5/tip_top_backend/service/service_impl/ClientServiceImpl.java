package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Client;
import com.dsp5.tip_top_backend.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class ClientServiceImpl implements ClientService {

    private final Logger log = LogManager.getLogger("CLIENT SERVICE");

    @Override
    public Client getClientById(Long idClient) {
        return null;
    }

    @Override
    public Client saveClient(Client c) {
        return null;
    }

    @Override
    public Boolean UpdateClient(Client c) {
        return null;
    }

    @Override
    public List<Client> getAllClient() {
        return null;
    }
}
