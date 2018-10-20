package scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.GameManager;

public class ExtraCardScene implements IGameScene {
    public String title = "Extra Card Scene";
    public String getTitle()
    {
        return title;
    }
    public IGameScene getNext()
    {
        return new SpendScene();
    }
    public Scene getScene()
    {

        Button button1 = new Button("Play Extra Card");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.nextScene();
            }
        });

        Label team1Answer = new Label("team 1 answer: " + GameManager.getTeamOne().getAnswer());
        Label team2Answer = new Label("team 2 answer: "+ GameManager.getTeamTwo().getAnswer());
        HBox hbox = new HBox(button1);

        VBox layout = new VBox();
        layout.getChildren().addAll(team1Answer,team2Answer,button1);
        Scene scene = new Scene(layout, 400, 400);
        return scene;
    }

}
