package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
            @Override
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
        this.stage.setTitle("Dealing Cards Team 1");

        Button button1 = new Button("Dealing Cards Team 1");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getGameManager().cardScene2();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
        this.stage.setScene(scene);
        this.stage.show();
    }
    public void cardScene2()
    {
        this.stage.setTitle("Dealing Cards Team 2");

        Button button1 = new Button("Dealing Cards Team 2");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getGameManager().revealCards();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
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
            @Override
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
            @Override
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
            @Override
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
            @Override
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
            @Override
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
            @Override
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
