package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ActionController {
    // var names must conform to the ones in layout.fxml
    @FXML
    private Label labName;
    @FXML
    private TextField txtName;
    @FXML
    private Label labAge;
    @FXML
    private TextField txtAge;
    @FXML
    private Label labResult;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnRead;

    private File myf = new File("./data", "student.txt");

    @FXML
    public void SaveFile() {
        labResult.setText("Saving data " + txtName.getText());
        saveToFile();
    }

    private void saveToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(myf, true));
            pw.print(txtName.getText() + ",");
            pw.print(txtAge.getText());
            pw.println();
            pw.close();
        } catch (IOException e) {
            // EXCEPTION HANDLER
        }
    }

    @FXML
    public void readFile() {
        labResult.setText(readFromFile());
    }

    private String readFromFile() {
        Scanner sfile;
        String name;
        int age;
        String result;
        try {
            result = "RESULT";
            sfile = new Scanner(myf);
            while (sfile.hasNextLine()) {
                String aLine = sfile.nextLine();
                Scanner sline = new Scanner(aLine);
                sline.useDelimiter(",");
                while (sline.hasNext()) {
                    name = sline.next();
                    age = Integer.parseInt(sline.next());
                    result = result + "\n" + name + ", age " + age;
                }
                sline.close();
            }
            sfile.close();
            System.out.println(result);
            return result;
        } catch (FileNotFoundException e) {
            return "File to read " + myf + " not found!";
        }
    }
}
