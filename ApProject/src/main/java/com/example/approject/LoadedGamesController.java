package com.example.approject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadedGamesController {

    private Stage stage;
    private Scene scene;

    public void LoadSavedGame(ActionEvent e) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        in = new ObjectInputStream(new FileInputStream("out.txt"));
        Score s1 = (Score) in.readObject();
        Stick.setBstsc(s1.getBest());
        Parent root = new FXMLLoader(getClass().getResource("start.fxml")).load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(310);
        stage.setHeight(664);
        stage.setResizable(false);
        stage.show();
    }
}
