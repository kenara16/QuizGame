package scenes;

import javafx.scene.Scene;
import main.GameManager;

public class SceneManager {
    IGameScene currentScene = new CardScene();
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
    public static boolean teamStateResetsAfterScene()
    {
        return (getSceneManager().currentScene.getClass().getSimpleName().equals("ExtraCardScene") ||
                getSceneManager().currentScene.getClass().getSimpleName().equals("RevealScene"));
    }
    public static void nextScene()
    {
        getSceneManager().currentScene = getSceneManager().currentScene.getNext();
        GameManager.next();
    }
}
