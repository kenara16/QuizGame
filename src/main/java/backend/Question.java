package backend;

import java.util.ArrayList;

public class Question
{
    private String question;
    private ArrayList<String> answers;
    private String correctAnswer;


    public Question(String q, ArrayList<String>a, String ca){

        question=q;
        answers=a;
        correctAnswer=ca;
    }

    public String getQuestion(){
        return question;
    }

    public  ArrayList<String> getAnswers(){
        return answers;
    }

    public String getCorrectAnswer(){
        return  correctAnswer;
    }
}
