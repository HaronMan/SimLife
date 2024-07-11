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
}
