/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter14;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author cis2mye
 */
public class Test extends Application{
    public Test(){
        System.out.println("Test constructor is invoked");
    }
    
    @Override
    public void start(Stage primaryStage){
        System.out.println("start method is invoked");
    }
    
    public static void main(String[] args){
        System.out.println("launch application");
        Application.launch(args);
    }
}
