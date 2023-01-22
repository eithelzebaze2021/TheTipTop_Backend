package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Magasin;
import com.dsp5.tip_top_backend.repository.MagasinRepo;
import com.dsp5.tip_top_backend.service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Transactional
public class MagasinServiceImpl implements MagasinService {

    @Autowired
    private MagasinRepo magasinRepo;

    @Override
    public Magasin getMagasinById(Long idMagasin) {
        return magasinRepo.findById(idMagasin).get();
    }

    @Override
    public Magasin saveMagasin(Magasin M) {
        return magasinRepo.save(M);
    }

    @Override
    public Boolean UpdateMagasinInfo(Magasin M) {
        Optional<Magasin> magasinBDRepo = magasinRepo.findById(M.getIdMagasin());
        if(magasinBDRepo.isPresent()){
            Magasin magasinBD = magasinBDRepo.get();
            magasinBD.setAdresse(M.getAdresse());
            magasinBD.setNomMagasin(M.getNomMagasin());
            magasinBD.setCode_postal(M.getCode_postal());
            magasinRepo.save(magasinBD);
            return true;
        }
        return false;
    }

    @Override
    public List<Magasin> getAllMagasin() {
        return magasinRepo.findAll();
    }
}
