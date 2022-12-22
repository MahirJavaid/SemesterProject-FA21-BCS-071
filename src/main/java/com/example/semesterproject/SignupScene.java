package com.example.semesterproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;

import static com.example.semesterproject.Driver.main;
import static com.example.semesterproject.Driver.stage;

public class SignupScene {
    public static Scene signup;

    public static Scene signup() {
        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(0,190,250), new CornerRadii(0), new Insets(0))));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text text = new Text("Sign Up Form");
        text.setFont(new Font("Times new Roman", 25));
        grid.add(text,0,0,2,1);
        Label nameLabel = new Label("Enter your Name:");
        nameLabel.setFont(new Font("Times new Roman", 15));
        Label passwordLabel = new Label("Enter your Password");
        passwordLabel.setFont(new Font("Times new Roman", 15));
        TextField nameField = new TextField();
        nameField.setPromptText("Enter name");
        TextField passwordField = new TextField();
        passwordField.setPromptText("Enter password");
        Text text1 = new Text();
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(text1, 1, 3);
        Button confirm = new Button("Confirm");
        confirm.setFont(new Font("Times new Roman", 15));
        grid.add(confirm, 1, 4);
        Button back = new Button("Back");
        back.setFont(new Font("Times new Roman", 15));
        grid.add(back, 2,4);

        confirm.setOnAction(actionEvent -> {
            String name = nameField.getText().toString();
            String password = passwordField.getText().toString();

            if (name == null || password == null || name.equals("") || password.equals("")) {
                text1.setText("Name or Password is empty");
                return;
            }

            try {
                FileWriter fileWriter = new FileWriter("Accounts.txt", true);
                fileWriter.write(nameField.getText() + "\t" + passwordField.getText() + "\n");
                fileWriter.close();

            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        });

        back.setOnAction(actionEvent -> {
            stage.setScene(main);
        });

        return new Scene(grid, 800, 550);
    }
}
