package com.dsp5.tip_top_backend.admin;

import com.dsp5.tip_top_backend.model.Role;
import com.dsp5.tip_top_backend.model.Ticket;
import com.dsp5.tip_top_backend.repository.RoleRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void findAllStrRole() {
        //given
        Role role = new Role(
                0,
                "client"
        );
        roleRepo.save(role);

        //when
        List<String> roleList = roleRepo.findAllStrRole();

        //then
        assertTrue(roleList.stream().findAny().isPresent());
        // assertEquals(gainList.get(0),gain);
        assertEquals(roleList.equals(role),role.equals(roleRepo.findAllStrRole()));

    }

    @Test
    void findStrRoleById() {
        //given
        Role role = new Role(
                0,
                "ROLE_CLIENT"
        );
        role = roleRepo.save(role);

        //when
        String roleById = roleRepo.findStrRoleById(role.getIdRole());

        //then
        assertEquals(role.getNom(),roleById);

    }

    @Test
    void findIdRoleByStr() {
        //given
        Role role = new Role(
                0,
                "ROLE_CLIENT"
        );
        role = roleRepo.save(role);

        //when
        Integer roleById = roleRepo.findIdRoleByStr(role.getNom());

        //then
        assertEquals(role.getIdRole(),roleById);
    }
}
