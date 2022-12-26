package com.example.semesterproject;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.semesterproject.Driver.main;
import static com.example.semesterproject.Driver.stage;

public class LoginScene {
    public static GridPane grid = new GridPane();
    public static Scene login;
    public static Scene login(){
        Text text1 = new Text("Welcome User!");
        text1.setFont(new Font("Times new Roman", 30));

        grid.setBackground(new Background(new BackgroundFill(Color.rgb(100,90,140), new CornerRadii(0), new Insets(0))));
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(text1, 0,0);

        Button logoutButton = new Button("Log Out");
        logoutButton.setFont(new Font("Times new Roman", 15));
        logoutButton.setOnAction(actionEvent -> {
            stage.setTitle("Login Page");
            stage.setScene(main);
        });
        grid.add(logoutButton,0,6);
        logoutButton.setPrefSize(150,25);


        Button addButton = new Button("Add Stock");
        addButton.setPrefSize(150,25);
        addButton.setFont(new Font("Times new Roman", 15));
        addButton.setOnAction(actionEvent -> {
            Inventory.add();
        });

        Button updateButton = new Button("Remove Item");
        updateButton.setPrefSize(150,25);
        updateButton.setFont(new Font("Times new Roman", 15));
        updateButton.setOnAction(actionEvent -> {
            Inventory.remove();
        });

        Button salesButton = new Button("Add Sales Info.");
        salesButton.setPrefSize(150,25);
        salesButton.setFont(new Font("Times new Roman", 15));
        salesButton.setOnAction(actionEvent -> {
            CalculateSales.sales();
        });

        Button profitButton = new Button("Calculate Profit");
        profitButton.setPrefSize(150,25);
        profitButton.setFont(new Font("Times new Roman", 15));
        profitButton.setOnAction(actionEvent -> {
            CalculateSales.profit();
        });

        grid.add(addButton,0,2);
        grid.add(updateButton,0,3);
        grid.add(salesButton,0,4);
        grid.add(profitButton,0,5);

        stage.setTitle("Home Page");
        return new Scene(grid, 1000,600);
    }
}
