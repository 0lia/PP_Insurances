package com.example.kursova.commands;

import com.example.kursova.incurances.Insurance;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Delete {

    public static void delete(ArrayList<Insurance> insurances){
        Stage st = new Stage();
        st.setTitle("Delete");

        Label l1 = new Label("Choose insurances to delete");

        Button b_ok = new Button("Delete");
        Button b_canc = new Button("Cancel");
        b_ok.setPrefSize(120, 50);
        b_canc.setPrefSize(120, 50);

        HBox hb = new HBox();
        hb.setSpacing(40);
        hb.setPadding(new Insets(10));
        hb.getChildren().addAll(b_ok, b_canc);

        TableView<Insurance> table = Show.CreateTab(insurances);

        VBox root = new VBox(table, hb);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Scene scene = new Scene(root, 300, 300);
        st.setScene(scene);

        TableView.TableViewSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<Insurance> selectedItems = selectionModel.getSelectedItems();

        st.show();

        b_ok.setOnAction( e ->{
            for(Insurance insurance: selectedItems)
                insurances.remove(insurance);
            st.close();
        });

        b_canc.setOnAction( e ->{
            st.close();
        });
    }
}
