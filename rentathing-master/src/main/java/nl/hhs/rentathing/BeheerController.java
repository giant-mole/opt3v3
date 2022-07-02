package nl.hhs.rentathing;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

public class BeheerController implements Initializable {


    User u;
    @FXML
    private ListView<Product> listView;

    Product selected = null;
    @javafx.fxml.FXML
    private Label nameLabel;
    @FXML
    private Text Label1;
    @FXML
    private TextField Field4;
    @FXML
    private TextField Field5;
    @FXML
    private TextField Field2;
    @FXML
    private TextField Field3;
    @FXML
    private TextField Field6;
    @FXML
    private Text Label2;
    @FXML
    private Button Update;
    @FXML
    private TextField Field1;


    @javafx.fxml.FXML
    public void voegToe(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Toevoegen.fxml"));
        Parent root = fxmlLoader.load();
        ToevoegenController toevoegenController = fxmlLoader.getController();
        toevoegenController.setUser(u);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Deprecated
    public void overzichtButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("overzicht-view.fxml"));
        Parent root = fxmlLoader.load();
        OverzichtController overzichtController = fxmlLoader.getController();
        overzichtController.setUser(u);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void beheerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("beheer.fxml"));
        Parent root = fxmlLoader.load();
        BeheerController beheerController = fxmlLoader.getController();
        beheerController.setUser(u);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void homeButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("user-view.fxml"));
        Parent root = fxmlLoader.load();
        UserController userController = fxmlLoader.getController();
        userController.setUser(u);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    public void setUser(User u) {
        this.u = u;
        nameLabel.setText(this.u.email);

    }

    public void changedVrachtauto() {
        Label1.setText("Laadvermogen");
        Label2.setText("Gewicht");
        Field1.setText(((Vrachtauto) selected).getLaadvermogen().toString());
        Field2.setText(((Vrachtauto) selected).getGewicht().toString());
        Field3.setText(String.valueOf(((Vrachtauto) selected).prijsPerDag));
        Field4.setText(String.valueOf(((Vrachtauto) selected).verzekeringskosten));
        Field5.setText(String.valueOf(((Vrachtauto) selected).verhuurd));
        Field6.setText(String.valueOf(((Vrachtauto) selected).aantalDagen));
    }

    public void changeBoormachine() {
        Label1.setText("Merk");
        Label2.setText("Type");
        Field1.setText(((Boormachine) selected).getMerk().toString());
        Field2.setText(((Boormachine) selected).getType().toString());
        Field3.setText(String.valueOf(((Boormachine) selected).prijsPerDag));
        Field4.setText(String.valueOf(((Boormachine) selected).verzekeringskosten));
        Field5.setText(String.valueOf(((Boormachine) selected).verhuurd));
        Field6.setText(String.valueOf(((Boormachine) selected).aantalDagen));
    }

    public void changePersoonauto() {
        Label1.setText("Merk");
        Label2.setText("Gewicht");
        Field1.setText(((Personenauto) selected).getMerk().toString());
        Field2.setText(((Personenauto) selected).getGewicht().toString());
        Field3.setText(String.valueOf(((Personenauto) selected).prijsPerDag));
        Field4.setText(String.valueOf(((Personenauto) selected).verzekeringskosten));
        Field5.setText(String.valueOf(((Personenauto) selected).verhuurd));
        Field6.setText(String.valueOf(((Personenauto) selected).aantalDagen));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Personenauto> personenautos = null;
        ArrayList<Vrachtauto> vrachtautos = null;
        ArrayList<Boormachine> boormachines = null;

        try {
            personenautos = IDatabase.getDb(new Personenauto(), "PersonenautoDB");
            vrachtautos = IDatabase.getDb(new Vrachtauto(), "vrachtautoDB");
            boormachines = IDatabase.getDb(new Boormachine(), "boormachineDB");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listView.getItems().addAll(vrachtautos);
        listView.getItems().addAll(personenautos);
        listView.getItems().addAll(boormachines);


        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observableValue, Product product, Product t1) {
                selected = listView.getSelectionModel().getSelectedItem();
                if (selected.getClass() == Vrachtauto.class) {
                    changedVrachtauto();
                } else if (selected.getClass() == Personenauto.class) {
                    changePersoonauto();
                } else {
                    changeBoormachine();
                }


            }
        });

    }

    public void updateVrachtauto() throws IOException {
        Vrachtauto vrachtauto = (Vrachtauto) selected;

        vrachtauto.setLaadvermogen(Double.valueOf(Field1.getText()));
        vrachtauto.setGewicht(Double.valueOf(Field2.getText()));
        vrachtauto.prijsPerDag = Double.parseDouble(Field3.getText());
        vrachtauto.verzekeringskosten = Double.parseDouble(Field4.getText());
        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.aantalDagen = Integer.parseInt(Field6.getText());
        ArrayList<Vrachtauto> vrachtautos = IDatabase.getDb(vrachtauto, "vrachtautoDB");
        vrachtautos.remove(Integer.parseInt(vrachtauto.id));
        vrachtautos.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(vrachtautos, "vrachtautoDB");
    }

    public void updatePersoonauto() throws IOException {
        Personenauto vrachtauto = (Personenauto) selected;

        vrachtauto.setMerk(Field1.getText());
        vrachtauto.setGewicht(Double.valueOf(Field2.getText()));
        vrachtauto.prijsPerDag = Double.parseDouble(Field3.getText());
        vrachtauto.verzekeringskosten = Double.parseDouble(Field4.getText());
        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.aantalDagen = Integer.parseInt(Field6.getText());
        ArrayList<Personenauto> personenautos = IDatabase.getDb(vrachtauto, "PersonenautoDB");
        personenautos.remove(Integer.parseInt(vrachtauto.id));
        personenautos.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(personenautos, "PersonenautoDB");
    }

    public void updateBoormachine() throws IOException {
        Boormachine vrachtauto = (Boormachine) selected;

        vrachtauto.setMerk(Field1.getText());
        vrachtauto.setType(Field2.getText());
        vrachtauto.prijsPerDag = Double.parseDouble(Field3.getText());
        vrachtauto.verzekeringskosten = Double.parseDouble(Field4.getText());
        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.aantalDagen = Integer.parseInt(Field6.getText());
        ArrayList<Boormachine> boormachines = IDatabase.getDb(vrachtauto, "boormachineDB");
        boormachines.remove(Integer.parseInt(vrachtauto.id));
        boormachines.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(boormachines, "boormachineDb");
    }

    @FXML
    public void Update(ActionEvent actionEvent) throws IOException {
        if (selected == null) {
            System.out.println("haha kanker sukker vul iets in dan");
        } else if (selected.getClass() == Vrachtauto.class) {
            updateVrachtauto();

        } else if (selected.getClass() == Personenauto.class) {
            updatePersoonauto();
        } else {
            updateBoormachine();

        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("beheer.fxml"));
        Parent root = fxmlLoader.load();
        BeheerController beheerController = fxmlLoader.getController();
        beheerController.setUser(u);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

