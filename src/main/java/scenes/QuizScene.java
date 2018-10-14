package scenes;

import formattedItems.QuizClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.GameManager;

import java.util.ArrayList;

public class QuizScene implements IGameScene {
    public String title = "Quiz Scene";
    public String getTitle()
    {
        return title;
    }
    public IGameScene getNext()
    {
        if (GameManager.currentlyFirstTeam())
        {
            return new QuizScene();
        }
        else
        {
            return new ExtraCardScene();
        }
    }
    public Scene getScene()
    {

        Button button1 = new Button("Confirm Quiz for Team " + GameManager.getTeamNumber());
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SceneManager.nextScene();
            }
        });
        BorderPane layout = new BorderPane();
        ArrayList<String> answers = new ArrayList<String>();
        String question= "This is the test question?";
        answers.add(0,"a. Some Answer");
        answers.add(1,"b. Some Answer");
        answers.add(2,"c. Some Answer");
        answers.add(3,"d. Some Answer");
        VBox quiz = new QuizClass(answers,question).getQuiz();
        quiz.setAlignment(Pos.CENTER);
        VBox team1Backlog= new VBox(20);
        VBox team2Backlog= new VBox(20);
        HBox confirmCards = new HBox(20);
        confirmCards.setAlignment(Pos.CENTER);
        confirmCards.getChildren().add(button1);

        layout.setCenter(quiz);
        layout.setLeft(team1Backlog);
        layout.setRight(team2Backlog);
        layout.setBottom(confirmCards);



        Scene scene = new Scene(layout, 600, 600);
        return scene;
    }

}
