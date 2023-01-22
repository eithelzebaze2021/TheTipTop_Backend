package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Magasin;

import java.util.List;

public interface MagasinService {

    Magasin getMagasinById(Long idMagasin);
    Magasin saveMagasin(Magasin M);
    Boolean UpdateMagasinInfo(Magasin M);
    List<Magasin> getAllMagasin();

}
