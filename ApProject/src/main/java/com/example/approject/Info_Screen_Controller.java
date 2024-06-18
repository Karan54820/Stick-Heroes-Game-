package com.example.approject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class Info_Screen_Controller implements Initializable {

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Label user;

    public void displayTextFromScreen1(String text) {
        user.setText(text);
    }

    public void  StartGame(ActionEvent e) throws IOException{

        Parent root = new FXMLLoader(getClass().getResource("start.fxml")).load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(310);
        stage.setHeight(664);
        stage.setResizable(false);
        stage.show();
    }

    public void SaveGame(ActionEvent e) throws IOException {
        Score s = new Score(Stick.getBstsc());
        ObjectOutputStream out = null;
        out = new ObjectOutputStream(new FileOutputStream("out.txt"));
        out.writeObject(s);
        out.close();
        System.out.println("Game saved Successfully");
    }

    public void QuitGame(ActionEvent e){
        exit(0);
    }

    public void LoadGame(ActionEvent e) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("LoadedGames.fxml")).load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
