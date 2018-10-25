package formattedItems;

import backend.TeamClass;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.GameManager;

import java.util.ArrayList;

public class RevealClass {
    private VBox revealBox = new VBox();
    private ArrayList<CardClass> cardsToShow;
    private Text teamName;

    public RevealClass(TeamClass team){
        teamName = new Text("Team " + GameManager.getTeamNumber() + ": cards played");
        cardsToShow = team.getCardsPlayed();
        for (CardClass card : cardsToShow){
            card.setInvisible();
            revealBox.getChildren().add(card.getCardUI());
        }
    }

    public VBox getRevealUI(){return this.revealBox;}
}
