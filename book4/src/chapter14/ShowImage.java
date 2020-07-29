/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class ShowImage extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create a pane to hold the image viewers
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5,5,5,5));
        Image image = new Image("photos/tin.gif");
        pane.getChildren().add(new ImageView(image));
        
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);
        pane.getChildren().add(imageView2);
        
        ImageView imageView3 = new ImageView(image);
        imageView3.setRotate(90);
        pane.getChildren().add(imageView3);
        
        //Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
}
