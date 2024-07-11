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
     */
    public void init() {
        add_to_journal(
            "Âge : 0 an", 
            15, 
            true
        );
        label_nom.setText(String.format("%s %s", 
            partie.getJoueur().getPrenom(), partie.getJoueur().getNom()
        ));
        label_age.setText("Age : 0");
        label_age.setText("Argent : 0 $");
    }

    /**
     * Permet de passer à l'année suivante
     */
    @FXML
    private void annee_suivante() {
        partie.annee_suivante();
        add_to_journal(
            "Âge : "+partie.getJoueur().getAge()+" ans", 
            15, 
            true
        );
        label_age.setText(
            "Age : " + partie.getJoueur().getAge()
        );
        label_argent.setText(
            "Argent : " + partie.getJoueur().getArgent() + " $"
        );
    }

    /**
     * Ajoute du texte au journal avec la possibilité de 
     * choisir la taille et la mise en gras
     * 
     * @param texte Text à afficher
     * @param size Taille du texte
     * @param gras En gras si true
     */
    public void add_to_journal(String texte, int size, boolean gras) {
        Text txt = new Text(texte);
        txt.setFont(Font.font(
            "Arial", 
            gras ? FontWeight.BOLD : FontWeight.NORMAL,
            size
        ));

        journal.getChildren().add(txt);
        // Fait automatiquement défiler vers le bas
        affichage_journal.vvalueProperty().bind(journal.heightProperty());
    }
}
