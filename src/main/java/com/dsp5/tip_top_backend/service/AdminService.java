package com.dsp5.tip_top_backend.service;

import com.dsp5.tip_top_backend.model.Role;

import java.util.List;

public interface AdminService {

    Boolean saveRole(Role r);
    List<Role> getAllRole();
    List<String> getAllStrRole();
}
