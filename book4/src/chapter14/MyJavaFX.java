/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class MyJavaFX extends Application{
    @Override
    public void start(Stage primaryStage){
        Button btOK = new Button("OK");
        Scene scene = new Scene(btOK, 200, 250);
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        //new stage
        Stage stage = new Stage();
        stage.setTitle("Second stage");
        stage.setScene(new Scene(new Button("New Stage"), 200, 250));
        stage.show();
    }
    
    //the main method is only needed for the IDE with limited JavaFX support, not for running from the command line
    public static void main(String[] args){
        //Application.launch(args);
        launch(args);
    }
}
