package com.sa.filrouge.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "utilisateurs")
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int etat;


    private int systeme;


    private int part;

    @JoinColumn(name = "operation",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("operations")
    private Operation operation;

    @JoinColumn(name = "partenaire",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"commissions","utilisateurs"})
    private Partenaire utilisateur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getSysteme() {
        return systeme;
    }

    public void setSysteme(int systeme) {
        this.systeme = systeme;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Partenaire getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Partenaire utilisateur) {
        this.utilisateur = utilisateur;
    }
}
