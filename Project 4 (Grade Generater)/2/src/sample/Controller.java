package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;
import java.util.Collections;

class Student{

    private int attMark;
    private int assMark;
    private int midMark;
    private int finalMark;
    private int quizMark;

    public void setAttMark(int attMark) {
        this.attMark = attMark;
    }

    public void setAssMark(int assMark) {
        this.assMark = assMark;
    }

    public void setMidMark(int midMark) {
        this.midMark = midMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }

    public void getquizMark(int qz1, int qz2, int qz3, int qz4, int qz5, int qz6){
        ArrayList<Integer> quizlist = new ArrayList<Integer>();
        quizlist.add(qz1);
        quizlist.add(qz2);
        quizlist.add(qz3);
        quizlist.add(qz4);
        quizlist.add(qz5);
        quizlist.add(qz6);
        Collections.sort(quizlist);

        int avgQzMark = (quizlist.get(3) + quizlist.get(4) + quizlist.get(5))/3;
        quizMark = avgQzMark * 2;
    }

    public String getGrade(){
        int total = attMark + assMark + midMark + finalMark + quizMark;

        if (total >= 90){
            return "A";
        }
        else if (total >= 86 && total <= 89){
            return "A-";
        }
        else if (total >= 82 && total <= 85){
            return "B+";
        }
        else if (total >= 78 && total <= 81){
            return "B";
        }
        else if (total >= 74 && total <= 77){
            return "B-";
        }
        else if (total >= 70 && total <= 73){
            return "C+";
        }
        else if (total >= 66 && total <= 69){
            return "C";
        }
        else if (total >= 62 && total <= 65){
            return "C-";
        }
        else if (total >= 58 && total <= 61){
            return "D+";
        }
        else if (total >= 55 && total <= 57){
            return "D";
        }
        else{
            return "F";
        }
    }

}


public class Controller {
    @FXML
    private AnchorPane frame;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;
    @FXML
    private TextField field6;
    @FXML
    private TextField field7;
    @FXML
    private TextField field8;
    @FXML
    private TextField field9;
    @FXML
    private TextField field10;
    @FXML
    private Label output;

    @FXML
    private CheckBox tick1;
    @FXML
    private CheckBox tick2;
    @FXML
    private CheckBox tick3;
    @FXML
    private CheckBox tick4;
    @FXML
    private CheckBox tick5;
    @FXML
    private CheckBox tick6;
    @FXML
    private CheckBox tick7;
    @FXML
    private CheckBox tick8;
    @FXML
    private CheckBox tick9;
    @FXML
    private CheckBox tick10;

    private void checkEntry(){
        try {
            if (Integer.parseInt(field1.getText()) >= 0 && Integer.parseInt(field1.getText()) <= 20) {
                tick1.setSelected(true);
            } else {
                field1.setText("");
                tick1.setSelected(false);
            }
        } catch (Exception e){
            field1.setText("");
            tick1.setSelected(false);
        }

        try {
            if (Integer.parseInt(field2.getText()) <= 20) {
                tick2.setSelected(true);
            } else {
                field2.setText("");
                tick2.setSelected(false);
            }
        } catch (Exception e){
            field2.setText("");
            tick2.setSelected(false);
        }


        try {
            if (Integer.parseInt(field3.getText()) <= 20) {
                tick3.setSelected(true);
            } else {
                field3.setText("");
                tick3.setSelected(false);
            }
        } catch (Exception e){
            field3.setText("");
            tick3.setSelected(false);
        }

        try {
            if (Integer.parseInt(field4.getText()) <= 20) {
                tick4.setSelected(true);
            } else {
                field4.setText("");
                tick4.setSelected(false);
            }
        } catch (Exception e){
            field4.setText("");
            tick4.setSelected(false);
        }

        try {
            if (Integer.parseInt(field5.getText()) <= 20) {
                tick5.setSelected(true);
            } else {
                field5.setText("");
                tick5.setSelected(false);
            }
        } catch (Exception e){
            field5.setText("");
            tick5.setSelected(false);
        }

        try {
            if (Integer.parseInt(field6.getText()) <= 20) {
                tick6.setSelected(true);
            } else {
                field6.setText("");
                tick6.setSelected(false);
            }
        } catch (Exception e){
            field6.setText("");
            tick6.setSelected(false);
        }

        try {
            if (Integer.parseInt(field7.getText()) <= 5) {
                tick7.setSelected(true);
            } else {
                field7.setText("");
                tick7.setSelected(false);
            }
        } catch (Exception e){
            field7.setText("");
            tick7.setSelected(false);
        }

        try {
            if (Integer.parseInt(field8.getText()) <= 10) {
                tick8.setSelected(true);
            } else {
                field8.setText("");
                tick8.setSelected(false);
            }
        } catch (Exception e){
            field8.setText("");
            tick8.setSelected(false);
        }

        try {
            if (Integer.parseInt(field9.getText()) <= 20) {
                tick9.setSelected(true);
            } else {
                field9.setText("");
                tick9.setSelected(false);
            }
        } catch (Exception e){
            field9.setText("");
            tick9.setSelected(false);
        }

        try {
            if (Integer.parseInt(field10.getText()) <= 25) {
                tick10.setSelected(true);
            } else {
                field10.setText("");
                tick10.setSelected(false);
            }
        } catch (Exception e){
            field10.setText("");
            tick10.setSelected(false);
        }
    }

    private void setValues(Student s){
        int qz1 = Integer.parseInt(field1.getText());
        int qz2 = Integer.parseInt(field2.getText());
        int qz3 = Integer.parseInt(field3.getText());
        int qz4 = Integer.parseInt(field4.getText());
        int qz5 = Integer.parseInt(field5.getText());
        int qz6 = Integer.parseInt(field6.getText());
        s.setAttMark(Integer.parseInt(field7.getText()));
        s.setAssMark(Integer.parseInt(field8.getText()));
        s.setMidMark(Integer.parseInt(field9.getText()));
        s.setFinalMark(Integer.parseInt(field10.getText()));
        s.getquizMark(qz1, qz2, qz3, qz4, qz5, qz6);
    }

    @FXML
    private void mouseClick(){
        checkEntry();
    }

    @FXML
    private void keyPress(KeyEvent key){
        if (key.getCode() == KeyCode.TAB) {
            checkEntry();
        }
    }

    @FXML
    private void buttonClick(){
        checkEntry();
        if(tick1.isSelected() && tick2.isSelected() && tick3.isSelected() && tick4.isSelected() && tick5.isSelected() && tick6.isSelected() && tick7.isSelected() && tick8.isSelected() && tick9.isSelected() && tick10.isSelected()) {
            Student s1 = new Student();
            setValues(s1);
            output.setText(s1.getGrade());
        }
    }
}
