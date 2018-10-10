package backend;

//Placeholder backlog class

import java.util.ArrayList;
import java.util.List;

/* The String objects are placeholders.  We will access the DB service from here and
get the required information.  Eventually, this information will be passed to the team class
and converted into Text objects and other nodes */
public class Backlog {

    private List<String> storyDeck;

    public Backlog() {}

    public int GetNumOfStoriesInDeck() {
        if(this.storyDeck == null) {
            assert false;
        }
        return this.storyDeck.size();
    }

    public String GetStoryByIndex(int index) {
        if(index >= this.storyDeck.size()) {
            System.out.println("Request Index is bigger than the number of stories in the deck");
            assert(false);
        }
        return storyDeck.get(index);
    }


    public List<String> getCheckBoxOutput() {
        this.storyDeck = new ArrayList<String>(StoryManager.GetStoriesFromMongoDB());
        return this.storyDeck;
    }


}
