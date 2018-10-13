package formattedItems;

import backend.Story;
import backend.TeamClass;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class BacklogDisplay {

    private TeamClass team;
    private HBox hbox;

    public BacklogDisplay(TeamClass team){
        this.team = team;
        hbox.getChildren().add(team.returnTextPoints());
        hbox.getChildren().add(team.returnPointsToSpend());
        addAllGrids(team);
    }

    public void addAllGrids(TeamClass team){
        for (GridPane grid : team.returnTextArrayListCheckbox()){
            hbox.getChildren().add(grid);
        }
    }

    public HBox getHBox(){
        return this.hbox;
    }

}
