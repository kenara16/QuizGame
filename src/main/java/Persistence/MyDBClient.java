package Persistence;

import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MyDBClient {

    private MongoClient mongoClient;
    private MongoClientURI uri;
    private String uriString;
    private static MyDBClient instance;

    private MyDBClient() {
        this.uriString = "mongodb+srv://Youngjo:e4T5U5q2K6yxutsD@cluster0-4fgpe.gcp.mongodb.net/";
    }

    private static MyDBClient GetMyDBClient() {
        if(MyDBClient.instance == null) {
            MyDBClient.instance = new MyDBClient();
        }
        return MyDBClient.instance;
    }

    public static boolean ConnectToDB() {
        MyDBClient myDB = MyDBClient.GetMyDBClient();
        try {
            myDB.uri = new MongoClientURI(myDB.uriString);
            myDB.mongoClient = new MongoClient(myDB.uri);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean CloseConnectioin() {
        MyDBClient myDB = MyDBClient.GetMyDBClient();
        try {
            myDB.mongoClient.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static MongoDatabase GetMongoStoryDatabase() {
        MyDBClient myDB = MyDBClient.GetMyDBClient();
        return myDB.mongoClient.getDatabase("Stories");
    }

}
