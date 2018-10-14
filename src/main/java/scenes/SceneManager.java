package scenes;

import javafx.scene.Scene;
import main.GameManager;

public class SceneManager {
    IGameScene currentScene = new InitialScene();
    private static SceneManager sceneManager = new SceneManager();
    private SceneManager()
    {

    }
    public static String getTitle()
    {
        return getSceneManager().currentScene.getTitle();
    }
    public static Scene getScene()
    {
        return getSceneManager().currentScene.getScene();
    }
    public static SceneManager getSceneManager()
    {
        return sceneManager;
    }
    public static void nextScene()
    {
        getSceneManager().currentScene = getSceneManager().currentScene.getNext();
        GameManager.next();
    }
}
