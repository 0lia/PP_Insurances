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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;

import java.util.ArrayList;

public class Derivative {

    public static void create_der(ArrayList<Insurance> insurances) {
        Stage stage = new Stage();
        stage.setTitle("Derivative");
        stage.initModality(Modality.APPLICATION_MODAL);
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);

        Label l = new Label("DERIVATIVE IS CREATED!");

        Button b_show = new Button("      Show the list     ");
        Button b_sort = new Button("Sort by descending risk");
        Button b_price = new Button("Calculate total price");
        Button b_find = new Button("Find by parameters ");
        b_sort.setPrefSize(150, 25);
        b_show.setPrefSize(150, 25);
        b_find.setPrefSize(150, 25);
        b_price.setPrefSize(150, 25);


        Button b_pr_ok = new Button(" ok ");
        Button b_sort_ok = new Button("ok");
        Stage st_pr = new Stage();
        Stage st_sort = new Stage();

        vBox.getChildren().addAll(l, b_show, b_find, b_price, b_sort);


        b_show.setOnAction(e->Show.show(insurances));

        b_sort.setOnAction(e -> {
            Sort(insurances);

            VBox vBox_sort = new VBox();
            vBox_sort.setSpacing(20);
            vBox_sort.setPadding(new Insets(18));
            vBox_sort.setAlignment(Pos.CENTER);

            Label l_sort = new Label("Insurances are sorted");

            vBox_sort.getChildren().addAll(l_sort, b_sort_ok);
            Scene sc_sort = new Scene(vBox_sort, 150, 100);
            st_sort.setScene(sc_sort);
            st_sort.showAndWait();
        });
        b_sort_ok.setOnAction(e2->st_sort.close());


        b_find.setOnAction(e ->{
            Stage stage_find = new Stage();
            stage_find.setTitle("Finding by parameters");
     //       stage_find.initModality(Modality.APPLICATION_MODAL);

            VBox vBox_find = new VBox();
            vBox_find.setSpacing(17);
            vBox_find.setPadding(new Insets(14));

            HBox hBox = new HBox();
            hBox.setSpacing(45);
            hBox.setAlignment(Pos.CENTER);

            Label l1 = new Label("                   Choose type of insurance");
            l1.setPadding(new Insets(10));

            TextField tf_min_1 = new TextField();
            TextField tf_max_1 = new TextField();
            TextField tf_min_2 = new TextField();
            TextField tf_max_2 = new TextField();
            HBox hBox_1 = new HBox();
            HBox hBox_2 = new HBox();
            hBox_1.getChildren().addAll(tf_min_1, tf_max_1);
            hBox_2.getChildren().addAll(tf_min_2, tf_max_2);

            Button b_p = new Button("Person");
            Button b_c = new Button("  Car  ");
            Button b_h = new Button("House");
            Button ok = new Button(" Find ");
            VBox vbok = new VBox();
            vbok.getChildren().add(ok);
            vbok.setAlignment(Pos.CENTER);

            hBox.getChildren().addAll(b_p, b_c, b_h);
            vBox_find.getChildren().addAll(l1, hBox);

            b_p.setOnAction(ev->{
                tf_min_1.setPromptText("min age");
                tf_max_1.setPromptText("max age");
                vBox_find.getChildren().addAll(hBox_1, vbok);
                ok.setOnAction(eok->{
                    Find_P(insurances, Integer.parseInt(tf_min_1.getText()), Integer.parseInt(tf_max_1.getText()));
                    stage_find.close();
                });
            });

            b_c.setOnAction(ev->{
                tf_min_1.setPromptText("min motor volume");
                tf_max_1.setPromptText("max motor volume");
                tf_min_2.setPromptText("min price");
                tf_max_2.setPromptText("max price");
                vBox_find.getChildren().addAll(hBox_1, hBox_2, vbok);
                ok.setOnAction(eok->{
                    Find_C(insurances, Integer.parseInt(tf_min_1.getText()), Integer.parseInt(tf_max_1.getText()),
                            Integer.parseInt(tf_min_2.getText()), Integer.parseInt(tf_max_2.getText()));
                    stage_find.close();
                });
            });

            b_h.setOnAction(ev->{
                tf_min_1.setPromptText("min area");
                tf_max_1.setPromptText("max area");
                tf_min_2.setPromptText("min price");
                tf_max_2.setPromptText("max price");
                vBox_find.getChildren().addAll(hBox_1, hBox_2, vbok);
                ok.setOnAction(eok->{
                    Find_H(insurances, Integer.parseInt(tf_min_1.getText()), Integer.parseInt(tf_max_1.getText()),
                            Integer.parseInt(tf_min_2.getText()), Integer.parseInt(tf_max_2.getText()));
                    stage_find.close();
                });
            });

            Scene sc_sort = new Scene(vBox_find, 350, 250);
            stage_find.setScene(sc_sort);
            stage_find.showAndWait();
        });

