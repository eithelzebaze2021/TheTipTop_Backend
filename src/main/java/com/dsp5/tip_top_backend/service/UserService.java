package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Utilisateur;

import java.util.List;

public interface UserService {
    Utilisateur getUserById(Long idUser);
    Utilisateur getUserByMail(String idMail);
    Boolean saveUser(Utilisateur u);
    Boolean UpdateUserInfo(Utilisateur u);
    Boolean UpdateUserIdentification(Long idUser, String mail, String password);
    Boolean updateRole(Long idUser,Long idRole);
    List<Utilisateur> getAllUser();

}
