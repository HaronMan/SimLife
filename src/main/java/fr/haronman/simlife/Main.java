package fr.haronman.simlife;

import fr.haronman.simlife.controller.DiaryController;
import fr.haronman.simlife.controller.MainController;
import fr.haronman.simlife.controller.OptionsController;
import fr.haronman.simlife.model.Joueur;
import fr.haronman.simlife.model.Partie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getClassLoader().getResource("fxml/main.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();

        Partie partie = new Partie(new Joueur("Doe", "Jane"));

        mainController.getDiaryController().setPartie(partie);
        mainController.getDiaryController().init();
        
        mainController.getOptionsController().setPartie(partie);

        primaryStage.setTitle("SimLife");
        primaryStage.setScene(new Scene(root));
        //primaryStage.setOnCloseRequest(e -> e.consume());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
