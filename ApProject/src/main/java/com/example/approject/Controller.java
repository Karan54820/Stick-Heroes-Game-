package com.example.approject;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private ImageView myImage;
    @FXML
    private ImageView Background;

    public void TapToPlay(ActionEvent e) throws IOException {
//        URL url = Paths.get("Login_Screen.fxml").toUri().toURL();
        Parent root = new FXMLLoader(getClass().getResource("Login_Screen.fxml")).load();
//        root = FXMLLoader.load(url);
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Fade Transition
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(1000));
        fade.setNode(Background);
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        // Translate--> myImage1
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(3000));
        translate.setNode(myImage);
        translate.setByX(890);
        //translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.play();
    }
}
