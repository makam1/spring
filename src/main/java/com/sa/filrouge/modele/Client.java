package com.sa.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode(exclude = "partenaire")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private  String nomenvoyeur;

    @Column(length = 30)
    private String prenomenvoyeur;

    @Column(length = 15)
    private String telephoneenvoyeur;

    @Column(length = 20)
    private String ncienvoyeur;

    @Column(length = 10)
    private String nombeneficiaire;

    @Column(length = 30)
    private String prenombeneficiaire;


    @Column(length = 15)
    private String telephonebeneficiaire;


    @Column(length = 20)
    private String ncibeneficiaire;


    @JoinColumn(name = "partenaire",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("clients")
    private Partenaire partanaire;

    @Column(length = 9)
    private int montant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomenvoyeur() {
        return nomenvoyeur;
    }

    public void setNomenvoyeur(String nomenvoyeur) {
        this.nomenvoyeur = nomenvoyeur;
    }

    public String getPrenomenvoyeur() {
        return prenomenvoyeur;
    }

    public void setPrenomenvoyeur(String prenomenvoyeur) {
        this.prenomenvoyeur = prenomenvoyeur;
    }

    public String getTelephoneenvoyeur() {
        return telephoneenvoyeur;
    }

    public void setTelephoneenvoyeur(String telephoneenvoyeur) {
        this.telephoneenvoyeur = telephoneenvoyeur;
    }

    public String getNcienvoyeur() {
        return ncienvoyeur;
    }

    public void setNcienvoyeur(String ncienvoyeur) {
        this.ncienvoyeur = ncienvoyeur;
    }

    public String getNombeneficiaire() {
        return nombeneficiaire;
    }

    public void setNombeneficiaire(String nombeneficiaire) {
        this.nombeneficiaire = nombeneficiaire;
    }

    public String getPrenombeneficiaire() {
        return prenombeneficiaire;
    }

    public void setPrenombeneficiaire(String prenombeneficiaire) {
        this.prenombeneficiaire = prenombeneficiaire;
    }

    public String getTelephonebeneficiaire() {
        return telephonebeneficiaire;
    }

    public void setTelephonebeneficiaire(String telephonebeneficiaire) {
        this.telephonebeneficiaire = telephonebeneficiaire;
    }

    public String getNcibeneficiaire() {
        return ncibeneficiaire;
    }

    public void setNcibeneficiaire(String ncibeneficiaire) {
        this.ncibeneficiaire = ncibeneficiaire;
    }

    public Partenaire getPartanaire() {
        return partanaire;
    }

    public void setPartanaire(Partenaire partanaire) {
        this.partanaire = partanaire;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
