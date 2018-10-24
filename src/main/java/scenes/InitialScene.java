package scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import main.GameManager;

public class InitialScene implements IGameScene {
    public String title = "Initial Scene";
    public String getTitle()
    {
        return title;
    }
    public IGameScene getNext()
    {
        return new CardScene();
    }
    public Scene getScene()
    {

        Button button1 = new Button("Click here to start the game!");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameManager.next();
            }
        });
        HBox hbox = new HBox(button1);
        hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hbox, 400, 400);
        return scene;
    }

}
