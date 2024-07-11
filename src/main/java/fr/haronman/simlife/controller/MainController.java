package fr.haronman.simlife.controller;

import javafx.fxml.FXML;
import lombok.Getter;

/**
 * Controlleur du jeu permettant de récupérer les différents controlleur des onglets
 * @author HaronMan
 */
public class MainController {
    @Getter @FXML
    private DiaryController diaryController;
    @Getter @FXML
    private OptionsController optionsController;
}
