package backend;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class StoryManager {

    private static StoryManager pInstance;

    private MongoClient mongoClient;
    private MongoCollection<Document> doc;
    private final String STORY_NUM = "number";
    private final String STORY_POINT = "point";

    private StoryManager() {

    }

    private static StoryManager GetManagerInstance() {
        if(StoryManager.pInstance == null) {
            StoryManager.pInstance = new StoryManager();
        }
        return StoryManager.pInstance;
    }

    public static void InitializeManager() {
        if(StoryManager.pInstance == null) {
            StoryManager.pInstance = new StoryManager();
        }
    }


    public static List<String> GetStoriesFromMongoDB() {
        final StoryManager manager = StoryManager.GetManagerInstance();
        assert (manager != null);

        // Connect to Database
        try {
            manager.mongoClient = new MongoClient("127.0.0.1", 27017);
            System.out.println("Connected to MongoDB");
            manager.doc = manager.mongoClient.getDatabase("Stories").getCollection("StoryDeck");
            System.out.println("Received Dataset from MongoDB");
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }

        // Read the data and attach it to list.
        final List<String> storyList = new ArrayList<String>();
        FindIterable<Document> iter = manager.doc.find();
        iter.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                String newStr = "Story " + document.get(manager.STORY_NUM, String.class) + "\n" + //
                        document.get(manager.STORY_POINT) + " story point";
                String str = new String(newStr);
                storyList.add(str);
            }
        });
        return storyList;
    }
}
