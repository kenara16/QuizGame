package scenes;

import backend.Question;
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

        //Gets question from "database"
        Question quizQuestion=GameManager.getQuestion();

        //Sets correct answer to be compared to by chosen answer by team
        GameManager.setCorrectAnswer(quizQuestion.getCorrectAnswer());

        BorderPane layout = new BorderPane();

        //Sets arraylist and question from quiz info from gamemanager to populate the quizformat VBox
        ArrayList<String> answers = quizQuestion.getAnswers();
        String question=  quizQuestion.getQuestion();

        QuizClass quizFormat= new QuizClass(answers,question);
        VBox quiz = quizFormat.getQuiz();
        quiz.setAlignment(Pos.CENTER);

        VBox team1Backlog= new VBox(20);
        VBox team2Backlog= new VBox(20);
        HBox confirmCards = new HBox(20);



        Button button1 = new Button("Confirm Quiz for Team " + GameManager.getTeamNumber());
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //sets Teams answer to their chosen answer
                GameManager.getCurrentTeam().setAnswer(quizFormat.getChosenAnswer());
                SceneManager.nextScene();
            }
        });

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
