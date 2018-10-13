package formattedItems;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;

import java.util.ArrayList;

public class QuizClass {

    private VBox quizContainer = new VBox();
    private Label question= new Label();
    //private Button answer = new Button();
    private ArrayList<Button> answerButtons= new ArrayList<Button>();
    private String borderStyle = new String("-fx-padding: 10;" +
            "-fx-border-style: solid inside;" +
            "-fx-border-width: 5;" +
            "-fx-border-insets: 10;" +
            "-fx-border-radius: 10;" +
            "-fx-border-color: black;");

    public QuizClass (ArrayList<String> ansText, String quizText){
        question.setText(quizText);
        quizContainer.getChildren().add(question);
        for(int i=0;i<ansText.size(); i++){
            Button answer = new Button (ansText.get(i));
            answer.setStyle(borderStyle);
            quizContainer.getChildren().add(answer);
            answerButtons.add(answer);
        }
    }

    public VBox getQuiz(){
        return quizContainer;
    }

}
