package Persistence;

import backend.Story;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBConnectionManager {

    private static final String STORY_NUM = "Number";
    private static final String STORY_POINT = "Point";

    public static List<Story> GetStoryCollection() {
        MyDBClient.ConnectToDB();
        MongoDatabase storyDB = MyDBClient.GetMongoStoryDatabase();
        MongoCollection<Document> collection = storyDB.getCollection("StoryDeck");

        FindIterable<Document> iterDoc = collection.find();
        Iterator<Document> iter = iterDoc.iterator();

        List<Story> storyList = new ArrayList<>();
        while(iter.hasNext()) {
            Document doc = iter.next();
            int num = (int)doc.get(STORY_NUM);
            int pnt = (int)doc.get(STORY_POINT);
            storyList.add(new Story(num, pnt));
        }
        return storyList;
    }

}
