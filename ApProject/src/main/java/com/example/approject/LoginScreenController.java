package com.example.approject;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private ImageView myImage2;

    @FXML
    private TextField Username;

    public void LoginasGuest(ActionEvent e) throws IOException{
//        URL url = Paths.get("Info_Screen.fxml").toUri().toURL();
//        root = FXMLLoader.load(url);
        Parent root = new FXMLLoader(getClass().getResource("Info_Screen.fxml")).load();
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Login(ActionEvent e) throws IOException{
        String user = Username.getText();
//        System.out.println(user);
        FXMLLoader loader = new FXMLLoader(LoginScreenController.class.getResource("Info_Screen1.fxml"));
//        Parent root = new FXMLLoader(getClass().getResource("Info_Screen1.fxml")).load();
        root=loader.load();

        Info_Screen_Controller controller = loader.getController();
        controller.displayTextFromScreen1(user);

        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setDuration(Duration.millis(1000));
        translate1.setNode(myImage2);
        translate1.setByX(700);
        translate1.play();
    }
}
