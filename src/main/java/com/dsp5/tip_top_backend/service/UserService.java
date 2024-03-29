package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.utils.LoginRequest;
import com.dsp5.tip_top_backend.model.Utilisateur;
import com.dsp5.tip_top_backend.utils.LoginResponse;

import java.util.List;

public interface UserService {
    Utilisateur getUserById(Long idUser);
    Utilisateur getUserByMail(String idMail);
    Boolean saveUser(Utilisateur u);
    Boolean UpdateUserInfo(Utilisateur u);
    Boolean UpdateUserIdentification(Long idUser, String mail, String password);
    Boolean updateRoleUser(Long idUser,Integer idRole);
    List<Utilisateur> getAllUser();
    LoginResponse login(LoginRequest loginRequest);
    List<String> getAllRoleForPublic();
    Utilisateur updateUser(Utilisateur u);
}
