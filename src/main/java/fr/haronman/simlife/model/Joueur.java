package fr.haronman.simlife.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Joueur {
    private String nom;
    private String prenom;
    private int age;
    private long argent;

    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        age = 0;
        argent = 0;
    }

    public void grandir() { age++; }
}
