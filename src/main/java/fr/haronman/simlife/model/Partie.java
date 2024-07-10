package fr.haronman.simlife.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partie {
    private Joueur joueur;

    public Partie(Joueur j) {
        joueur = j;
    }

    public void annee_suivante() {
        joueur.grandir();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}
