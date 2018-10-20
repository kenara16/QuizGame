package scenes;

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

public class CardScene implements IGameScene {
    public String title = "Dealing Cards to Team " + GameManager.getTeamNumber();
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
    public Scene getScene()
    {
        BorderPane layout = new BorderPane();
        VBox cardChoices= new VBox(20);
        HBox confirmCards = new HBox(20);

        //Buttons to confirm card selection and to move to next card select screen.
        //HBox will hold this button(s).
        Button button1 = new Button("Confirm Cards for Team " + GameManager.getTeamNumber());
        confirmCards.setAlignment(Pos.CENTER);
        confirmCards.getChildren().add(button1);

        //Game logic to generate cards from database of cards and references card class for formatting
        for (int i=0; i<4;i++){
            //Will replace this with logic to pull cards from database
            CardClass newCard= new CardClass(GameManager.getCard());
            cardChoices.getChildren().add(newCard.getCardUI());
        }



        layout.setCenter(cardChoices);
        //layout.setLeft(team1Backlog); //For Team 1 Backlog
        //layout.setRight(team2Backlog); //For Team 2 Backlog
        layout.setBottom(confirmCards);


        Scene scene = new Scene(layout, 600, 600);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.nextScene();
            }
        });
        return scene;
    }

}

