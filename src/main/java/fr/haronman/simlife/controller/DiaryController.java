package fr.haronman.simlife.controller;

import fr.haronman.simlife.model.Partie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lombok.Setter;

/**
 * Controlleur de l'onglet du journal
 * @author HaronMan
 */
public class DiaryController {
    
    @FXML
    private Label label_nom;
    @FXML
    private Label label_age;
    @FXML
    private Label label_argent;
    @FXML
    private ScrollPane affichage_journal;
    @FXML
    private VBox journal;

    @Setter
    private Partie partie;

    /**
     * Initialise l'affichage de l'onglet Journal
     * @throws DiaryException 
     */
    public void init() throws DiaryException {
        label_nom.setText(String.format("%s %s", 
            partie.getJoueur().getPrenom(), partie.getJoueur().getNom()
        ));
        label_age.setText("Âge : 0 an");
        label_argent.setText("Argent : 0 $");
    
        ajouter_au_journal(
            "Âge : 0 an", 
            15, 
            true
        );
    }

    /**
     * Permet de passer à l'année suivante
     * @throws DiaryException 
     */
    @FXML
    private void annee_suivante() throws DiaryException {
        partie.annee_suivante(this);
        
        update_infos_menu();
    }

    /**
     * Ajoute du texte au journal avec la possibilité de 
     * choisir la taille et la mise en gras
     * 
     * @param texte Text à afficher
     * @param size Taille du texte
     * @param gras En gras si true
     * @throws DiaryException 
     */
    public void ajouter_au_journal(String texte, int size, boolean gras) throws DiaryException {
        try {
            if(texte == null) {
                throw new DiaryException("Text to add must be not null !");
            } 
            if (size <= 0) {
                throw new DiaryException("Size of the font must be over zero !");
            }
            Text txt = new Text(texte);
            txt.setFont(Font.font(
                "Arial", 
                gras ? FontWeight.BOLD : FontWeight.NORMAL,
                size
            ));

            journal.getChildren().add(txt);
            // Fait automatiquement défiler vers le bas
            affichage_journal.vvalueProperty().bind(journal.heightProperty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de mettre à jour les infos du menu de personnage
     */
    public void update_infos_menu() {
        int age = partie.getJoueur().getAge();
        long argent = partie.getJoueur().getArgent();

        label_age.setText(
            "Âge : " + age + " an" + (age > 1 ? "s" : "")
        );
        label_argent.setText(
            "Argent : " + argent + " $"
        );
    }

    /**
     * Ajoute une ligne vide dans le journal
     */
    public void passer_ligne() {
        journal.getChildren().add(new Text());
    }
}
