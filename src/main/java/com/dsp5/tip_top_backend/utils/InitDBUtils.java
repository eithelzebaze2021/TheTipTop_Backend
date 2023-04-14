/*package com.dsp5.tip_top_backend.utils;

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
                "75","employe@gmail.com",passwordEncoder.encode("1234"),"Nice");

        Utilisateur user6 = new Utilisateur(2,"employe2","employe","Nice",
                "75","employe2@gmail.com",passwordEncoder.encode("1234"),"Nice");

        Utilisateur user7 = new Utilisateur(2,"employe3","employe","Nice",
                "75","employe3@gmail.com",passwordEncoder.encode("1234"),"Nice");

        Utilisateur user8 = new Utilisateur(2,"employe4","employe","Nice",
                "75","employe4@gmail.com",passwordEncoder.encode("1234"),"Nice");

        Utilisateur user5 = new Utilisateur(3,"admin","admin","France",
                "75","admin@gmail.com",passwordEncoder.encode("1234"),"Vincenne");
        this.userRepo.save(user5);

        //Init Client
        Client client1 = new Client(user1);
        Client client2 = new Client(user2);
        Client client3 = new Client(user3);
        this.clientRepo.saveAll(Arrays.asList(client1,client2,client3));

        //Init Magasin
        Magasin magasin1 = new Magasin("ThéTipTopParis1","Paris", "75000","Paris");
        Magasin magasin2 = new Magasin("ThéTipTopNice1","Nice", "0600","Nice");
        Magasin magasin3 = new Magasin("ThéTipTopNice2","Nice", "06100","Nice");
        Magasin magasin4 = new Magasin("ThéTipTopParis2","Paris", "75100","Paris");

        //Init Employe
        Employe employe1 = new Employe(magasin1,user4);
        Employe employe2 = new Employe(magasin2,user6);
        Employe employe3 = new Employe(magasin3,user7);
        Employe employe4 = new Employe(magasin4,user8);
        this.employeRepo.saveAll(Arrays.asList(employe1,employe2,employe3,employe4));

        Gain gain1 = this.gainRepo.save(new Gain("un infuseur à thé","assets/img/infuseur_the.png",899999L,"Un filtre à thé en acier, idéal pour infuser son thé dans une grande tasse.", 15L));
        Gain gain2 = this.gainRepo.save(new Gain("une boite de 100g d’un thé détox","assets/img/thetiptop-the-detox.png",300000L,"Appréciez nos deux thés détox dans une grande tasse.", 56L));
        Gain gain3 = this.gainRepo.save(new Gain("une boite bis de 100g d’un thé signature","assets/img/thetiptop-the-detox.png",150000L,"Découvrez nos deux thés signatures dans une grande tasse.",56L));
        Gain gain4 = this.gainRepo.save(new Gain("un coffret découverte","assets/img/coffret1.jpg",89999L,"Découvrez nos deux thés signatures aux fleurs de cerisier, réunis dans un seul coffret.",39L));
        Gain gain5 = this.gainRepo.save(new Gain("un coffret découverte","assets/img/coffret2.png",60000L,"Toutes les saveurs de nos thés signatures réunies en un seul coffret découverte",69L));

        this.ticketRepo.save(new Ticket(client1.getIdClient(), gain1.getIdGain(), magasin4.getIdMagasin(),50L,"4235489643",false,gain1,client1,magasin4));
        this.ticketRepo.save(new Ticket(client2.getIdClient(), gain4.getIdGain(), magasin4.getIdMagasin(),60L,"4235489569",true,gain4,client2,magasin4));

        //Mag 1 Ticket
        this.ticketRepo.save(new Ticket(magasin1.getIdMagasin(), 50L,"1235483248",false,magasin1));
        this.ticketRepo.save(new Ticket(magasin1.getIdMagasin(), 48L,"1235483243",false,magasin1));
        this.ticketRepo.save(new Ticket(magasin1.getIdMagasin(), 50L,"1235483648",false,magasin1));
        this.ticketRepo.save(new Ticket(magasin1.getIdMagasin(), 48L,"1235483443",false,magasin1));
        this.ticketRepo.save(new Ticket(magasin1.getIdMagasin(), 50L,"1235463248",false,magasin1));
        this.ticketRepo.save(new Ticket(magasin1.getIdMagasin(), 48L,"1239483243",false,magasin1));

        //Mag 2 Ticket
        this.ticketRepo.save(new Ticket(magasin2.getIdMagasin(), 50L,"2235483248",false,magasin2));
        this.ticketRepo.save(new Ticket(magasin2.getIdMagasin(), 48L,"2235483243",false,magasin2));
        this.ticketRepo.save(new Ticket(magasin2.getIdMagasin(), 50L,"2235483648",false,magasin2));
        this.ticketRepo.save(new Ticket(magasin2.getIdMagasin(), 48L,"2235483443",false,magasin2));
        this.ticketRepo.save(new Ticket(magasin2.getIdMagasin(), 50L,"2235463248",false,magasin2));
        this.ticketRepo.save(new Ticket(magasin2.getIdMagasin(), 48L,"2239483243",false,magasin2));


        //Mag 2 Ticket
        this.ticketRepo.save(new Ticket(magasin3.getIdMagasin(), 50L,"3235483248",false,magasin3));
        this.ticketRepo.save(new Ticket(magasin3.getIdMagasin(), 48L,"3235483243",false,magasin3));
        this.ticketRepo.save(new Ticket(magasin3.getIdMagasin(), 50L,"3235483648",false,magasin3));
        this.ticketRepo.save(new Ticket(magasin3.getIdMagasin(), 48L,"3235483443",false,magasin3));
        this.ticketRepo.save(new Ticket(magasin3.getIdMagasin(), 50L,"3235463248",false,magasin3));
        this.ticketRepo.save(new Ticket(magasin3.getIdMagasin(), 48L,"3239483243",false,magasin3));



    }
}*/