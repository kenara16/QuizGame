package backend;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Story {

    private boolean isUsed;
    private int number;
    private int point;
    private CheckBox cBox;
    private Text text;
    private GridPane grid;

    public Story(int number, int point) {
        this.isUsed = false;
        this.number = number;
        this.point = point;
        this.cBox = new CheckBox();
        this.text = new Text("Story " + this.number + "\n" + this.point + " story point");

        this.grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(cBox, 0, 0);
        GridPane.setConstraints(text, 1, 0);
        grid.getChildren().addAll(this.cBox, this.text);
    }

    public boolean GetIsUsed() {
        return isUsed;
    }

    public void SetUsed(boolean used) {
        isUsed = used;
    }

    public int GetNumber() {
        return number;
    }

    public void GetNumber(int number) {
        this.number = number;
    }

    public int GetPoint() {
        return point;
    }

    public void SetPoint(int point) {
        this.point = point;
        this.text.setText("Story " + this.number + "\n" + this.point + " story point");
    }

    public CheckBox GetCheckBox() {
        return this.cBox;
    }

    public boolean IsCheckBoxSelected() {
        return this.cBox.isSelected();
    }

    public Text GetText() {
        return text;
    }

    public void SetText(String str) {
        this.text.setText(str);
    }

    public GridPane GetGridPane() {
        return this.grid;
    };

    public void SetCheckBoxVisible(boolean isVisible) {
        this.cBox.setVisible(isVisible);
    }

    public void SetCheckBoxSelect(boolean isSelected) {
        this.cBox.setSelected(isSelected);
    }
}