        b_price.setOnAction(e ->{
            int tot_pr = Calc_total_pr(insurances);

            VBox vBox_pr = new VBox();
            vBox_pr.setSpacing(20);
            vBox_pr.setPadding(new Insets(18));
            vBox_pr.setAlignment(Pos.CENTER);

            Label l_pr = new Label("The total price is " + tot_pr);

            vBox_pr.getChildren().addAll(l_pr, b_pr_ok);
            Scene sc_tot_pr = new Scene(vBox_pr, 175, 100);
            st_pr.setScene(sc_tot_pr);
            st_pr.showAndWait();
        });
        b_pr_ok.setOnAction(e -> st_pr.close());

        Scene sc = new Scene(vBox, 350, 200);
        stage.setScene(sc);
        stage.showAndWait();
    }

    private static int Calc_total_pr(ArrayList<Insurance> ins){
        int total_price = 0;
        for (Insurance insurance : ins) {
            total_price += insurance.getPrice();
        }
       return total_price;
    }

    private static void Sort(ArrayList<Insurance> ins){
        for (int i = 0; i < ins.size()-1; i++)
            for (int j = 0; j < ins.size()-i-1; j++) {
                if (ins.get(j).getRisk() < ins.get(j + 1).getRisk()) {
                    ins.add(j, ins.get(j+1));
                    ins.remove(j+2);
                }
            }
    }


    private static void Find_P(ArrayList<Insurance> ins, int min, int max) {
        ArrayList<Insurance> found = new ArrayList<>();
                for (Insurance insurance : ins)
                    if(insurance instanceof PersonInsurance &&
                            ((PersonInsurance) insurance).getAge() > min &&
                            ((PersonInsurance) insurance).getAge() < max)
                        found.add(insurance);
                Show.show(found);
    }

    private static void Find_C(ArrayList<Insurance> ins, int min_vol, int max_vol, int min_pr, int max_pr) {
        ArrayList<Insurance> found = new ArrayList<>();
                for (Insurance insurance : ins)
                    if(insurance instanceof CarInsurance &&
                            ((CarInsurance) insurance).getMotor_volume() > min_vol &&
                            ((CarInsurance) insurance).getMotor_volume() < max_vol &&
                            insurance.getPrice() > min_pr && insurance.getPrice() < max_pr)
        found.add(insurance);
        Show.show(found);
    }

    private static void Find_H(ArrayList<Insurance> ins, int min_area, int max_area, int min_pr, int max_pr) {
        ArrayList<Insurance> found = new ArrayList<>();
        for (Insurance insurance : ins)
                    if(insurance instanceof HouseInsurance &&
                            ((HouseInsurance) insurance).getArea() > min_area &&
                            ((HouseInsurance) insurance).getArea() < max_area &&
                            ((HouseInsurance) insurance).getHouse_price() > min_pr &&
                            ((HouseInsurance) insurance).getHouse_price() < max_pr)
        found.add(insurance);
        Show.show(found);

    }
}

