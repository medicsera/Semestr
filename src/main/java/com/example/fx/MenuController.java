package com.example.fx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    String cssfree = this.getClass().getResource("StyleButtonTableFree.css").toExternalForm();

    String cssbusy = this.getClass().getResource("StyleButtonTableBusy.css").toExternalForm();

    @FXML
    private TextField takedTable;

    private Stage stage;
    private Scene scene;

    public void SwitchToMap(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(cssfree);
        scene.getStylesheets().add(cssbusy);
        stage.setScene(scene);
        stage.show();
    }

    public void setTakedTable(int tableNum) {
        takedTable.replaceSelection(String.valueOf(tableNum));
    }
    @FXML
    private TextField voidname;
    @FXML
    private TextField voiddate;
    @FXML
    private TextField voidtime;
    @FXML
    private TextField voidphone;
//////////////////////
private final ObservableList<Reservation> data = FXCollections.observableArrayList();
public void voidbutton() {
    String name = voidname.getText();
    String date = voiddate.getText();
    String time = voidtime.getText();
    String phone = voidphone.getText();

    if (!name.isEmpty() && !date.isEmpty() && !time.isEmpty() &&!phone.isEmpty()) {
        data.add(new Reservation(name, date, time, phone));
        voidname.clear();
        voiddate.clear();
        voidtime.clear();
        voidphone.clear();
        takedTable.clear();
    }

}

public class TableController {
    @FXML
    private TableView<Reservation> tableView;
    @FXML
    private TableColumn<Reservation, String> nameColumn;
    @FXML
    private TableColumn<Reservation, String> dateColumn;
    @FXML
    private TableColumn<Reservation, String> timeColumn;
    @FXML
    private TableColumn<Reservation, String> phoneColumn;




    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

        tableView.setItems(data);
    }
}
}
