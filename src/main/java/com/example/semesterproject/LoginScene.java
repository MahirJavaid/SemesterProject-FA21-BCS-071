package com.example.semesterproject;

import javafx.geometry.Insets;
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
            stage.setScene(main);
        });
        grid.add(logoutButton,26,15);

        Button addButton = new Button("Add Stock");
        addButton.setPrefSize(150,150);
        addButton.setFont(new Font("Times new Roman", 15));
        addButton.setOnAction(actionEvent -> {
            add();
        });

        Button updateButton = new Button("Remove Item");
        updateButton.setPrefSize(150,150);
        updateButton.setFont(new Font("Times new Roman", 15));
        updateButton.setOnAction(actionEvent -> {
            update();
        });

        Button salesButton = new Button("Add Sales Info.");
        salesButton.setPrefSize(150,150);
        salesButton.setFont(new Font("Times new Roman", 15));
        salesButton.setOnAction(actionEvent -> {
            sales();
        });

        Button profitButton = new Button("Calculate Profit");
        profitButton.setPrefSize(150,150);
        profitButton.setFont(new Font("Times new Roman", 15));
        profitButton.setOnAction(actionEvent -> {
            profit();
        });

        grid.add(addButton,0,2);
        grid.add(updateButton,0,3);
        grid.add(salesButton,0,4);
        grid.add(profitButton,0,5);

        return new Scene(grid, 1000,600);
    }

    public static Scene add(){
        GridPane grid1 = new GridPane();
        grid1.setHgap(25);
        grid1.setVgap(25);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        Label item = new Label("Name of Item:");
        item.setFont(new Font("Times new Roman",15));
        grid1.add(item,0,1);
        TextField itemField = new TextField();
        itemField.setPromptText("Enter Name of Fruit");
        grid1.add(itemField,1,1);
        Label quantity = new Label("Quantity:");
        quantity.setFont(new Font("Times new Roman",15));
        grid1.add(quantity,0,2);
        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter Quantity of Fruit");
        grid1.add(quantityField,1,2);
        Label price = new Label("Price of item:");
        price.setFont(new Font("Times new Roman",15));
        grid1.add(price,0,3);
        TextField priceField = new TextField();
        priceField.setPromptText("Enter Price of Fruit");
        grid1.add(priceField,1,3);
        Button add_btn = new Button("Add");
        add_btn.setFont(new Font("Times new Roman", 15));
        grid1.add(add_btn,2,5);
        add_btn.setOnAction(actionEvent -> {
            Text t1 = new Text();
            t1.setText(itemField.getText());
            grid.add(t1,1,1);
            Text t2 = new Text();
            t2.setText(quantityField.getText());
            grid.add(t2,1,2);
            Text t3 = new Text();
            t3.setText(priceField.getText());
            grid.add(t3,1,3);
        });
        Scene scene1 = new Scene(grid1,400,300);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();
        return scene1;
    }

    public static Scene profit(){
        GridPane grid1 = new GridPane();
        grid1.setHgap(25);
        grid1.setVgap(25);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        Label price = new Label("Market price of Fruits");
        price.setFont(new Font("Times new Roman",15));
        grid1.add(price,0,1);
        TextField priceField = new TextField();
        priceField.setPromptText("Enter Market price of Fruits");
        grid1.add(priceField,1,1);
        Label price2 = new Label("Selling price of Fruits");
        price2.setFont(new Font("Times new Roman",15));
        grid1.add(price2,0,2);
        TextField priceField2 = new TextField();
        priceField2.setPromptText("Enter Selling price of Fruits");
        grid1.add(priceField2,1,2);
        Button calculate_btn = new Button("Calculate");
        calculate_btn.setFont(new Font("Times new Roman", 15));
        grid1.add(calculate_btn,1,3);
        /*calculate_btn.setOnAction(actionEvent -> {
            Text t1 = new Text();
        });*/
        Scene scene1 = new Scene(grid1,400,300);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();
        return scene1;
    }

    public static Scene sales(){
        GridPane grid1 = new GridPane();
        grid1.setHgap(25);
        grid1.setVgap(25);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        Label fruits = new Label("Name of Fruit");
        fruits.setFont(new Font("Times new Roman",15));
        grid1.add(fruits,0,1);
        TextField fruitField = new TextField();
        fruitField.setPromptText("Enter Name of Fruit");
        grid1.add(fruitField,1,1);
        Label quantity = new Label("Sold quantity of Fruit");
        quantity.setFont(new Font("Times new Roman",15));
        grid1.add(quantity,0,2);
        TextField quantityField = new TextField();
        quantityField.setPromptText("Enter Name of Fruit");
        grid1.add(quantityField,1,2);
        Button done_btn = new Button("Done");
        done_btn.setFont(new Font("Times new Roman", 15));
        grid1.add(done_btn,1,3);
        /*done_btn.setOnAction(actionEvent -> {
            Text t1 = new Text();
        });*/
        Scene scene1 = new Scene(grid1,400,300);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();
        return scene1;
    }

    public static Scene update(){
        GridPane grid1 = new GridPane();
        grid1.setHgap(25);
        grid1.setVgap(25);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        Label removeFruits = new Label("Name of Fruit to Remove");
        removeFruits.setFont(new Font("Times new Roman",15));
        grid1.add(removeFruits,0,1);
        TextField removeField = new TextField();
        removeField.setPromptText("Enter Name of Fruit");
        grid1.add(removeField,1,1);
        Button remove_btn = new Button("Remove");
        remove_btn.setFont(new Font("Times new Roman", 15));
        grid1.add(remove_btn,1,3);
        remove_btn.setOnAction(actionEvent -> {

        });
        Scene scene1 = new Scene(grid1,400,300);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.show();
        return scene1;
    }
}
