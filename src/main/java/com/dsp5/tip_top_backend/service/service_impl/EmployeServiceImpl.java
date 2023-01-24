package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Employe;
import com.dsp5.tip_top_backend.model.Magasin;
import com.dsp5.tip_top_backend.repository.EmployeRepo;
import com.dsp5.tip_top_backend.repository.MagasinRepo;
import com.dsp5.tip_top_backend.service.EmployeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class EmployeServiceImpl implements EmployeService {

    private final Logger log = LogManager.getLogger("EMPLOYE SERVICE");

    @Autowired
    private EmployeRepo employeRepo;

    @Autowired
    private MagasinRepo magasinRepo;

    @Override
    public Employe getEmployeById(Long idEmploye) {
        return employeRepo.findById(idEmploye).get();
    }

    @Override
    public Employe saveEmploye(Employe E) {
        return employeRepo.save(E);
    }

    @Override
    public Boolean UpdateEmployeMagasin(Long idEmploye, Long idMagasin) {
        Optional<Employe> employeBDrepo = employeRepo.findById(idEmploye);
        Optional<Magasin> magasinBDrepo = magasinRepo.findById(idMagasin);
        if(employeBDrepo.isPresent() && magasinBDrepo.isPresent()){
            Employe employeBD = employeBDrepo.get();
            employeBD.setMagasin_empl(magasinBDrepo.get());
            employeRepo.save(employeBD);
            return true;
        }
        return false;
    }

    @Override
    public List<Employe> getAllEmploye() {
        return employeRepo.findAll();
    }
}
