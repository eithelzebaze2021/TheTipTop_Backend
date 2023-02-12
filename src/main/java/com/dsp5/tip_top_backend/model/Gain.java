package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Gain")
@Table(
        name = "gain"
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
    private String nomGain;

    @Column(
            name = "nbre_ticket_restant",
            nullable = false
    )
    private Long nbreTicketRestant;

    @Column(
            name = "lien_image_gain",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String lienImageGain;

    @Column(
            name = "description",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "prix_gain",
            nullable = true
    )
    private Long prixGain;

    public Gain() {
    }

    public Gain(String nomGain, String lienImageGain, Long nbreTicketRestant, String description, Long prixGain) {
        this.nomGain = nomGain;
        this.nbreTicketRestant = nbreTicketRestant;
        this.lienImageGain = lienImageGain;
        this.description = description;
        this.prixGain = prixGain;
    }

    public String getLienImageGain() {
        return lienImageGain;
    }

    public void setLienImageGain(String lienImageGain) {
        this.lienImageGain = lienImageGain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdGain() {
        return idGain;
    }

    public void setIdGain(Long idGain) {
        this.idGain = idGain;
    }

    public String getNomGain() {
        return nomGain;
    }

    public void setNomGain(String nomGain) {
        this.nomGain = nomGain;
    }

    public Long getNbreTicketRestant() {
        return nbreTicketRestant;
    }

    public void setNbreTicketRestant(Long nbreTicketRestant) {
        this.nbreTicketRestant = nbreTicketRestant;
    }

    public Long getPrixGain() {
        return prixGain;
    }

    public void setPrixGain(Long prixGain) {
        this.prixGain = prixGain;
    }
}
