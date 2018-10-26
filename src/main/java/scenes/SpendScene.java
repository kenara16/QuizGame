package scenes;

import backend.TeamClass;
import formattedItems.BacklogDisplay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.GameManager;

public class SpendScene implements IGameScene {
    public String title = "Spend Scene";
    public String getTitle()
    {
        return title;
    }
    public IGameScene getNext()
    {
        {
            if (GameManager.currentlyFirstTeam())
            {
                return new SpendScene();
            }
            else
            {
                GameManager.resetSpendablePoints();
                return new CardScene();
            }
        }
    }
    public Scene getScene()
    {

        Button button1 = new Button("Spend Points for Team " + GameManager.getTeamNumber());
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.nextScene();
            }
        });
        BorderPane layout = new BorderPane();
        layout.setBottom(button1);
        VBox teamBacklog= new BacklogDisplay(GameManager.getCurrentTeam()).getHBox();
        if(GameManager.currentlyFirstTeam())
        {
            layout.setLeft(teamBacklog);
        }
        else
        {
            layout.setRight(teamBacklog);
        }
        Scene scene = new Scene(layout, 800, 800);
        return scene;
    }

}
