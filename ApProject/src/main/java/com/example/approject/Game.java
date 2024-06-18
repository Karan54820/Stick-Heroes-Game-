package com.example.approject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.net.URL;
import java.nio.file.Paths;

public class Game extends Application {

    public void StartGame(Player P){

    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{
            URL url = Paths.get("Welcome_Screen.fxml").toUri().toURL();
            Parent root = new FXMLLoader(getClass().getResource("Welcome_Screen.fxml")).load();
//            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
//            Image icon = new Image("../../../../../icon.png");
            stage.getIcons().add(new Image(Game.class.getResourceAsStream("icon.png")));
            stage.setWidth(890);
            stage.setHeight(475);
            stage.setTitle("STICK HERO");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
