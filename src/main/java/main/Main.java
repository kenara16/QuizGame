package main;

import Persistence.DBConnectionManager;
import backend.*;
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
        DBConnectionManager.PleaseDontTouchThisMethod();


// This code is for testing DB part.
//        List<Card> cards;
//        cards = CardQuizManager.Draw4Cards();
//        for(Card card : cards) {
//            System.out.println(card);
//        }
//
//        System.out.println("Get a question based on drawn cards");
//        System.out.println(CardQuizManager.DrawAQuestionFromRevealedCard());
//        System.out.println(CardQuizManager.DrawAQuestionFromRevealedCard());
//        System.out.println(CardQuizManager.DrawAQuestionFromRevealedCard());
//        System.out.println(CardQuizManager.DrawAQuestionFromRevealedCard());
//        System.out.println(CardQuizManager.DrawAQuestionFromRevealedCard());
//        System.out.println(CardQuizManager.DrawAQuestionFromRevealedCard());

//
//        cards = CardQuizManager.Draw4Cards();
//        for(Card card : cards) {
//            System.out.println(card);
//        }
//
//        cards = CardQuizManager.Draw4Cards();
//        for(Card card : cards) {
//            System.out.println(card);
//        }
//
//        cards = CardQuizManager.Draw4Cards();
//        for(Card card : cards) {
//            System.out.println(card);
//        }
//
//        cards = CardQuizManager.Draw4Cards();
//        for(Card card : cards) {
//            System.out.println(card);
//        }

        launch(args);

    }
}
