package main;

import backend.Backlog;
import backend.Story;
import backend.TeamClass;
import formattedItems.BacklogDisplay;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));

        GameManager.getGameManager().start(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
	//test
    }
}
