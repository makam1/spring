package com.sa.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode()
public class Operation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date;

    @Column(length = 9)
    private String montant;

    private BigInteger code;

    @JoinColumn(name = "utilisateur",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("operations")
    private Utilisateur utilisateur;

    @JoinColumn(name = "client",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("operations")
    private Type type;

    @ManyToOne(optional = false)
    private Client client;


    private int frais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getFrais() {
        return frais;
    }

    public void setFrais(int frais) {
        this.frais = frais;
    }


}
