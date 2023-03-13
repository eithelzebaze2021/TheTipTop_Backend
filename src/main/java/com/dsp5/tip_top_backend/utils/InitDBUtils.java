package com.dsp5.tip_top_backend.utils;

import com.dsp5.tip_top_backend.model.*;
import com.dsp5.tip_top_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitDBUtils implements CommandLineRunner {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurRepo userRepo;

    @Autowired
    public RoleRepo roleRepo;

    @Autowired
    public ClientRepo clientRepo;

    @Autowired
    public EmployeRepo employeRepo;

    @Autowired
    public MagasinRepo magasinRepo;

    @Autowired
    public GainRepo gainRepo;

    @Autowired
    public TicketRepo ticketRepo;

    @Override
    public void run(String... args) throws Exception {

        //Init Role
        Role role1 = new Role(1,"ROLE_CLIENT");
        Role role2 = new Role(2,"ROLE_EMPLOYE");
        Role role3 = new Role(3,"ROLE_ADMIN");
        this.roleRepo.saveAll(Arrays.asList(role1,role2,role3));

        //Init user
        Utilisateur user1 = new Utilisateur(1,"Zebaze","Eithel","France",
                "95","eithel.zebaze@gmail.com", passwordEncoder.encode("1234"),"Vincenne");
        Utilisateur user2 = new Utilisateur(1,"Fopa","Armelle","France",
                "93","armelle.fopa@gmail.com",passwordEncoder.encode("1234"),"Vincenne");
        Utilisateur user3 = new Utilisateur(1,"Donna","Stephane","France",
                "75","stephane.donna@gmail.com",passwordEncoder.encode("1234"),"Vincenne");
        Utilisateur user4 = new Utilisateur(2,"employe","employe","Nice",
                "75","employe@gmail.com",passwordEncoder.encode("1234"),"Vincenne");
        Utilisateur user5 = new Utilisateur(3,"admin","admin","France",
                "75","admin@gmail.com",passwordEncoder.encode("1234"),"Vincenne");
        this.userRepo.save(user5);

        //Init Client
        Client client1 = new Client(user1);
        Client client2 = new Client(user2);
        Client client3 = new Client(user3);
        this.clientRepo.saveAll(Arrays.asList(client1,client2,client3));

        //Init Magasin
        Magasin magasin1 = new Magasin("Dsp5Magasin","Vincenne", "94","Vincenne");

        //Init Employe
        Employe employe1 = new Employe(magasin1,user4);
        this.employeRepo.save(employe1);

        Gain gain1 = this.gainRepo.save(new Gain("un infuseur à thé","assets/img/infuseur_the.png",900000L,"Un filtre à thé en acier, idéal pour infuser son thé dans une grande tasse.", 15L));
        Gain gain2 = this.gainRepo.save(new Gain("une boite de 100g d’un thé détox","assets/img/thetiptop-the-detox.png",300000L,"Un filtre à thé en acier, idéal pour infuser son thé dans une grande tasse.", 56L));
        Gain gain3 = this.gainRepo.save(new Gain("une boite bis de 100g d’un thé détox","assets/img/thetiptop-the-detox.png",150000L,"Un filtre à thé en acier, idéal pour infuser son thé dans une grande tasse.",56L));
        Gain gain4 = this.gainRepo.save(new Gain("un coffret découverte","assets/img/coffret1.jpg",90000L,"Découvrez nos deux thés signatures aux fleurs de cerisier, réunis dans un seul coffret.",39L));

        this.ticketRepo.save(new Ticket(client1.getIdClient(), gain1.getIdGain(), magasin1.getIdMagasin(),50L,"1235489643",false,gain1,client1,magasin1));
        this.ticketRepo.save(new Ticket(client2.getIdClient(), gain4.getIdGain(), magasin1.getIdMagasin(),60L,"1235489569",true,gain4,client2,magasin1));
        this.ticketRepo.save(new Ticket(magasin1.getIdMagasin(), 50L,"1235483248",false,magasin1));

    }
}