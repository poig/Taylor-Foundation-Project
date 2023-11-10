package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MyWriteRead extends Application {
    private Label labName = new Label("Enter name ");
    private Label labAge = new Label("Enter age  ");
    private Label labResult = new Label("RESULT");
    private TextField txtName = new TextField();
    private TextField txtAge = new TextField();
    private Button btnSave = new Button("Save");
    private Button btnRead = new Button("Read");
    private File myf = new File("./data", "student.txt");

    @Override
    public void start(Stage mystage) throws Exception {

        btnSave.setOnAction(e -> {
            labResult.setText("Saving data " + txtName.getText());
            saveToFile();
        });

        btnRead.setOnAction(e -> {
            readFromFile();
        });

        FlowPane layout = new FlowPane();
        HBox hbox1 = new HBox(5);
        HBox hbox2 = new HBox(5);
        hbox1.setTranslateX(20);
        VBox vbox1 = new VBox(15);
        VBox vbox2 = new VBox(2);
        hbox1.getChildren().addAll(vbox1, vbox2);
        hbox2.getChildren().addAll(btnSave, btnRead);
        vbox1.getChildren().addAll(labName, labAge, hbox2, labResult);
        vbox2.getChildren().addAll(txtName, txtAge);
        layout.getChildren().addAll(hbox1);
        // layout.getChildren().addAll(labName, txtName, labAge, txtAge, labResult,
        // btnSave);
        Scene scene = new Scene(layout, 640, 400);
        mystage.setScene(scene);
        mystage.show();
    }

    public void saveToFile() {
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

    public void readFromFile() {
        Scanner sfile;
        String name;
        int age;
        try {
            labResult.setText("RESULT");
            sfile = new Scanner(myf);
            String allData = "";
            while (sfile.hasNextLine()) {
                String aLine = sfile.nextLine();
                Scanner sline = new Scanner(aLine);
                sline.useDelimiter(",");
                while (sline.hasNext()) {
                    name = sline.next();
                    age = Integer.parseInt(sline.next());
                    labResult.setText(labResult.getText() + "\n" + name + " and " + age);
                    allData = allData + "\n" + name + " and " + age;
                }
                sline.close();
            }
            sfile.close();
            System.out.println(allData);
        } catch (FileNotFoundException e) {
            labResult.setText("File to read " + myf + " not found!");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
