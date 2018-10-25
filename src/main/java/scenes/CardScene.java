package scenes;

import backend.Card;
import backend.CardQuizManager;
import backend.TeamClass;
import formattedItems.CardClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.GameManager;
import formattedItems.BacklogDisplay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CardScene implements IGameScene {
    public String title = "Dealing Cards to Team " + GameManager.getTeamNumber();
    //Collection of cards selected in current scene to send to current TeamClass
    ArrayList<CardClass> cardsSelected = new ArrayList<CardClass>();
    //Collection of unplayed cards that were not selected for later use
    ArrayList<CardClass> cardsNotSelected = new ArrayList<CardClass>();
    //ArrayList of overall cards in current scene
    ArrayList<CardClass> cardsInScene;
    public CardScene(){
        //Get the cards in the current scene from the current team's getCards method
        cardsInScene = GameManager.getCurrentTeam().getCardsFromDB();
    }
    public IGameScene getNext()
    {
        if (GameManager.currentlyFirstTeam())
        {
            return new CardScene();
        }
        else
        {
            return new RevealScene();
        }
    }
    public String getTitle()
    {
        return title;
    }
    public void getCards(ArrayList<CardClass> cardsInScene){
        for (CardClass card : cardsInScene){
            if (card.getCheckboxSelection()){
                cardsSelected.add(card);
            } else {
                cardsNotSelected.add(card);
            }
        }
    }
    public Scene getScene()
    {
        BorderPane layout = new BorderPane();
        VBox cardChoices= new VBox(20);
        HBox confirmCards = new HBox(20);
        Text msg = new Text();

        //Buttons to confirm card selection and to move to next card select screen.
        //HBox will hold this button(s).
        Button button1 = new Button("Confirm Cards for Team " + GameManager.getTeamNumber());
        confirmCards.setAlignment(Pos.CENTER);
        confirmCards.getChildren().add(button1);

        /*
        //Game logic to generate cards from database of cards and references card class for formatting
        for (int i=0; i<4;i++) {
            //Will replace this with logic to pull cards from database

            CardClass newCard= new CardClass(GameManager.getCard());
            cardChoices.getChildren().add(newCard.getCardUI());
            cardsInScene.add(newCard);
        }
        */

        layout.setCenter(cardChoices);
        //layout.setLeft(team1Backlog); //For Team 1 Backlog
        //layout.setRight(team2Backlog); //For Team 2 Backlog
        layout.setBottom(confirmCards);

        Scene scene = new Scene(layout, 800, 800);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getCards(cardsInScene);
                GameManager.getCurrentTeam().setPlayedCards(cardsSelected);
                GameManager.getCurrentTeam().setNotPlayedCards(cardsNotSelected);
                SceneManager.nextScene();
            }
        });
        return scene;
    }
}

