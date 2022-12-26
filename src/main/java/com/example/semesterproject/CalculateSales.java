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
import javafx.stage.Stage;

import static com.example.semesterproject.LoginScene.grid;

public class CalculateSales {
    public static Scene sales(){
        GridPane grid1 = new GridPane();
        grid1.setBackground(new Background(new BackgroundFill(Color.rgb(0,120,120), new CornerRadii(0), new Insets(0))));
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
        done_btn.setOnAction(actionEvent -> {
            Node n = grid.lookup("#"+fruitField.getText());
            if(n==null){
                return;
            }
            VBox v = (VBox)n;
            Label qL = ((Label)v.getChildren().get(1));
            int q1 = Integer.parseInt(quantityField.getText());
            int q2 = Integer.parseInt(qL.getText());
            if(q2 >= q1) {
                q1 = q2 - q1;
                qL.setText(String.valueOf(q1));
            }
        });
        Scene scene1 = new Scene(grid1,400,300);
        Stage stage1 = new Stage();
        stage1.setTitle("Calculate Sales");
        stage1.setScene(scene1);
        stage1.show();
        return scene1;
    }

    public static Scene profit(){
        GridPane grid1 = new GridPane();
        grid1.setBackground(new Background(new BackgroundFill(Color.rgb(0,120,120), new CornerRadii(0), new Insets(0))));
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
        calculate_btn.setOnAction(actionEvent -> {
            int q1 = Integer.parseInt(priceField.getText());
            int q2 = Integer.parseInt(priceField2.getText());
            q1 = q2 - q1;
            Stage s1 = new Stage();
            Scene c1 = new Scene(new Group(), 200,200);

            ((Group) c1.getRoot()).getChildren().add(new Label(String.valueOf(q1)));

            s1.setScene(c1);
            s1.show();
        });
        Scene scene1 = new Scene(grid1,400,300);
        Stage stage1 = new Stage();
        stage1.setTitle("Calculate Profit");
        stage1.setScene(scene1);
        stage1.show();
        return scene1;
    }
}
