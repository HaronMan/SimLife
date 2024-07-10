package fr.haronman.simlife.controller;

import fr.haronman.simlife.model.Partie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.Setter;

public class DiaryController {
    
    @FXML
    private Label label_nom;
    @FXML
    private Label label_age;
    @FXML
    private Label label_argent;

    @Setter
    private Partie partie;

    public void init() {
        label_nom.setText(String.format("%s %s", 
            partie.getJoueur().getPrenom(), partie.getJoueur().getNom()
        ));
    }

    @FXML
    private void annee_suivante() {
        partie.annee_suivante();
        label_age.setText(
            "Age : " + partie.getJoueur().getAge()
        );
    }
}
