package backend;

//Placeholder backlog class

import java.util.ArrayList;
import java.util.List;

/* The String objects are placeholders.  We will access the DB service from here and
get the required information.  Eventually, this information will be passed to the team class
and converted into Text objects and other nodes */
public class Backlog {

    private List<Story> storyDeck;

    public Backlog() {}

    public int GetNumOfStoriesInDeck() {
        if(this.storyDeck == null) {
            System.out.println("No Story objects in Backlog class");
            assert false;
        }
        return this.storyDeck.size();
    }

    public Story GetStoryByIndex(int index) {
        if(index >= this.storyDeck.size()) {
            System.out.println("Request Index is bigger than the number of stories in the deck");
            assert(false);
        }
        return storyDeck.get(index);
    }


    public List<Story> getCheckBoxOutput() {
        this.storyDeck = StoryManager.GetStoriesFromMongoDB();
        return this.storyDeck;
    }

    public List<Story> getStoryDeck(){
        return this.storyDeck;
    }


}
