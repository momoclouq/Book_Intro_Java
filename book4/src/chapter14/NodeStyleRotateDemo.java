/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class NodeStyleRotateDemo extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create a scene and place a button in the scene
        StackPane pane = new StackPane();
        Button btOK = new Button("OK");
        btOK.setStyle("-fx-border-color: blue; -fx-background-color: red;");
        //btOK.setFill((new Color(0,0,0,1)).darker());
        btOK.setRotate(15);
       // pane.getChildren().add(btOK);
        
        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        Circle circle = new Circle();
        circle.setFill((new Color(0,0,0,1)).darker());
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(100);
        circle.setStyle("-fx-border-color: blue; -fx-background-color: black;");
        pane.getChildren().add(circle);
        pane.getChildren().add(btOK);
        
        if(btOK.contains(1,1)) System.out.println("contained");
        else System.out.println(1);
        btOK.setScaleX(2);
        btOK.setScaleY(2);
        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Node Style Rotate Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
}
