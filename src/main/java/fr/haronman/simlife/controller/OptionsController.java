package fr.haronman.simlife.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class OptionsController {
    
    @FXML
    private void quitter_jeu() { Platform.exit(); }

    @FXML
    private void nouvelle_partie() {System.out.println("TODO Nouvelle partie");}
}
