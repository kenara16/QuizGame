package backend;

import Persistence.DBConnectionManager;
import java.util.List;

public class StoryManager {

    private static StoryManager pInstance;

    private StoryManager() {

    }

    private static StoryManager GetManagerInstance() {
        if(StoryManager.pInstance == null) {
            StoryManager.pInstance = new StoryManager();
        }
        return StoryManager.pInstance;
    }


    public static List<Story> GetStoriesFromMongoDB() {
        return DBConnectionManager.GetStoryCollection();

    }

}
