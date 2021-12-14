package com.example.kursova.commands;

import com.example.kursova.incurances.CarInsurance;
import com.example.kursova.incurances.HouseInsurance;
import com.example.kursova.incurances.Insurance;
import com.example.kursova.incurances.PersonInsurance;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Add {

    static Insurance newins ;

    public static void add(ArrayList<Insurance> insurances){
        Stage stage = new Stage();
        stage.setTitle("Adding new insurance");
        stage.initModality(Modality.APPLICATION_MODAL);

        Label l1 = new Label("                   Choose type of insurance");
        l1.setPadding(new Insets(10));

        Button b_p = new Button("Person");
        Button b_c = new Button("  Car  ");
        Button b_h = new Button("House");
        b_p.setPrefSize(79, 38);
        b_c.setPrefSize(79, 38);
        b_h.setPrefSize(79, 38);

        HBox hb2 = new HBox();
        hb2.setSpacing(35);
        hb2.getChildren().addAll(b_p, b_c, b_h);

        Button b_ok = new Button(" ok ");
        b_ok.setPrefSize(45, 30);
        VBox vb_ok = new VBox();
        vb_ok.setAlignment(Pos.CENTER);
        vb_ok.getChildren().add(b_ok);

        Button b_p1 = new Button(" ok ");
        Button b_c1 = new Button(" ok ");
        Button b_h1 = new Button(" ok ");

        TextField tf_p1 = new TextField();
        TextField tf_p2 = new TextField();
        TextField tf_c1 = new TextField();
        TextField tf_c2 = new TextField();
        TextField tf_h1 = new TextField();
        TextField tf_h2 = new TextField();

        ChoiceBox<String> choiceBox= new ChoiceBox<>();
        choiceBox.getItems().addAll("car", "bus", "motorcycle", "truck");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));
        layout.setTop(l1);
        layout.setCenter(hb2);
        layout.setBottom(vb_ok);


        b_p.setOnAction(e->{

            GridPane grid_p = new GridPane();
            grid_p.setPadding(new Insets(30,30, 30, 30));
            grid_p.setVgap(15);
            grid_p.setHgap(15);

            Label l_p1 = new Label("Enter your age");
            Label l_p2 = new Label("Enter health level(1-5)");

            GridPane.setConstraints(l_p1, 0, 0);
            GridPane.setConstraints(tf_p1, 1, 0);
            GridPane.setConstraints(l_p2, 0, 1);
            GridPane.setConstraints(tf_p2, 1, 1);
            GridPane.setConstraints(b_p1, 1, 3);

            grid_p.getChildren().addAll(l_p1, tf_p1, l_p2, tf_p2, b_p1);
            Scene sc_p = new Scene(grid_p,350, 200);
            stage.setScene(sc_p);

        });
        b_c.setOnAction(e->{

            GridPane grid_c = new GridPane();
            grid_c.setPadding(new Insets(30,30, 30, 30));
            grid_c.setVgap(15);
            grid_c.setHgap(15);

            Label l_c1 = new Label("enter price");
            Label l_c2 = new Label("enter motor volume");
            Label l_c3 = new Label("choose type");
            choiceBox.setValue("car");

            GridPane.setConstraints(l_c1, 0, 0);
            GridPane.setConstraints(tf_c1, 1, 0);
            GridPane.setConstraints(l_c2, 0, 1);
            GridPane.setConstraints(tf_c2, 1, 1);
            GridPane.setConstraints(l_c3,0,2);
            GridPane.setConstraints(choiceBox,1,2);
            GridPane.setConstraints(b_c1, 1, 3);

            grid_c.getChildren().addAll(l_c1, tf_c1, l_c2, tf_c2, l_c3, choiceBox, b_c1);
            Scene sc_с = new Scene(grid_c,350, 200);
            stage.setScene(sc_с);

        });
        b_h.setOnAction(e->{

            GridPane grid_c = new GridPane();
            grid_c.setPadding(new Insets(30,30, 30, 30));
            grid_c.setVgap(15);
            grid_c.setHgap(15);

            Label l_h1 = new Label("Enter area");
            Label l_h2 = new Label("Enter house price");

            GridPane.setConstraints(l_h1, 0, 0);
            GridPane.setConstraints(tf_h1, 1, 0);
            GridPane.setConstraints(l_h2, 0, 1);
            GridPane.setConstraints(tf_h2, 1, 1);

            GridPane.setConstraints(b_h1, 1, 3);

            grid_c.getChildren().addAll(l_h1, tf_h1, l_h2, tf_h2, b_h1);
            Scene sc_с = new Scene(grid_c,350, 200);
            stage.setScene(sc_с);
        });

        b_ok.setOnAction(e->{
            stage.close();
        });


        Scene sc_main = new Scene(layout, 350,200);

        b_p1.setOnAction(e->{
            int age, health;
            age = CheckAnswer(tf_p1.getText());
            health = CheckAnswer(tf_p2.getText());
            if(age != 0 && health != 0){
                newins = new PersonInsurance(age, health);
                insurances.add(newins);
                stage.setScene(sc_main);
                stage.show();
            }
        });

        b_c1.setOnAction(e->{
            String type_of_car;
            int motor_volume, price;
            price = CheckAnswer(tf_c1.getText());
            motor_volume = CheckAnswer(tf_c2.getText());
            type_of_car = choiceBox.getValue();
            if(motor_volume != 0 && price != 0) {
                newins = new CarInsurance(type_of_car, motor_volume, price);
                insurances.add(newins);
                stage.setScene(sc_main);
                stage.show();
            }
        });

        b_h1.setOnAction(e->{
            int area, price;
            area = CheckAnswer(tf_h1.getText());
            price = CheckAnswer(tf_h2.getText());
            if(area != 0 && price != 0) {
                newins = new HouseInsurance(area, price);
                insurances.add(newins);
                stage.setScene(sc_main);
                stage.show();
            }
        });
        stage.setScene(sc_main);
        stage.showAndWait();
    }

    private static int CheckAnswer(String text){
        Stage st = new Stage();
        Button b_ok_ex = new Button("ok");;
        b_ok_ex.setOnAction(e -> st.close());

        try{
            int numb = Integer.parseInt(text);
            return numb;
        }catch (NumberFormatException ex){

            VBox vb = new VBox();
            vb.setPadding(new Insets(10));
            vb.setAlignment(Pos.CENTER);
            vb.setSpacing(10);
            Label l_ex = new Label(text + " is not a number");
            vb.getChildren().addAll(l_ex, b_ok_ex);

            Scene sc_ex = new Scene(vb,200, 100);
            st.setScene(sc_ex);
            st.showAndWait();

            return 0;
        }

    }
}
