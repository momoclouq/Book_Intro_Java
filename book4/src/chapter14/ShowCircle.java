/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class ShowCircle extends Application{
    @Override
    public void start(Stage primaryStage){
        //create a new circle
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.BLUE);
        
        //Create a pane to hold the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        
        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setTitle("Show circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
}
