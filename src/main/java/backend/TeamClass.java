package backend;

import formattedItems.CardClass;
import javafx.scene.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TeamClass {

    private Backlog backlog = new Backlog();
    private Integer totalPoints;
    private Integer pointsToSpend;
    //Cards taken from database
    private ArrayList<CardClass> cardsInScene = new ArrayList<CardClass>();
    //this holds the cards that have been played by the team for the given round
    private ArrayList<CardClass> playedCards = new ArrayList<CardClass>();
    private ArrayList<CardClass> unplayedCards = new ArrayList<CardClass>();
    private String answer;

    /*
    public TeamClass()
    {
        //points placeholders for purpose of getting GUI working
        totalPoints = 100;
        pointsToSpend=25;
    };
    */

    public TeamClass(Backlog back){
        this.backlog = back;
        //totalPoints = determineTotalPoints(this.backlog);
        totalPoints = this.backlog.GetTotalPointsOfSelectedStories();
        this.pointsToSpend = 0;

    }

    public ArrayList<CardClass> getCardsFromDB(){
        //clear out the list of cards for the current round if any carried over from last round
        if (cardsInScene.size() > 0){
            cardsInScene.clear();
        }
        //return the ArrayList of the cards in the current round from a List of 4 drawn cards
        List<Card> drawnCards = CardQuizManager.Draw4Cards();
        for (Card card : drawnCards){
            cardsInScene.add(new CardClass(card));
        }
        return cardsInScene;
    }

    /*
    //determines how many total points the team must spend to win based off backlog
    private int determineTotalPoints(Backlog back){
        int totalPoints = 0;

        for (Story story : back.getCheckBoxOutput()){
            totalPoints += story.GetPoint();
        }

        return totalPoints;
    }
    */

    //This returns a teams total points converted into a Text node
    public Text returnTextPoints(){
        Text txt = new Text("Total points remaining: " + totalPoints.toString());
        return txt;
    }

    //This returns a team's accrued points to spend into a Text node
    public Text returnPointsToSpend(){
        Text txt = new Text("Points to spend this round: " + pointsToSpend.toString());
        return txt;
    }

    //the next two methods increase and decrease the overall point amount

    public void increaseTotalPoints(int amt){
        totalPoints += amt;
    }

    public void decreaseTotalPoints(int amt){
        totalPoints -= amt;
    }

    /*The next two methods increase and decrease the amount of
    points the team has accrued to spend against their backlog
    on any given round */

    public void changePointsToSpend(int amt){
        pointsToSpend += amt;
    }

    //returns an ArrayList of GirdPanes for to display in Backlog UI Object
    public ArrayList<GridPane> returnTextArrayListCheckbox(){
        ArrayList<GridPane> grids = new ArrayList<GridPane>();

        for (Story story : backlog.getCheckBoxOutput()){
            grids.add(story.GetGridPane());
        }

        return grids;
    }

    public ArrayList<CardClass> getCardsPlayed(){
        return this.playedCards;
    }
    public void setPlayedCards(ArrayList<CardClass> newList)
    {
        this.playedCards = newList;
        for (CardClass card : this.playedCards)
        {
            this.changePointsToSpend(card.getPoints());
        }
    }
    public void clearCardsPlayed(){this.playedCards.clear();}

    public ArrayList<CardClass> getCardsNotPlayed(){
        return this.unplayedCards;
    }
    public void setNotPlayedCards(ArrayList<CardClass> newList){
        this.unplayedCards = newList;
    }
    public void clearCardsNotPlayed(){this.unplayedCards.clear();}

    public Integer getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getPointsToSpend() {
        return pointsToSpend;
    }
    public void setPointsToSpend(Integer pointsToSpend) {
        this.pointsToSpend = pointsToSpend;
    }
    public void resetSpendablePoints()
    {
        this.pointsToSpend =0;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer(){
        return answer;
    }
}