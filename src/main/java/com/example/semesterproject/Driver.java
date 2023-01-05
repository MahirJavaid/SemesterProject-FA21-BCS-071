package com.example.semesterproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver extends Application {

    public static Stage stage;
    public static GridPane grid = new GridPane();
    public static Scene main;
    public static String username;

    static ImageView backImg;
    static {
        backImg = new ImageView(new Image("D:\\HP 840\\Documents\\Study Material\\3rd Semester\\OOP\\SemesterProject\\src\\ImageResources\\frontImage.jpg"));
        backImg.setFitWidth(800);
        backImg.setFitHeight(550);
        backImg.setOpacity(0.8);
        backImg.setMouseTransparent(true);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(grid);
        stage.setTitle("Login Page");
        main = login();
        Driver.stage = stage;
        stage.setScene(main);
        stage.show();
    }

    public static Scene login(){
        GridPane grid2 = new GridPane();
        grid2.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(25);
        grid2.setVgap(25);
        grid2.setPadding(new Insets(25,25,25,25));
        Text text = new Text(1,1,"Login to your Account");
        text.setFont(new Font("Times new Roman", 25));
        grid2.add(text,0,0,2,1);
        Label userName = new Label("User Name:");
        userName.setFont(new Font("Times new Roman", 15));
        grid2.add(userName,0,1);
        TextField userTextField = new TextField();
        userTextField.setPromptText("Enter Username");
        grid2.add(userTextField,1,1);
        Label password = new Label("Password:");
        password.setFont(new Font("Times new Roman",15));
        grid2.add(password,0,2);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");
        grid2.add(passwordField,1,2);
        Button loginButton = new Button("Login");
        Button signupButton = new Button("Sign Up");
        loginButton.setFont(new Font("Times new Roman",15));
        signupButton.setFont(new Font("Times new Roman",15));
        grid2.add(loginButton,0,3);
        grid2.add(signupButton,1,3);
        Text text2 = new Text();
        grid2.add(text2,1,4);
        Text text3 = new Text();
        grid2.add(text3,1,5);

        StackPane stack = new StackPane();
        stack.getChildren().add(backImg);
        stack.getChildren().add(grid2);
        Scene scene2 = new Scene( stack, 800, 550 );

        Event1(signupButton);
        Event2(loginButton, userTextField, passwordField, text2, text3);
        return scene2;
    }

    public static void Event1(Button signupButton){
        signupButton.setOnAction(actionEvent -> {
            stage.setScene(SignupScene.signup());
        });
    }

    public static void Event2(Button loginButton, TextField userTextField, PasswordField passwordField, Text text2, Text text3){
        loginButton.setOnAction(actionEvent -> {
            boolean b1 = false;
            String lineReader;
            username = userTextField.getText().toString();
            String password = passwordField.getText().toString();

            if( username == null || password == null || username.equals("") || password.equals("")){
                text2.setText("Username or Password is empty");
                return;
            }
            try {
                FileReader fileReader = new FileReader("Accounts.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while((lineReader = bufferedReader.readLine()) != null) {
                    if(lineReader.equals( username + "\t" + password )){
                        b1 = true;
                        break;
                    }
                    /*else {
                        text3.setText("Incorrect Username or Password");
                    }*/
                }
                fileReader.close();
            } catch (IOException exception){
                throw new RuntimeException(exception);
            }
            if(b1){
                stage.setScene(LoginScene.login());
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
