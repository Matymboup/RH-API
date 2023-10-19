package com.example.rh.rhapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data


@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;
    private String nomDeFamille;
    private String mail;
    private  String password;

    public Employe(String prenom, String nomDeFamille, String mail, String password) {
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.mail = mail;
        this.password = password;
    }

    public Employe() {
    }
}
