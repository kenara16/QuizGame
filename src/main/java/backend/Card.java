package backend;

import main.GameManager;

public class Card {
    String title;
    String content;
    int points;
    boolean seen = false;
    Question question;

    public Card(String title, String content, int points, Question question)
    {
        this.title = title;
        this.content = content;
        this.points = points;
        this.question = question;
    }

    public Card(String content, int points, Question question)
    {
        this.title = title;
        this.content = content;
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
        return this.content;
    }

    public Question getQuestion(){
        return question;
    }

    public void play()
    {
        this.seen = true;
        GameManager.addPoints(this.points);
        //comment
    }

    @Override
    public String toString() {
        return "Card{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", points=" + points +
                ", seen=" + seen +
                ", question=" + question +
                '}';
    }
    public int getPoints()
    {
        return this.points;
    }
}
