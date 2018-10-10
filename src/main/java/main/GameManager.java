package main;

import formattedItems.CardClass;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameManager
{
    Stage stage;
    private static GameManager gameManager = new GameManager();
    private GameManager()
    {

    }
    public static GameManager getGameManager()
    {
        return gameManager;
    }

    public void start(Stage theStage)
    {
        this.stage = theStage;
        this.stage.setTitle("Initial Screen");

        Button button1 = new Button("Initial Screen");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().cardScene1();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();

    }
    public void cardScene1()
    {
        BorderPane layout = new BorderPane();
        VBox cardChoices= new VBox(20);
        VBox team1Backlog= new VBox(20);
        VBox team2Backlog= new VBox(20);
        HBox confirmCards = new HBox(20);

        //Buttons to confirm card selection and to move to next card select screen.
        //HBox will hold this button(s).
        this.stage.setTitle("Dealing Cards Team 1");

        Button button1 = new Button("Confirm Cards for Team 1");
        confirmCards.setAlignment(Pos.CENTER);
        confirmCards.getChildren().add(button1);
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().cardScene2();
                // Add logic to show which cards are selected and add them to "played" database.
            }
        });



        //Game logic to generate cards from database of cards and references card class for formatting
        for (int i=0; i<4;i++){
            //Will replace this with logic to pull cards from database

            Text dummyTitle= new Text("Test Title");
            Text dummyText= new Text("This is an example of card text");

            CardClass newCard= new CardClass(dummyTitle,dummyText);
            cardChoices.getChildren().add(newCard.getCard());
        }



        layout.setCenter(cardChoices);
        //layout.setLeft(); For Team 1 Backlog
        //layout.setRight(); For Team 2 Backlog
        layout.setBottom(confirmCards);


        Scene scene = new Scene(layout, 600, 600);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void cardScene2()
    {

        BorderPane layout = new BorderPane();
        VBox cardChoices= new VBox(20);
        VBox team1Backlog= new VBox(20);
        VBox team2Backlog= new VBox(20);
        HBox confirmCards = new HBox(20);

        this.stage.setTitle("Dealing Cards Team 2");

        Button button1 = new Button("Confirm Cards For Team 2");
        confirmCards.setAlignment(Pos.CENTER);
        confirmCards.getChildren().add(button1);
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().revealCards();
                // Add logic to show which cards are selected and add them to "played" database.
            }
        });



        //Game logic to generate cards from database of cards and references card class for formatting
        for (int i=0; i<4;i++){
            //Will replace this with logic to pull cards from database

            Text dummyTitle= new Text("Test Title");
            Text dummyText= new Text("This is an example of card text");

            CardClass newCard= new CardClass(dummyTitle,dummyText);
            cardChoices.getChildren().add(newCard.getCard());
        }



        layout.setCenter(cardChoices);
        //layout.setLeft(); For Team 1 Backlog
        //layout.setRight(); For Team 2 Backlog
        layout.setBottom(confirmCards);


        Scene scene = new Scene(layout, 600, 600);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void revealCards()
    {
        this.stage.setTitle("Reveal Cards");

        Button button1 = new Button("Revealing cards");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().quizScene1();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void quizScene1()
    {
        this.stage.setTitle("Quiz Team 1");

        Button button1 = new Button("Quiz Team 1");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().quizScene2();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void quizScene2()
    {
        this.stage.setTitle("Quiz Team 2");

        Button button1 = new Button("Quiz Team 2");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().extraCard();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void extraCard()
    {
        this.stage.setTitle("Play Extra Card");

        Button button1 = new Button("Play Extra Card");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().spendPoints1();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void spendPoints1()
    {
        this.stage.setTitle("Spend Points 1");

        Button button1 = new Button("Spend Points 1");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().spendPoints2();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void spendPoints2()
    {
        this.stage.setTitle("Spend Points 2");

        Button button1 = new Button("Spend Points 2");
        button1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                getGameManager().cardScene1();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
}
