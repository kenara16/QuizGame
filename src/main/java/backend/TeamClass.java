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
    //this holds the cards that have been played by the team for the given round
    private ArrayList<CardClass> playedCards = new ArrayList<CardClass>();

    public TeamClass()
    {
        //points placeholders for purpose of getting GUI working
        totalPoints = 100;
        pointsToSpend=25;
    };

    public TeamClass(Backlog back){
        this.backlog = back;
        totalPoints = determineTotalPoints(this.backlog);
        this.pointsToSpend = 0;
    }

    //determines how many total points the team must spend to win based off backlog
    private int determineTotalPoints(Backlog back){
        int totalPoints = 0;

        for (Story story : back.getCheckBoxOutput()){
            totalPoints += story.GetPoint();
        }

        return totalPoints;
    }

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
    public void setPlayedCards(ArrayList<CardClass> newList){
        this.playedCards = newList;
    }
    public void clearCardsPlayed(){this.playedCards.clear();}

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

}