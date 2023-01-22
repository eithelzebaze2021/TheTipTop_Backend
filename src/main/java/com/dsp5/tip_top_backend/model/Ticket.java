package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Ticket")
@Table(
        name = "ticket"
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
            nullable = false
    )
    private Long idClient;

    @Column(
            name = "id_magasin",
            nullable = false
    )
    private Long idMagasin;

    @Column(
            name = "id_gain",
            nullable = false
    )
    private Long idGain;

    @Column(
            name = "montant",
            nullable = false
    )
    private Long montant;

    @Column(
            name = "numero",
            nullable = true
    )
    private Long numero;

    @Column(
            name = "gain_recu",
            nullable = false
    )
    private Boolean gainRecu;


    public Ticket() {
    }

    public Ticket(Long idTicket, Long idClient, Long idMagasin, Long idGain, Long montant, Long numero, Boolean gainRecu) {
        this.idTicket = idTicket;
        this.idClient = idClient;
        this.idMagasin = idMagasin;
        this.idGain = idGain;
        this.montant = montant;
        this.numero = numero;
        this.gainRecu = gainRecu;
    }

    public Ticket(Long idClient, Long idMagasin, Long idGain,
                  Long montant, Long numero, Boolean gainRecu) {
        this.idClient = idClient;
        this.idMagasin = idMagasin;
        this.idGain = idGain;
        this.montant = montant;
        this.numero = numero;
        this.gainRecu = gainRecu;
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

    public Long getIdGain() {
        return idGain;
    }

    public void setIdGain(Long idGain) {
        this.idGain = idGain;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Boolean getGainRecu() {
        return gainRecu;
    }

    public void setGainRecu(Boolean gainRecu) {
        this.gainRecu = gainRecu;
    }
}
