package com.example.semesterproject;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.example.semesterproject.Driver.main;
import static com.example.semesterproject.Driver.stage;

public class LoginScene {
    public static GridPane grid = new GridPane();
    public static Scene login;
    public static String storage[] = new String[10];

    static ImageView backImg2;
    static {
        backImg2 = new ImageView(new Image("D:\\HP 840\\Documents\\Study Material\\3rd Semester\\OOP\\SemesterProject\\src\\ImageResources\\Page1.jpg"));
        backImg2.setFitWidth(1000);
        backImg2.setFitHeight(600);
        backImg2.setOpacity(0.5);
        backImg2.setMouseTransparent(true);
    }

    public static Scene login() {
        Text text1 = new Text("Welcome User!");
        text1.setFont(new Font("Times new Roman", 30));

        grid.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(text1, 0, 0);

        Button logoutButton = new Button("Log Out");
        logoutButton.setFont(new Font("Times new Roman", 15));
        logoutButton.setOnAction(actionEvent -> {
            stage.setTitle("Login Page");
            stage.setScene(main);
        });
        grid.add(logoutButton, 0, 6);
        logoutButton.setPrefSize(150, 25);

        Button addButton = new Button("Add Stock");
        addButton.setPrefSize(150, 25);
        addButton.setFont(new Font("Times new Roman", 15));
        addButton.setOnAction(actionEvent -> {
            Inventory.add();
        });

        Button updateButton = new Button("Remove Item");
        updateButton.setPrefSize(150, 25);
        updateButton.setFont(new Font("Times new Roman", 15));
        updateButton.setOnAction(actionEvent -> {
            Inventory.remove();
        });

        Button salesButton = new Button("Add Sales Info.");
        salesButton.setPrefSize(150, 25);
        salesButton.setFont(new Font("Times new Roman", 15));
        salesButton.setOnAction(actionEvent -> {
            CalculateSales.sales();
        });

        Button profitButton = new Button("Calculate Profit");
        profitButton.setPrefSize(150, 25);
        profitButton.setFont(new Font("Times new Roman", 15));
        profitButton.setOnAction(actionEvent -> {
            CalculateSales.profit();
        });

        grid.add(addButton, 0, 2);
        grid.add(updateButton, 0, 3);
        grid.add(salesButton, 0, 4);
        grid.add(profitButton, 0, 5);

        /*try {
            String str;
            String input1 = "";
            String input2 = "";
            String input3 = "";
            FileReader fileReader = new FileReader("UserData.txt");
            BufferedReader buffer = new BufferedReader(fileReader);
            while ((str = buffer.readLine()) != null) {
                storage = str.split("\t");
                for (int i = 0; i < storage.length; i++) {
                    System.out.println(storage[i]);
                    input1 = storage[1];
                    input2 = storage[2];
                    input3 = storage[3];
                }
                VBox vBox = new VBox();
                Label l1 = new Label(input1);
                Label l2 = new Label(input2);
                Label l3 = new Label(input3);
                vBox.getChildren().addAll(l1,l2,l3);
                vBox.setPrefSize(100,50);
                vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, new Insets(0))));
                grid.add(vBox,grid.getColumnCount(),2,3,1);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }*/

        StackPane stack2 = new StackPane();
        stack2.getChildren().add(backImg2);
        stack2.getChildren().add(grid);
        stage.setTitle("Home Page");
        return new Scene(stack2, 1000, 600);
    }
}
