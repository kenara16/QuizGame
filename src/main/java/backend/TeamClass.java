package backend;

import javafx.scene.*;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

public class TeamClass {

    //I am currently using a dummy backlog class, will replace
    private Backlog backlog = new Backlog();
    private Integer totalPoints;
    private Integer pointsToSpend;

    public TeamClass(){};

    public TeamClass(Backlog back){
        this.backlog = back;
        totalPoints = 40;
        pointsToSpend = 0;
    }

    //This returns a teams total points converted into a Text node
    public Text returnTextPoints(){
        Text txt = new Text(totalPoints.toString());
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
    points the team has accured to spend against their backlog
    on any given round */

    public void increasePointsToSpend(int amt){
        pointsToSpend += amt;
    }

    public void decreasePointsToSpend(int amt){
        pointsToSpend -= amt;
    }

    //this returns an ArrayList of checkbox nodes that uses the string arraylist to make the checkbox labels
    public ArrayList<CheckBox> returnTextArrayListCheckbox(){
        ArrayList<CheckBox> checkBoxArr = new ArrayList<CheckBox>();

        for (String str : backlog.getCheckBoxOutput()){
            checkBoxArr.add(new CheckBox(str));
        }
        return checkBoxArr;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
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