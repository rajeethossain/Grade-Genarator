package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class StudentData {
    private String id;
    private String name;
    private double cgpa;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    private File data = new File("Data.txt");
    public File getData() {
        return data;
    }

    void write(File file){
        try {
            FileWriter write = new FileWriter(file, true);

            write.append(name + ";" + id + ";" + cgpa + "\n");

            write.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveData() {
        write(data);
    }

    public ArrayList<StudentData> recordList;
    public void studentList() {
        recordList = new ArrayList<StudentData>();
        try {
            Scanner read = new Scanner(data);
            try {
                while (read.hasNextLine()) {
                    String data = read.nextLine();
                    String[] dataSplit = data.split(";");
                    StudentData personData = new StudentData();
                    personData.setName(dataSplit[0]);
                    personData.setId(dataSplit[1]);
                    personData.setCgpa(Double.parseDouble(dataSplit[2]));

                    recordList.add(personData);
                }

            } catch (Exception f) {
                System.out.println(f.getMessage());
            }
        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
        }
    }
}

public class Controller {
    StudentData s = new StudentData();
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private TextField cgpa;
    @FXML
    private TextArea area1;
    @FXML
    private TextArea area2;
    @FXML
    private CheckBox tick1;
    @FXML
    private CheckBox tick2;
    @FXML
    private CheckBox tick3;

    private void checkEntry(){
        if(!name.getText().equals("")){
            tick1.setSelected(true);
        } else {
            name.setText("");
            tick1.setSelected(false);
        }


        if (!id.getText().equals("")) {
            tick2.setSelected(true);
        } else {
            id.setText("");
            tick2.setSelected(false);
        }

        try {
            if (Double.parseDouble(cgpa.getText()) <= 4){
                tick3.setSelected(true);
            } else {
                cgpa.setText("");
                tick3.setSelected(false);
            }
        } catch (Exception e){
            cgpa.setText("");
            tick3.setSelected(false);
        }
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
    private void onSaveClick(){
        checkEntry();
        int flag = 0;
        if (tick1.isSelected() && tick2.isSelected() && tick3.isSelected()) {
            s.setName(name.getText());
            s.setId(id.getText());
            try {
                s.setCgpa(Double.parseDouble(cgpa.getText()));
            }
            catch (Exception f){
                cgpa.setText("");
                flag = 1;
            }

            if(flag == 0) {
                s.saveData();
                name.setText("");
                id.setText("");
                cgpa.setText("");
            }
        } else {

        }

    }

    @FXML
    private void onShowClick(){
        s.studentList();
        area1.setText("");
        area2.setText("");
        for (StudentData data : s.recordList) {
            area1.appendText("Name\t: " + data.getName() + "\n");
            area1.appendText("ID\t\t: " + data.getId() + "\n");
            area1.appendText("CGPA\t: " + data.getCgpa() + "\n");
            area1.appendText("\n\n");
        }

        ArrayList<Double> cgpaList = new ArrayList<Double>();

        for (StudentData data : s.recordList) {
            cgpaList.add(data.getCgpa());
        }
        Collections.sort(cgpaList);

        for (StudentData data : s.recordList) {
            if(data.getCgpa() == cgpaList.get(0)) {
                area2.appendText("Lowest CGPA:\n\n");
                area2.appendText("Name\t: " + data.getName() + "\n");
                area2.appendText("ID\t\t: " + data.getId() + "\n");
                area2.appendText("CGPA\t: " + data.getCgpa() + "\n");
                area2.appendText("\n\n");
            }

            if(data.getCgpa() == cgpaList.get(cgpaList.size()-1)) {
                area2.appendText("Highest CGPA:\n\n");
                area2.appendText("Name\t: " + data.getName() + "\n");
                area2.appendText("ID\t\t: " + data.getId() + "\n");
                area2.appendText("CGPA\t: " + data.getCgpa() + "\n");
                area2.appendText("\n\n");
            }
        }
    }
}
