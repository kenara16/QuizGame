package Persistence;

import backend.Card;
import backend.Question;
import backend.Story;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import formattedItems.CardClass;
import formattedItems.QuizClass;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DBConnectionManager {

    private static final String STORY_NUM = "Number";
    private static final String STORY_POINT = "Point";
    private static final String ID = "ID";
    private static final String IS_REVEALED = "IsRevealed";
    private static final String CONTEXT = "Context";
    private static final String QUESTION = "Question";
    private static final String ANSWER1 = "Ans1";
    private static final String ANSWER2 = "Ans2";
    private static final String ANSWER3 = "Ans3";
    private static final String ANSWER4 = "Ans4";
    private static final String STORY_DECK = "StoryDeck";
    private static final String CARD_AND_QUIZ = "CardAndQuiz";
    private static final String TITLE = "Title";

    public static List<Story> GetStoryCollection() {
        MyDBClient.ConnectToDB();
        MongoDatabase storyDB = MyDBClient.GetMongoStoryDatabase();
        MongoCollection<Document> collection = storyDB.getCollection(STORY_DECK);

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




    // Please feed me with empty Lists which is not instantiated.
    // I will return ArrayList for each data types.
    // If I return true, successfully I provided you 4 cards.
    // If I return false, unfortunately it is the last cards set or I have nothing to give you anymore.

    public static boolean Get4CardAnd4Quiz(List<Card> cards) {
        //cards = new ArrayList<Card>();

        MyDBClient.ConnectToDB();
        MongoDatabase storyDB = MyDBClient.GetMongoStoryDatabase();
        MongoCollection<Document> collection = storyDB.getCollection(CARD_AND_QUIZ);

        FindIterable<Document> iterDoc = collection.find(eq(IS_REVEALED, false));
        Iterator<Document> iter = iterDoc.iterator();

        int count = 0;
        while(iter.hasNext() && count < 4) {
            Document doc = iter.next();

            // Create Question objects.
            List<String> options = new ArrayList<>();
            String question = (String) doc.get(QUESTION);
            options.add((String) doc.get(ANSWER1));
            options.add((String) doc.get(ANSWER2));
            options.add((String) doc.get(ANSWER3));
            options.add((String) doc.get(ANSWER4));
            Question q = new Question(question, options);

            Card card = new Card((String)doc.get(TITLE), (String)doc.get(CONTEXT), (Integer)doc.get(ID), q);
            cards.add(card);

            collection.updateOne(eq(ID, (Integer)doc.get(ID)), new Document("$set", new Document(IS_REVEALED, true)));
            ++count;
        }


        if(!iter.hasNext()) {
            MyDBClient.CloseConnectioin();
            return false;
        }
        MyDBClient.CloseConnectioin();
        return true;
    }

    public static void PleaseDontTouchThisMethod() {
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
                .append("IsRevealed", false)
                .append("Context", "Burn-up chart is used to keep track of the progress of the project.\n" +
                        "Burn-up charts represent how much work has been completed.")
                .append("Question", "What is the role of the burn-up chart?")
                .append("Ans1", "Burn-up chart represent how much work has been completed.")
                .append("Ans2", "Burn-up chart represent the remaining work.")
                .append("Ans3", "Burn-up chart represent the remaining uncertainty.")
                .append("Ans4", "Burn-up char represent how much uncertainty has been revealed."));

        list.add(new Document("ID", 2)
                .append("Title", "Scrum")
                .append("IsRevealed", false)
                .append("Context", "Burn-down charts is used to keep track of the progress of the project.\n" +
                        "Burn-down chart represents the remaining work in a project.")
                .append("Question", "What is the role of the burn-down chart?")
                .append("Ans1", "Burn-down chart represent the remaining work.")
                .append("Ans2", "Burn-down chart represent how much work has been completed.")
                .append("Ans3", "Burn-down chart represent the remaining uncertainty.")
                .append("Ans4", "Burn-down char represent how much uncertainty has been revealed."));



        list.add(new Document("ID", 3)
                .append("Title", "Scrum")
                .append("IsRevealed", false)
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
                .append("IsRevealed", false)
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
                .append("IsRevealed", false)
                .append("Context", "Scrum Team – Each member in the team should be self-organized, dedicated and responsible for high quality of the work.")
                .append("Question", "What is the role of the scrum team?")
                .append("Ans1", "Who should be self-organized, dedicated and responsible for high quality of the work.")
                .append("Ans2", "Who has the responsibility of managing the product backlog.\n" +
                        "Works with end users and customers and provide proper requirement to the team to build the proper product.")
                .append("Ans3", "Who works with scrum team to make sure each sprint gets complete on time. Scrum master ensure proper work flow to the team.")
                .append("Ans4", "Who is modelled around the people who will use the product."));

        list.add(new Document("ID", 6)
                .append("Title", "Concept")
                .append("IsRevealed", false)
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
                .append("IsRevealed", false)
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
                .append("IsRevealed", false)
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
                .append("IsRevealed", false)
                .append("Context", "The retrospective is an important step that should be done at the end of every " +
                        "sprint in order to decide what went well for your team and what needed improvement. " +
                        "One popular format is stop, start, continue, where a team discusses what they should " +
                        "stop doing, what they should start doing, and what they should continue doing")
                .append("Question", "One popular retrospective style is called what?")
                .append("Ans1", "Stop, begin, continue")
                .append("Ans2", "Halt, start, continue")
                .append("Ans3", "Red, Green, Yellow")
                .append("Ans4", "Stop, Start, Continue"));

        list.add(new Document("ID", 10)
                .append("Title", "Artifacts")
                .append("IsRevealed", false)
                .append("Context", "It is important that all stories that compose the backlog contain a definition of done.  This definition can be different for different teams and different types of stories.  However, each story must have a clearly defined end point so all team members agree when a goal has been met.")
                .append("Question", "What is the definition of done, and why is it important?")
                .append("Ans1", "The definition depends on what is agreed upon for a particular story, and because it is variable it is not important")
                .append("Ans2", "The definition depends on what is agreed upon for a particular story, and it is important because it tells team members when a story has been completed")
                .append("Ans3", "The definition is that a story is done when it has undergone unit tests, and it is an important benchmark to meet when getting something ready for prod")
                .append("Ans4", "The definition is that a story is done when it has been deployed to production, and it is important because no more work must be done to the story after it is deployed"));

        list.add(new Document("ID", 11)
                .append("Title", "Artifact")
                .append("IsRevealed", false)
                .append("Context", "The six properties of every user story is that they are independent, negotiable, valuable, estimable, small, and testable")
                .append("Question", "What are the six properties of every user story?")
                .append("Ans1", "Independent, negotiable, valuable, understandable, small, and testable")
                .append("Ans2", "Independent, negotiable, cheap, estimable, small, and testable")
                .append("Ans3", "Independent, negotiable, valuable, estimable, small, and testable")
                .append("Ans4", "Alone, negotiable, valuable, estimable, small, and testable"));

        list.add(new Document("ID", 12)
                .append("Title", "Concepts")
                .append("IsRevealed", false)
                .append("Context", "One of Agile’s central purposes is to speed up the production cycle, and deliver potentially shippable code to consumers more quickly.  An iterative approach with little time between each iterations allow users to get their hands on the product more quickly and better shape the end result.")
                .append("Question", "Why does Agile prefer a short time scale for each iteration?")
                .append("Ans1", "It doesn’t")
                .append("Ans2", "In order to get the product done more quickly, so the team can move on to different projects")
                .append("Ans3", "In order to get the product in the hands of users more quickly, so the team can respond to the conversation with users more easily")
                .append("Ans4", "In order to get investors off your back so you can get on with your life "));

        list.add(new Document("ID", 13)
                .append("Title", "Rituals")
                .append("IsRevealed", false)
                .append("Context", "The daily standup is a short but important ritual, where each team member takes the time to discuss what they’ve done since the last standup, what are you doing today, and what is blocking their progress.  This meeting should be short, no more than 15 minutes, but allows for teams to keep track of each other’s work and figure out where potential issues may lie.")
                .append("Question", "What do team members do during the daily standup?")
                .append("Ans1", "Discuss what they have done since the last standup, what are you doing today, and what is blocking them")
                .append("Ans2", "Discuss in depth the technical issues that they are facing so they can get assistance from fellow team members")
                .append("Ans3", "They should only stand up to present if they have done anything worth noting since last standup")
                .append("Ans4", "Daily team exercise"));

        list.add(new Document("ID", 14)
                .append("Title", "Rituals")
                .append("IsRevealed", false)
                .append("Context", "The scrum of scrums is kind of like a daily standup for scrum masters.  This is where scrum masters from various teams can communicate with each other about what their team has done since the last sprint, what they will do before the next scrum of scrums, and what is blocking their teams as a whole.")
                .append("Question", "What is the scrum of scrums?")
                .append("Ans1", "It is like sprint planning, but with every team’s scrum master.")
                .append("Ans2", "It is like the daily standup, but with every team’s scrum master communicating about what their team is doing and what is blocking their progress")
                .append("Ans3", "It is like a retrospective, but with each team’s scrum master discussing what their teams have done during the sprint and what they have not done")
                .append("Ans4", "It is a scrum of scrum masters who work on their own projects in their spare time"));

        list.add(new Document("ID", 15)
                .append("Title", "Concepts")
                .append("IsRevealed", false)
                .append("Context", "Velocity is the amount of stories that a team has completed in a given sprint, or an average of previous sprints.  As a general rule of thumb, do not expect velocity to arbitrarily increase")
                .append("Question", "What is velocity?")
                .append("Ans1", "The amount of stories completed over the course of the entire project")
                .append("Ans2", "The amount of stories that have yet to be completed")
                .append("Ans3", "How many stories you can add each sprint")
                .append("Ans4", "The amount of stories a team has completed the previous sprint, or averaged across the last couple of sprints"));

        Collections.shuffle(list);
        collection.insertMany(list);
        MyDBClient.CloseConnectioin();

    }

}
