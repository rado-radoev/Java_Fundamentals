/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.track.time;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author superlamer
 */
public class TimeTracking extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root;
//        root = FXMLLoader.load(getClass().getResource("TimeTracking.fxml"));
        
        System.out.println(this.getClass().getResource("").getPath());
//        
//        Scene scene = new Scene(root);
//        stage.setTitle("Time Tracking");
//        stage.setScene(scene);
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        

        
        //System.out.println(TimeTracking.class.getResource("TimeTracking.class"));   
    }
}
