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
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class ButtonInPane extends Application{
    @Override
    public void start(Stage primaryStage){
        StackPane pane = new StackPane();
        pane.getChildren().add(new Button("OK")); //.getChildren return ObservableList, which is similar to an ArrayList
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Button in a pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
}
