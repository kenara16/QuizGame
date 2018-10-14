package scenes;

import javafx.scene.Scene;

public interface IGameScene {
    public String title = "";
    public IGameScene getNext();
    public Scene getScene();
    public String getTitle();


}
