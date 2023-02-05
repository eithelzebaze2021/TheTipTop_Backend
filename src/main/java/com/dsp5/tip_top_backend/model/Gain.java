package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Gain")
@Table(
        name = "gain",
        uniqueConstraints = {
        @UniqueConstraint(name = "gain_unique", columnNames = "nom_gain")
}
)
public class Gain {
    @Id
    @SequenceGenerator(
            name = "gain_sequence",
            sequenceName = "gain_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "gain_sequence")
    @Column(
            name = "id_gain",
            updatable = false
    )
    private Long idGain;
    @Column(
            name = "nom_gain",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Long nomGain;

    @Column(
            name = "nbre_ticket_restant",
            nullable = false
    )
    private Long nbreTicketRestant;

    public Gain() {
    }

    public Gain(Long idGain, Long nomGain, Long nbreTicketRestant) {
        this.idGain = idGain;
        this.nomGain = nomGain;
        this.nbreTicketRestant = nbreTicketRestant;
    }


    public Long getIdGain() {
        return idGain;
    }

    public void setIdGain(Long idGain) {
        this.idGain = idGain;
    }

    public Long getNomGain() {
        return nomGain;
    }

    public void setNomGain(Long nomGain) {
        this.nomGain = nomGain;
    }

    public Long getNbreTicketRestant() {
        return nbreTicketRestant;
    }

    public void setNbreTicketRestant(Long nbreTicketRestant) {
        this.nbreTicketRestant = nbreTicketRestant;
    }
}
