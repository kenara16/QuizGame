package formattedItems;

import backend.Story;
import backend.TeamClass;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BacklogDisplay {

    private TeamClass team;
    private VBox vBox = new VBox();

    public BacklogDisplay(TeamClass team){
        this.team = team;
        vBox.getChildren().add(team.returnTextPoints());
        vBox.getChildren().add(team.returnPointsToSpend());
        addAllGrids(team);
    }

    public void addAllGrids(TeamClass team){
        for (GridPane grid : team.returnTextArrayListCheckbox()){
            vBox.getChildren().add(grid);
        }
    }

    public VBox getHBox(){
        return this.vBox;
    }

}
