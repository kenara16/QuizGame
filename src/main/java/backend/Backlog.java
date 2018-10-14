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
        //added  for purposes of getting GUI working.
        try
        {
            throw new Exception();
            //this.storyDeck = StoryManager.GetStoriesFromMongoDB();
        }
        catch(Exception e)
        {
            this.storyDeck = new ArrayList<>();
            this.storyDeck.add(new Story(1,1));
            this.storyDeck.add(new Story(2,2));
            this.storyDeck.add(new Story(3,3));
            this.storyDeck.add(new Story(4,5));
            this.storyDeck.add(new Story(6,8));
        }
        return this.storyDeck;
    }

}
