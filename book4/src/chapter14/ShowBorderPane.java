/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class ShowBorderPane extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create a border pane
        BorderPane pane = new BorderPane();
        
        //Place nodes in the pane
        CustomPane pane1 = new CustomPane("Top");
        pane1.setAlignment(Pos.BOTTOM_LEFT);
        pane.setTop(pane1);
        pane.setRight(new CustomPane("Right"));
        pane.setLeft(new CustomPane("Left"));
        pane.setBottom(new CustomPane("Bottom"));
        pane.setCenter(new CustomPane("Center"));
        
        //Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowBorderPane");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args){
        launch(args);
    }
}

class CustomPane extends StackPane{
    public CustomPane(String title){
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: red");
        setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
    }
}