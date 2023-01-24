package com.dsp5.tip_top_backend.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Utilisateur")
@Table(
        name = "utilisateur",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_mail_unique", columnNames = "mail")
        }
)
public class Utilisateur {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
            generator = "user_sequence")
    @Column(
            name = "id_user",
            updatable = false
    )
    private Long idUser;
    @Column(
            name = "id_role",
            nullable = false
    )
    private Long idRole;
    @Column(
            name = "nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nom;
    @Column(
            name = "prenom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String prenom;

    @Column(
            name = "adresse",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String adresse;
    @Column(
            name = "code_postal",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String code_postal;
    @Column(
            name = "mail",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String mail;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    public Utilisateur() {
    }

    public Utilisateur(Long idUser, Long idRole, String nom, String prenom, String adresse, String code_postal, String mail, String password) {
        this.idUser = idUser;
        this.idRole = idRole;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.mail = mail;
        this.password = password;
    }

    public Utilisateur(Long idRole, String nom,
                       String prenom, String adresse, String code_postal,
                       String mail, String password) {
        this.idRole = idRole;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.mail = mail;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}