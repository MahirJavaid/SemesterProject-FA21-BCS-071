package com.example.semesterproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;

import static com.example.semesterproject.Driver.main;
import static com.example.semesterproject.Driver.stage;

public class SignupScene {
    public static Scene signup;

    static ImageView backImg1;
    static {
        backImg1 = new ImageView(new Image("D:\\HP 840\\Documents\\Study Material\\3rd Semester\\OOP\\SemesterProject\\src\\ImageResources\\backgroundPic.jpg"));
        backImg1.setFitWidth(800);
        backImg1.setFitHeight(550);
        backImg1.setOpacity(0.75);
        backImg1.setSmooth(true);
        backImg1.setMouseTransparent(true);
    }

    public static Scene signup() {
        GridPane grid = new GridPane();
        grid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text text = new Text("Sign Up Form");
        text.setFont(new Font("Times new Roman", 25));
        grid.add(text,0,3 );
        Label nameLabel = new Label("Enter your Name:");
        nameLabel.setFont(new Font("Times new Roman", 15));
        Label passwordLabel = new Label("Enter your Password");
        passwordLabel.setFont(new Font("Times new Roman", 15));
        TextField nameField = new TextField();
        nameField.setPromptText("Enter name");
        TextField passwordField = new TextField();
        passwordField.setPromptText("Enter password");
        Text text1 = new Text();
        grid.add(nameLabel, 0, 4);
        grid.add(nameField, 1, 4);
        grid.add(passwordLabel, 0, 5);
        grid.add(passwordField, 1, 5);
        grid.add(text1, 1, 6);
        Button confirm = new Button("Confirm");
        confirm.setFont(new Font("Times new Roman", 15));
        grid.add(confirm, 0, 7);
        Button back = new Button("Back");
        back.setFont(new Font("Times new Roman", 15));
        grid.add(back, 1,7);

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
            stage.setTitle("Login Page");
            stage.setScene(main);
        });

        back.setOnAction(actionEvent -> {
            stage.setTitle("Login Page");
            stage.setScene(main);
        });

        StackPane stack1 = new StackPane();
        stack1.getChildren().add(backImg1);
        stack1.getChildren().add(grid);
        stage.setTitle("Sign Up");
        return new Scene(stack1, 800, 550);
    }
}
