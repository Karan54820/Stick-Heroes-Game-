package com.example.approject;

import javafx.animation.*;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Stick implements Initializable {

    private Scene scene;
    private Stage stage;
    private Parent root;
    private int stickLength;
    boolean flag1 = true;

    private static int bstsc=0;

    public static int getBstsc() {
        return bstsc;
    }

    public static void setBstsc(int bstsc) {
        bstsc = bstsc;
    }

    @FXML
    private Label sc_show;
    private int sc =0;
    private Rectangle newRectangle;
    private Timeline increaseHeightTimeline;

    @FXML
    private Rectangle Stick;
    @FXML
    private Timeline extendTimeline;

    @FXML
    private Button Increment;

    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView playerId;

    @FXML
    private Rectangle platform;



    @FXML
    public void IncreaseLength() throws IOException {

        //Stick.setX(platform.getLayoutX());

        increaseHeightTimeline = new Timeline(new KeyFrame(Duration.millis(100), event2 ->{
            if(Stick.getHeight() <= 312){
                Stick.setHeight(Stick.getHeight()*1.25);
            }

        }));
        increaseHeightTimeline.setCycleCount(Timeline.INDEFINITE);
        increaseHeightTimeline.play();

    }

    public void GameOver() throws IOException {
        if (sc >= bstsc) {
            bstsc = sc;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
        root = loader.load();

        GameOverScreenController gm = loader.getController();
        gm.displayScore(String.valueOf(sc), String.valueOf(bstsc));

        stage = (Stage) Increment.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void dropStick() throws Exception {

        increaseHeightTimeline.stop();
        double pivotX1 = Stick.getX() + Stick.getWidth() / 2;
        double pivotY1 = Stick.getY() + Stick.getHeight();
        Rotate rotation1 = new Rotate(0, pivotX1, pivotY1);
        Stick.getTransforms().add(rotation1);
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rotation1.angleProperty(), 0)),
                new KeyFrame(Duration.millis(500), new KeyValue(rotation1.angleProperty(), 90)));
//        timeline.play();

//        timeline.stop();
        TranslateTransition translate = new TranslateTransition();
        translate.setDuration(Duration.millis(1000));
        translate.setNode(playerId);
        translate.setByX(Stick.getHeight());
        //translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.play();



        if(Stick.getHeight()+Stick.getLayoutX() > newRectangle.getLayoutX()+newRectangle.getWidth() || Stick.getHeight()+Stick.getLayoutX() < newRectangle.getLayoutX()){
            //Drop player
            TranslateTransition gameOver = new TranslateTransition();
            gameOver.setDuration(Duration.seconds(1));
            gameOver.setNode(playerId);
            gameOver.setByY(500);
            //gameOver.play();
//            double pivotX2 = Stick.getX() + Stick.getWidth() / 2;
//            double pivotY2 = Stick.getY() + Stick.getHeight();
            Rotate rt2 = new Rotate(0, pivotX1, pivotY1);
            Stick.getTransforms().add(rt2);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rt2.angleProperty(), 0)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(rt2.angleProperty(), 90)));
            SequentialTransition mySequence = new SequentialTransition(timeline, translate, new ParallelTransition(gameOver, timeline1));
            mySequence.play();
            mySequence.setOnFinished(event -> {
                try {
                    GameOver();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }
        else {
            sc++;
            sc_show.setText(String.valueOf(sc));
            double finalXPosition = newRectangle.getLayoutX() - platform.getWidth() + newRectangle.getWidth() + playerId.getTranslateX()- platform.getLayoutX() ;
            System.out.println("Final X Position: " + finalXPosition);
            TranslateTransition tt1 = new TranslateTransition(Duration.seconds(1), playerId);
            tt1.setNode(playerId);
            tt1.setToX(finalXPosition);
            System.out.println(newRectangle.getTranslateX() - platform.getWidth() + newRectangle.getWidth() + playerId.getTranslateX());
//            playerId.setLayoutX(platform.getLayoutX() + platform.getWidth() - Stick.getWidth());
//            playerId.setX(playerId.getTranslateX());
//            System.out.println(newRectangle.getLayoutX()-platform.getWidth()+newRectangle.getWidth()+playerId.getTranslateX());
//            System.out.println(Stick.getHeight());

            TranslateTransition ahead = new TranslateTransition();
            ahead.setDuration(Duration.seconds(1));
            ahead.setNode(newRectangle);
            ahead.setByX(-190);
//            newRectangle.setX(newRectangle.getTranslateX());

            TranslateTransition ahead1 = new TranslateTransition();
            ahead1.setDuration(Duration.seconds(1));
            ahead1.setNode(playerId);
            ahead1.setByX(-190);
//            playerId.setX(playerId.getTranslateX());

            TranslateTransition ahead2 = new TranslateTransition();
            ahead2.setDuration(Duration.seconds(1));
            ahead2.setNode(Stick);
            ahead2.setByX(-190);
//            Stick.setX(Stick.getTranslateX());

            TranslateTransition ahead3 = new TranslateTransition();
            ahead3.setDuration(Duration.seconds(1));
            ahead3.setNode(platform);
            ahead3.setByX(-190);
//            platform.setX(platform.getTranslateX());

            SequentialTransition mySequence = new SequentialTransition(timeline, tt1,new ParallelTransition(ahead,ahead1,ahead2,ahead3));
            mySequence.play();
            mySequence.setOnFinished(event ->{
                Random newRandom = new Random();
                double newDouble = newRandom.nextDouble(30, 70);

                platform.setWidth(newRectangle.getWidth());
                platform.setLayoutX(-platform.getTranslateX());

//                System.out.println(platform.getLayoutX());

                newRectangle.setLayoutX(190-newRectangle.getTranslateX());
                newRectangle.setWidth(45);



                double stickX = platform.getLayoutX() + platform.getWidth() - Stick.getWidth();
                Stick.setLayoutX(stickX);
                Stick.setHeight(11);
                double pivotX = Stick.getX() + Stick.getWidth() / 2;
                double pivotY = Stick.getY() + Stick.getHeight();

                // Rotate the stick back to a vertical position
                Rotate rotation = new Rotate(0, pivotX, pivotY);
                Stick.getTransforms().clear();
                Stick.getTransforms().add(rotation);
            });
        }
    }
    public int getStickLength() {
        return stickLength;
    }

    public void setStickLength(int stickLength) {
        this.stickLength = stickLength;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random newRandom = new Random();
        double newDouble = newRandom.nextDouble(30, 70);

        newRectangle = new Rectangle();
        newRectangle.setHeight(210);
        newRectangle.setLayoutX(190);
        newRectangle.setLayoutY(432);
        newRectangle.setWidth(64);

        pane.getChildren().add(newRectangle);

    }
}
