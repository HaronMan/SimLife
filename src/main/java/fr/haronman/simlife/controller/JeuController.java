package fr.haronman.simlife.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class JeuController {
    
    @FXML
    private void quitterJeu() { Platform.exit(); }
}
