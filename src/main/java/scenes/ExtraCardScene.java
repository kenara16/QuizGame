package scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

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
        HBox hbox = new HBox(button1);
        Scene scene = new Scene(hbox, 400, 400);
        return scene;
    }

}
