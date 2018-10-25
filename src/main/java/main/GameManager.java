package main;
import backend.Backlog;
import backend.Question;
import backend.TeamClass;
import backend.Card;
import formattedItems.CardClass;
import formattedItems.QuizClass;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scenes.InitialScene;
import scenes.SceneManager;

import java.util.ArrayList;
import java.util.Collections;

public class GameManager {
    Stage stage;
    static TeamClass teamOne;
    static TeamClass teamTwo;
    TeamClass currentTeam;
    private static GameManager gameManager = new GameManager();
    ArrayList<Card> unseenCards;
    static ArrayList<Card> seenCards;
    static String correctAnswer;
    static Question quizQuestion;

    private GameManager()
    {
        teamOne = new TeamClass(new Backlog());
        teamTwo = new TeamClass(new Backlog());
        createCards();
    }
    public static boolean currentlyFirstTeam()
    {
        return getGameManager().currentTeam == getGameManager().teamOne;
    }
    public static TeamClass getCurrentTeam()
    {
        return getGameManager().currentTeam;
    }
    public static String getTeamNumber()
    {
        if (currentlyFirstTeam())
        {
            return "One";
        }
        else
        {
            return "Two";
        }
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public void clearPlayedCards(){
        teamOne.clearCardsPlayed();
        teamTwo.clearCardsPlayed();
    }

    public void clearUnplayedCards(){
        teamOne.clearCardsNotPlayed();
        teamTwo.clearCardsNotPlayed();
    }

    public void start(Stage theStage) {
        this.stage = theStage;
        Scene initScene = new InitialScene().getScene();
        this.stage.setScene(initScene);
        this.stage.show();
    }
    public static void incrementTeam()
    {
        if (currentlyFirstTeam() || SceneManager.teamStateResetsAfterScene())
        {
            getGameManager().currentTeam = getGameManager().teamTwo;
        }
        else
        {
            getGameManager().currentTeam = getGameManager().teamOne;
        }
    }


    public static void next() {
        incrementTeam();
        getGameManager().stage.setScene(SceneManager.getScene());
        getGameManager().stage.setTitle("Team " + getTeamNumber());
        getGameManager().stage.show();
    }
    private void createCards()
    {

        ArrayList<String> answers = new ArrayList<String>();
        answers.add("a");
        answers.add("b");
        answers.add("c");
        unseenCards = new ArrayList<Card>();
        seenCards = new ArrayList<Card>();
        try
        {
            //place holder for actual cards
            throw new Exception();
        }
        catch (Exception e)
        {
            //default behavior until we have way to load in cards
            for (int i = 0; i <100; i++)
            {
                unseenCards.add(new Card("Card " + i,5,new Question("Question Example?"+ i, answers)));
            }

        }
    }
    static public Card getCard()
    {
        Card chosenCard;
        Collections.shuffle(getGameManager().unseenCards);
        chosenCard = getGameManager().unseenCards.remove(0);
        getGameManager().seenCards.add(chosenCard);
        return chosenCard;
    }

    static public Question getQuestion(){
        if(getCurrentTeam()==teamOne) {
            Collections.shuffle(getGameManager().seenCards);
            quizQuestion = seenCards.get(0).getQuestion();
        }
        return quizQuestion;
    }

    static public void setCorrectAnswer(String ca){
        correctAnswer=ca;
    }


    static public void addPoints(int points)
    {
        if (points < 0)
        {
            if (currentlyFirstTeam())
            {
                getGameManager().teamTwo.changePointsToSpend(points);
            }
            else
            {
                getGameManager().teamOne.changePointsToSpend(points);
            }
        }
        else
        {
            getGameManager().currentTeam.changePointsToSpend(points);
        }
    }

    static public TeamClass getTeamOne() {
        return teamOne;
    }
    static public TeamClass getTeamTwo(){
        return teamTwo;
    }
}