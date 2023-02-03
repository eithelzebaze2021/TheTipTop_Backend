package com.dsp5.tip_top_backend.service.service_impl;

import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import com.dsp5.tip_top_backend.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger log = LogManager.getLogger("ADMIN SERVICE");

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> getAllRole() {
        return roleRepo.findAll();
    }

    @Override
    public List<String> getAllStrRole() {
        return roleRepo.findAllStrRole();
    }

    @Override
    public Boolean saveRole(Role r) {
        roleRepo.save(r);
        return true;
    }

}
