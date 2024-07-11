package fr.haronman.simlife.controller;

import fr.haronman.simlife.model.Partie;
import javafx.application.Platform;
import javafx.fxml.FXML;
import lombok.Setter;

/**
 * Controlleur de l'onglet des options
 * @author HaronMan
 */
public class OptionsController {

    @Setter
    private Partie partie;

    /**
     * ! TODO 
     * Permet de créer une nouvelle partie
     */
    @FXML
    private void nouvelle_partie() {System.out.println("TODO Nouvelle partie");}

    /**
     * Permet de quitter le jeu
     */
    @FXML
    private void quitter_jeu() { Platform.exit(); }
}
