package com.example.kursova.commands;

import com.example.kursova.incurances.CarInsurance;
import com.example.kursova.incurances.HouseInsurance;
import com.example.kursova.incurances.Insurance;
import com.example.kursova.incurances.PersonInsurance;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    public static void Connect(ArrayList<Insurance> insurances) {
        String url = "jdbc:sqlserver://localhost:1433;database=Insurance;user=user;password=1111";

        Label l;
        Stage stage = new Stage();
        stage.setTitle("BD");
        Button ok = new Button(" ok ");

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(18));
        vBox.setAlignment(Pos.CENTER);

        try (Connection connection = DriverManager.getConnection(url)){
            try(Statement st = connection.createStatement()) {
                try (ResultSet resultSet1 = st.executeQuery("select * from Person")) {

                    while (resultSet1.next()) {
                        PersonInsurance p = new PersonInsurance(resultSet1.getInt("age"), resultSet1.getInt("health"));
                        insurances.add(p);
                    }

                    try (ResultSet resultSet2 = st.executeQuery("select * from Car")) {

                        while (resultSet2.next()) {
                            CarInsurance c = new CarInsurance(resultSet2.getString("type"), resultSet2.getInt("motor_volume"), resultSet2.getInt("car_price"));
                            insurances.add(c);
                        }

                        try (ResultSet resultSet3 = st.executeQuery("select * from House")) {
                            while (resultSet3.next()) {
                                HouseInsurance h = new HouseInsurance(resultSet3.getInt("area"), resultSet3.getInt("house_price"));
                                insurances.add(h);
                            }
                        }
                    }
                }
            }
            l = new Label("Completed successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            l = new Label("Error");
        }

        ok.setOnAction(e->stage.close());

        vBox.getChildren().addAll(l, ok);
        Scene sc_sort = new Scene(vBox, 200, 100);
        stage.setScene(sc_sort);
        stage.showAndWait();
    }
}
