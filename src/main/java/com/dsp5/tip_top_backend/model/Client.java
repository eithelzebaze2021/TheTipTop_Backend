package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Client")
@Table(
        name = "client"
)
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "client_sequence")
    @Column(
            name = "id_client",
            updatable = false
    )
    private Long idClient;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "id_client")
    private List<Ticket> ticketList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private Utilisateur user_client;


    public Client() {
    }

    public Client(Long idClient, List<Ticket> ticketList, Utilisateur user_client) {
        this.idClient = idClient;
        this.ticketList = ticketList;
        this.user_client = user_client;
    }

    public Client(Utilisateur user_client) {
        this.user_client = user_client;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Utilisateur getUser_client() {
        return user_client;
    }

    public void setUser_client(Utilisateur user_client) {
        this.user_client = user_client;
    }
}
