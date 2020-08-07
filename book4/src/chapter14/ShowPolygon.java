/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class ShowPolygon extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create a scene and place it in the stage
        Scene scene = new Scene(new MyPolygon(), 400, 400);
        primaryStage.setTitle("ShowPolygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}

class MyPolygon extends Pane{
    private void paint(){
        //Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list =polygon.getPoints();
        
        double centerX = getWidth() / 2, centerY = getHeight()/2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        
        //add points to the polygon list
        for (int i = 0; i < 6; i++){
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
        }
        
        for (Double item: list){
            System.out.print(item + "-");
        }
        System.out.println();
        
        getChildren().clear();
        getChildren().add(polygon);
    }
     
    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paint();
    }
    
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paint();
    }
}
