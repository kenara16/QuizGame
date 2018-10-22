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
        MyDBClient.CloseConnectioin();

        return storyList;
    }


    private static void PleaseDontTouchThisMethod() {
        MyDBClient.ConnectToDB();
        MongoDatabase storyDB = MyDBClient.GetMongoStoryDatabase();
        try {
            MongoCollection<Document> collection = storyDB.getCollection("CardAndQuiz");
            collection.drop();
        } catch (Error e) {

        }
        MongoCollection<Document> collection = storyDB.getCollection("CardAndQuiz");
        List<Document> list = new ArrayList<>();

        list.add(new Document("ID", 1)
                .append("Title", "Scrum")
                .append("Context", "Burn-up chart is used to keep track of the progress of the project.\n" +
                        "Burn-up charts represent how much work has been completed.")
                .append("Question", "What is the role of the burn-up chart?")
                .append("Ans1", "Burn-up chart represent how much work has been completed.")
                .append("Ans2", "Burn-up chart represent the remaining work.")
                .append("Ans3", "Burn-up chart represent the remaining uncertainty.")
                .append("Ans4", "Burn-up char represent how much uncertainty has been revealed."));

        list.add(new Document("ID", 2)
                .append("Title", "Scrum")
                .append("Context", "Burn-down charts is used to keep track of the progress of the project.\n" +
                        "Burn-down chart represents the remaining work in a project.")
                .append("Question", "What is the role of the burn-down chart?")
                .append("Ans1", "Burn-down chart represent the remaining work.")
                .append("Ans2", "Burn-down chart represent how much work has been completed.")
                .append("Ans3", "Burn-down chart represent the remaining uncertainty.")
                .append("Ans4", "Burn-down char represent how much uncertainty has been revealed."));



        list.add(new Document("ID", 3)
                .append("Title", "Scrum")
                .append("Context", "Project Owner – who has the responsibility of managing the product backlog.\n" +
                        "Works with end users and customers and provide proper requirement to the team to build the proper product.")
                .append("Question", "What is the role of the project owner?")
                .append("Ans1", "Who has the responsibility of managing the product backlog.\n" +
                        "Works with end users and customers and provide proper requirement to the team to build the proper product.")
                .append("Ans2", "Who works with scrum team to make sure each sprint gets complete on time. Scrum master ensure proper work flow to the team.")
                .append("Ans3", "Who should be self-organized, dedicated and responsible for high quality of the work.")
                .append("Ans4", "Who is modelled around the people who will use the product."));

        list.add(new Document("ID", 4)
                .append("Title", "Scrum")
                .append("Context", "Scrum Master – who works with scrum team to make sure each sprint gets complete on time.\n" +
                        "Scrum master ensure proper work flow to the team.")
                .append("Question", "What is the role of the scrum master?")
                .append("Ans1", "Who works with scrum team to make sure each sprint gets complete on time. Scrum master ensure proper work flow to the team.")
                .append("Ans2", "Who has the responsibility of managing the product backlog.\n" +
                        "Works with end users and customers and provide proper requirement to the team to build the proper product.")
                .append("Ans3", "Who should be self-organized, dedicated and responsible for high quality of the work.")
                .append("Ans4", "Who is modelled around the people who will use the product."));

        list.add(new Document("ID", 5)
                .append("Title", "Scrum")
                .append("Context", "Scrum Team – Each member in the team should be self-organized, dedicated and responsible for high quality of the work.")
                .append("Question", "What is the role of the scrum team?")
                .append("Ans1", "Who should be self-organized, dedicated and responsible for high quality of the work.")
                .append("Ans2", "Who has the responsibility of managing the product backlog.\n" +
                        "Works with end users and customers and provide proper requirement to the team to build the proper product.")
                .append("Ans3", "Who works with scrum team to make sure each sprint gets complete on time. Scrum master ensure proper work flow to the team.")
                .append("Ans4", "Who is modelled around the people who will use the product."));

        list.add(new Document("ID", 6)
                .append("Title", "Concept")
                .append("Context", "Boehm’s Law is that the closer you get the end of production, " +
                        "the less uncertainty there is and the more clear it is how close you are to the end. " +
                        "This is represented by the cone of uncertainty. " +
                        "Agile helps narrow the cone of uncertainty through its iterative lifecycle.")
                .append("Question", "What is the cone of uncertainty?")
                .append("Ans1", "The cone of uncertainty is connected to Boehm’s law, which states that as you get " +
                        "close to the end of the project, the more clear the amount it will cost you.")
                .append("Ans2", "The cone of uncertainty is connected to Boehm’s law, which states that as you get " +
                        "closer to the end of the project, it becomes more clear how much time the project will take.")
                .append("Ans3", "The cone of uncertainty is how uncertain you are about a particular problem at the beginning of a particular sprint.")
                .append("Ans4", "The cone of uncertainty is not related to software development."));

        list.add(new Document("ID", 7)
                .append("Title", "Concept")
                .append("Context", "Tasks are individual, small, particular items of a story.  Stories are Combined to " +
                        "form epics. Tasks can be completed in a couple of hours, stories can be completed in one " +
                        "sprint, and epics are completed over the course of multiple sprints.")
                .append("Question", "What is the proper ordering of tasks, stories, and epics?")
                .append("Ans1", "Tasks compose epics, and epics compose stories.")
                .append("Ans2", "Epics compose stories, and stories compose tasks.")
                .append("Ans3", "Tasks compose stories, and stories compose epics.")
                .append("Ans4", "Stories compose epics, and epics compose tasks."));


        list.add(new Document("ID", 8)
                .append("Title", "Rituals")
                .append("Context", "Backlog Grooming is where the team evaluates which items on the backlog are no " +
                        "longer relevant, what new stories must be added, and which estimates may be off." +
                        "It is important to make sure that the backlog is up to date and reliable throughout the project.")
                .append("Question", "When your team meets to perform backlog grooming, what should they be doing?")
                .append("Ans1", "Adding items to the backlog that must be completed.")
                .append("Ans2", "Deleting items from the backlog.")
                .append("Ans3", "Refining any estimates that may be off.")
                .append("Ans4", "All of the above."));

        list.add(new Document("ID", 9)
                .append("Title", "Rituals")
                .append("Context", "The retrospective is an important step that should be done at the end of every " +
                        "sprint in order to decide what went well for your team and what needed improvement. " +
                        "One popular format is stop, start, continue, where a team discusses what they should " +
                        "stop doing, what they should start doing, and what they should continue doing")
                .append("Question", "One popular retrospective style is called what?")
                .append("Ans1", "Stop, begin, continue")
                .append("Ans2", "Halt, start, continue")
                .append("Ans3", "Red, Green, Yellow")
                .append("Ans4", "Stop, Start, Continue"));

        collection.insertMany(list);
        MyDBClient.CloseConnectioin();

    }

}
