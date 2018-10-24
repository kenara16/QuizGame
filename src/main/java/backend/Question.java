package backend;

import java.util.List;

public class Question {

    String question;
    List<String> options; // first one is answer;
    // String answer;

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", options=" + options +
                '}';
    }

    public Question() {}

    public Question(String question, List<String> options) {
        this.question = question;
        this.options = options;
    }
}
