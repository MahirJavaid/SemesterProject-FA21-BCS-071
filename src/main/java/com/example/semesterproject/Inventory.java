package com.example.semesterproject;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static com.example.semesterproject.LoginScene.grid;

import java.util.ArrayList;

public class Inventory {
    public static Scene add(){
        GridPane grid1 = new GridPane();
        Scene scene1 = new Scene(grid1,400,300);
        Stage stage1 = new Stage();
        stage1.setScene(scene1);
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
            String input1 = itemField.getText();
            String input2 = quantityField.getText();
            String input3 = priceField.getText();

            int num1 = Integer.parseInt(input2);
            int num2 = Integer.parseInt(input3);

            ArrayList<Fruit> fruits = new ArrayList<>();
            Fruit f1 = new Fruit(input1, num1, num2);
            fruits.add(f1);

            VBox vbox = new VBox();
            Label l1 = new Label(f1.getName());
            l1.setFont(new Font("Times new Roman",15));
            Label l2 = new Label(String.valueOf(f1.getQuantity()));
            l2.setFont(new Font("Times new Roman",15));
            Label l3 = new Label(String.valueOf(f1.getPrice()));
            l3.setFont(new Font("Times new Roman",15));

            vbox.getChildren().addAll(l1,l2,l3);
            vbox.setPrefSize(100,50);
            vbox.setId(f1.getName());
            vbox.setBackground(new Background(new BackgroundFill(Color.LAVENDERBLUSH, CornerRadii.EMPTY, new Insets(0))));
            grid.add(vbox,grid.getColumnCount(),2,3,1);

        });

        stage1.show();
        return scene1;
    }
}
