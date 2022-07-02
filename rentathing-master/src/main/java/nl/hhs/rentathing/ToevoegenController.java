package nl.hhs.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ToevoegenController implements Initializable {


    @FXML
    private TextField Laadvermogen;
    @FXML
    private TextField Gewicht;
    @FXML
    private Label LaadvermogenVrachtauto;
    @FXML
    private Label GewichtVrachtauto;
    @FXML
    private TextField Merkauto;
    @FXML
    private TextField Gewichtauto;
    @FXML
    private Label MerkAuto;
    @FXML
    private Label GewichtautoLBL;
    @FXML
    private TextField TypeBoormachine;
    @FXML
    private TextField MerkBoormachine;
    @FXML
    private Label TypeBoor;
    @FXML
    private Label MerkBoor;
    User u;

    @javafx.fxml.FXML
    private Label nameLabel;
    @FXML
    private Label label21;
    @FXML
    private Label label1;
    @FXML
    private Label label2;


    @javafx.fxml.FXML
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
    public void verhuur(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Verhuur.fxml"));
        Parent root = fxmlLoader.load();
        VerhuurController verhuurController = fxmlLoader.getController();
        verhuurController.setUser(u);
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
    public void logoutButton(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void setUser(User u) {
        this.u = u;
        nameLabel.setText(this.u.email);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void toevoegenVrachtauto(ActionEvent actionEvent) throws IOException {
        if (!Laadvermogen.getText().isEmpty() && !Gewicht.getText().isEmpty()) {
            Double laadvermogen = Double.valueOf(Laadvermogen.getText());
            Double gewicht = Double.valueOf(Gewicht.getText());
            label1.setText("Toegevoegd!");
            Vrachtauto vrachtauto = new Vrachtauto(0.10, "", "", 1, false,1 ,false,laadvermogen, gewicht);
            ArrayList<Product> Vrachtauto = new ArrayList<>();
            Vrachtauto.add(vrachtauto);
            try {
                for (Product p :
                        Vrachtauto) {
                    IDatabase.addToDb(p, "vrachtautoDB");

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            label1.setText("Vul iets in");
        }
    }

    public void toevoegenPersonenauto(ActionEvent actionEvent) {
        if (!MerkAuto.getText().isEmpty() && !Gewichtauto.getText().isEmpty()) {
            String Merk = Merkauto.getText();
            Double gewicht = Double.valueOf(Gewichtauto.getText());
            label2.setText("Toegevoegd!");
            Personenauto personenauto = new Personenauto(50.0,"","", 0.01, false, 1, false, Merk, gewicht);
            ArrayList<Product> Personenauto = new ArrayList<>();
            Personenauto.add(personenauto);
            try {
                for (Product p :
                        Personenauto) {
                    IDatabase.addToDb(p, "PersonenautoDB");

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            label2.setText("Vul iets in");
        }
    }

    public void toevoegenBoormachine(ActionEvent actionEvent) {
        if (!TypeBoormachine.getText().isEmpty() && !MerkBoormachine.getText().isEmpty()) {
            String Type = TypeBoormachine.getText();
            String Merk = MerkBoormachine.getText();
            label21.setText("Toegevoegd!");
            Boormachine boormachine = new Boormachine(5.0,"","", 1.0, false, 1, false, Merk, Type);
            ArrayList<Product> Boormachine = new ArrayList<>();
            Boormachine.add(boormachine);
            try {
                for (Product p :
                        Boormachine) {
                    IDatabase.addToDb(p, "BoormachineDB");

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            label21.setText("Vul iet in");
        }
    }


}
