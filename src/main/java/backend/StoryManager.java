package backend;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryManager {

    private static StoryManager pInstance;
    private MongoClient mongoClient;
    private MongoClientURI uri;
    private MongoDatabase db;
    private MongoCollection<Document> collections;
    private final String STORY_NUM = "Number";
    private final String STORY_POINT = "Point";

    private StoryManager() {

    }

    private static StoryManager GetManagerInstance() {
        if(StoryManager.pInstance == null) {
            StoryManager.pInstance = new StoryManager();
        }
        return StoryManager.pInstance;
    }


    public static List<Story> GetStoriesFromMongoDB() {
        final StoryManager manager = StoryManager.GetManagerInstance();
        assert (manager != null);

        // Connect to Database
        try {
            manager.uri = new MongoClientURI("mongodb+srv://Youngjo:e4T5U5q2K6yxutsD@cluster0-4fgpe.gcp.mongodb.net/");
            manager.mongoClient = new MongoClient(manager.uri);
            manager.db = manager.mongoClient.getDatabase("Stories");
            manager.collections = manager.db.getCollection("StoryDeck");
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }

        // Read the data and attach it to list.
        FindIterable<Document> iterDoc = manager.collections.find();
        Iterator<Document> iter = iterDoc.iterator();

        List<Story> storyList = new ArrayList<>();
        while(iter.hasNext()) {
            Document doc = iter.next();
            int num = (int)doc.get(manager.STORY_NUM);
            int pnt = (int)doc.get(manager.STORY_POINT);
            storyList.add(new Story(num, pnt));
        }
        return storyList;
    }

}
