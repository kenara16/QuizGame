package main;

import Persistence.DBConnectionManager;
import backend.Backlog;
import backend.Card;
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
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));

        GameManager.getGameManager().start(primaryStage);
    }


    public static void main(String[] args) {
        DBConnectionManager.PleaseDontTouchThisMethod();


// This code is for testing DB part.
//        List<Card> cards = new ArrayList<>();
//        System.out.println(DBConnectionManager.Get4CardAnd4Quiz(cards));
//
//        cards = new ArrayList<>();
//        System.out.println(DBConnectionManager.Get4CardAnd4Quiz(cards));
//
//        cards = new ArrayList<>();
//        System.out.println(DBConnectionManager.Get4CardAnd4Quiz(cards));
//
//        cards = new ArrayList<>();
//        System.out.println(DBConnectionManager.Get4CardAnd4Quiz(cards));
//
//        cards = new ArrayList<>();
//        System.out.println(DBConnectionManager.Get4CardAnd4Quiz(cards));

        launch(args);

    }
}
