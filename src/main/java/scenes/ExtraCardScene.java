package scenes;

import backend.TeamClass;
import formattedItems.CardClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.GameManager;

import java.util.ArrayList;

public class ExtraCardScene implements IGameScene {
    public String title = "Extra Card Scene";
    public TeamClass winningTeam;
    public ArrayList<CardClass> unplayedCardsBothTeams = new ArrayList<CardClass>();
    public ArrayList<CardClass> extraCard = new ArrayList<CardClass>();
    public String getTitle()
    {
        return title;
    }
    public IGameScene getNext()
    {
        return new SpendScene();
    }
    public Scene getScene()
    {

        Button button1 = new Button("Play Extra Card");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getExtra();
                if (extraCard.size() != 1){
                    Alert tooManyCards = new Alert(Alert.AlertType.ERROR);
                    tooManyCards.setHeaderText("Input not valid");
                    tooManyCards.setContentText("Please select one card");
                    tooManyCards.showAndWait();
                    extraCard.clear();
                }
                else{
                    GameManager.getGameManager().clearUnplayedCards();
                    SceneManager.nextScene();
                }
            }
        });

        Label team1Answer = new Label("team 1 answer: " + GameManager.getTeamOne().getAnswer());
        Label team2Answer = new Label("team 2 answer: "+ GameManager.getTeamTwo().getAnswer());
        HBox hbox = new HBox(button1);

        VBox layout = new VBox();
        unplayedCardsBothTeams.addAll(GameManager.getTeamOne().getCardsNotPlayed());
        unplayedCardsBothTeams.addAll(GameManager.getTeamTwo().getCardsNotPlayed());
        layout.getChildren().addAll(team1Answer,team2Answer,button1);

        for(CardClass card : unplayedCardsBothTeams){
            layout.getChildren().add(card.getCardUI());
        }

        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 800, 800);
        return scene;
    }
    private void getExtra(){
        for (CardClass card : unplayedCardsBothTeams){
            if (card.getCheckboxSelection()){
                extraCard.add(card);
            }
        }
    }
}
