package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Employe;
import com.dsp5.tip_top_backend.model.Utilisateur;

import java.util.List;

public interface EmployeService {

    Employe getEmployeById(Long idEmploye);
    Employe saveEmploye(Employe E);
    Boolean UpdateEmployeMagasin(Long idEmploye, Long idMagasin);
    List<Employe> getAllEmploye();
    Employe getEmployeByIdUser(Long idU);
}
