package com.example.approject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOverScreenController implements Initializable {

    private Scene scene;
    private Stage stage;
    @FXML
    private Label score;

    @FXML
    private Label best;


    public void displayScore(String Yourscore,String BestScore) {
        score.setText("Score : "+Yourscore);
        best.setText("Best : "+BestScore);
    }

    public void restatGame(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(GameOverScreenController.class.getResource("start.fxml")).load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();
    }

    public void backHome(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Info_Screen1.fxml")).load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(890);
        stage.setHeight(475);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}