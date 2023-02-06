package com.dsp5.tip_top_backend.admin;

import com.dsp5.tip_top_backend.repository.RoleRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RoleRepoTest {
    @Autowired
    private RoleRepo roleRepo;

    @AfterEach
    void tearDown(){
        roleRepo.deleteAll();
    }

    @BeforeEach
    void setUp(){

    }

}
