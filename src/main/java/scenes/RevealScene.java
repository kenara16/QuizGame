package scenes;

import formattedItems.RevealClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.GameManager;

public class RevealScene implements IGameScene {
    public String title = "Initial Scene";
    public String getTitle()
    {
        return title;
    }
    public IGameScene getNext()
    {
        return new QuizScene();
    }
    public Scene getScene()
    {
        BorderPane border = new BorderPane();

        RevealClass revealOne = new RevealClass(GameManager.getGameManager().getTeamOne());
        RevealClass revealTwo = new RevealClass(GameManager.getGameManager().getTeamTwo());

        Button button1 = new Button("Reveal Scene");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameManager.getGameManager().clearPlayedCards();
                SceneManager.nextScene();
            }
        });
        HBox hbox = new HBox(button1);
        hbox.setAlignment(Pos.CENTER);

        border.setLeft(revealOne.getRevealUI());
        border.setRight(revealTwo.getRevealUI());
        border.setBottom(hbox);

        Scene scene = new Scene(border, 400, 400);
        return scene;
    }

}
