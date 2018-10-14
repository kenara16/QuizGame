package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import scenes.SceneManager;

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
        this.stage.setTitle(SceneManager.getTitle());
        this.stage.setScene(SceneManager.getScene());
        this.stage.show();

    }
    public static void next()
    {
        getGameManager().stage.setTitle(SceneManager.getTitle());
        getGameManager().stage.setScene(SceneManager.getScene());
        getGameManager().stage.show();
    }
}
