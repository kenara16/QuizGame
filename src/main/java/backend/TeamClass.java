package backend;

import javafx.scene.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TeamClass {

    private Backlog backlog = new Backlog();
    private Integer totalPoints;
    private Integer pointsToSpend;

    public TeamClass(){};

    public TeamClass(Backlog back){
        this.backlog = back;
        totalPoints = determineTotalPoints(this.backlog);
        pointsToSpend = 0;
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
        Text txt = new Text(totalPoints.toString());
        return txt;
    }

    //This returns a team's accrued points to spend into a Text node
    public Text returnPointsToSpend(){
        Text txt = new Text(pointsToSpend.toString());
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

    public void increasePointsToSpend(int amt){
        pointsToSpend += amt;
    }

    public void decreasePointsToSpend(int amt){
        pointsToSpend -= amt;
    }

    //returns an ArrayList of GirdPanes for to display in Backlog UI Object
    public ArrayList<GridPane> returnTextArrayListCheckbox(){
        ArrayList<GridPane> grids = new ArrayList<GridPane>();

        for (Story story : backlog.getCheckBoxOutput()){
            grids.add(story.GetGridPane());
        }

        return grids;
    }

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