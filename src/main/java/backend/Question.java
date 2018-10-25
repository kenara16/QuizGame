package backend;

import java.util.ArrayList;

public class Question {

    String question;
    ArrayList<String> options; // first one is answer;
    // String answer;

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + options +
                '}';
    }

    public Question(String question, ArrayList<String> options) {
        this.question = question;
        this.options = options;
    }

    public ArrayList<String> getAnswers()
    {
        return this.options;
    }
    public String getQuestion()
    {
        return this.question;
    }
    public String getCorrectAnswer()
    {
        return this.options.get(0);
    }
}
