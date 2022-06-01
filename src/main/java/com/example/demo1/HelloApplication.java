package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    //By Ahmed Yousri
    //PS: Initial depth is 6
    //PS: Reset sometimes is lagging so please restart the application   ,Ahmed Yousri :D

    @Override
    public void start(Stage stage) throws IOException
    {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 550);
        String css = this.getClass().getResource("app.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Connect 4");
        stage.setScene(scene);
        stage.fullScreenExitHintProperty();
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}