package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Ticket")
@Table(
        name = "ticket",
        uniqueConstraints = {
                @UniqueConstraint(name = "num_ticket_unique", columnNames = "numero")
        }
)
public class Ticket {

    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "ticket_sequence")
    @Column(
            name = "id_ticket",
            updatable = false
    )
    private Long idTicket;

    @Column(
            name = "id_client",
            nullable = true
    )
    private Long idClient;

    @Column(
            name = "id_gain",
            nullable = true
    )
    private Long idGain;

    @Column(
            name = "id_magasin",
            nullable = false
    )
    private Long idMagasin;

    @Column(
            name = "montant",
            nullable = false
    )
    private Long montant;

    @Column(
            name = "numero",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String numero;

    @Column(
            name = "gain_recu",
            nullable = false
    )
    private Boolean gainRecu;

    @ManyToOne
    // déclaration d'une table d'association
    @JoinTable(name = "gain_ticket",
            joinColumns = @JoinColumn(name = "id_ticket"),
            inverseJoinColumns = @JoinColumn(name = "id_gain"))
    private Gain gain;

    @ManyToOne
    // déclaration d'une table d'association
    @JoinTable(name = "client_ticket",
            joinColumns = @JoinColumn(name = "id_ticket"),
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    private Client client;

    @ManyToOne
    // déclaration d'une table d'association
    @JoinTable(name = "magasin_ticket",
            joinColumns = @JoinColumn(name = "id_ticket"),
            inverseJoinColumns = @JoinColumn(name = "id_magasin"))
    private Magasin magasin;


    public Ticket() {
    }

    public Ticket(Long idTicket, Long idClient, Long idMagasin, Long montant, String numero, Boolean gainRecu) {
        this.idTicket = idTicket;
        this.idClient = idClient;
        this.idMagasin = idMagasin;
        this.montant = montant;
        this.numero = numero;
        this.gainRecu = gainRecu;
    }

    public Ticket(Long idClient, Long idMagasin, Long montant, String numero, Boolean gainRecu, Gain gain) {
        this.idClient = idClient;
        this.idMagasin = idMagasin;
        this.montant = montant;
        this.numero = numero;
        this.gainRecu = gainRecu;
        this.gain = gain;
    }

    public Ticket(Long montant,
                  String numero, Boolean gainRecu, Gain gain,
                  Client client, Magasin magasin) {
        this.montant = montant;
        this.numero = numero;
        this.gainRecu = gainRecu;
        this.gain = gain;
        this.client = client;
        this.magasin = magasin;
    }

    public Ticket(Long montant,
                  String numero, Boolean gainRecu,
                  Gain gain,Magasin magasin) {
        this.montant = montant;
        this.numero = numero;
        this.gainRecu = gainRecu;
        this.gain = gain;
        this.magasin = magasin;
    }

    public Long getIdGain() {
        return idGain;
    }

    public void setIdGain(Long idGain) {
        this.idGain = idGain;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Gain getGain() {
        return gain;
    }

    public void setGain(Gain gain) {
        this.gain = gain;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(Long idMagasin) {
        this.idMagasin = idMagasin;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getGainRecu() {
        return gainRecu;
    }

    public void setGainRecu(Boolean gainRecu) {
        this.gainRecu = gainRecu;
    }
}
