package backend;

import main.GameManager;

public class Card {
    String text;
    int points;
    boolean seen = false;
    Question question;

    public Card(String text, int points, Question question)
    {
        this.text = text;
        this.points = points;
        this.question = question;
    }
    public String getTitle()
    {
        if (this.points <0)
        {
            return "Opposing Team Loses " + this.points + " Points";
        }
        else
        {
            return "Team Gains " + this.points + " Points";
        }
    }
    public String getText()
    {
        return this.text;
    }
    public void play()
    {
        this.seen = true;
        GameManager.addPoints(this.points);
    }

}
