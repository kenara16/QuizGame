package main;
import backend.TeamClass;
import formattedItems.CardClass;
import formattedItems.QuizClass;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scenes.SceneManager;

import java.util.ArrayList;

public class GameManager {
    Stage stage;
    TeamClass teamOne;
    TeamClass teamTwo;
    TeamClass currentTeam;
    private static GameManager gameManager = new GameManager();

    private GameManager()
    {
        teamOne = new TeamClass();
        teamTwo = new TeamClass();
    }
    public static boolean currentlyFirstTeam()
    {
        return getGameManager().currentTeam == getGameManager().teamOne;
    }
    public static TeamClass getCurrentTeam()
    {
        return getGameManager().currentTeam;
    }
    public static String getTeamNumber()
    {
        if (currentlyFirstTeam())
        {
            return "One";
        }
        else
        {
            return "Two";
        }
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public void start(Stage theStage) {
        this.stage = theStage;
        this.stage.setTitle("Initial Screen");
        Button button1 = new Button("Initial Screen");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                next();
            }
        });
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        this.stage.setScene(scene);
        this.stage.show();
    }
    public static void incrementTeam()
    {
        if (currentlyFirstTeam() || SceneManager.teamStateResetsAfterScene())
        {
            getGameManager().currentTeam = getGameManager().teamTwo;
        }
        else
        {
            getGameManager().currentTeam = getGameManager().teamOne;
        }
    }


    public static void next() {
        incrementTeam();
        getGameManager().stage.setScene(SceneManager.getScene());
        getGameManager().stage.setTitle("Team " + getTeamNumber());
        getGameManager().stage.show();
    }
}