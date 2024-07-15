package fr.haronman.simlife.model;

import fr.haronman.simlife.controller.DiaryController;
import fr.haronman.simlife.controller.DiaryException;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Partie {
    private Joueur joueur;

    public Partie(Joueur j) {
        joueur = j;
    }

    public void annee_suivante(DiaryController dc) throws DiaryException {
        joueur.grandir();
        dc.passer_ligne();
        ecrire_journal(dc,
            "Âge : "+ joueur.getAge() +" an" + (joueur.getAge() > 1 ? "s" : ""), 
            15, 
            true
        );
        ecrire_journal(dc, "Test !", 12, false);
    }

    public void ecrire_journal(DiaryController dc, String texte, int size, boolean gras) throws DiaryException {
        dc.ajouter_au_journal(texte, size, gras);
    }
}
