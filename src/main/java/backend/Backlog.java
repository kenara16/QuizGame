package backend;

import java.util.ArrayList;
import java.util.List;

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
}
