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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class VerhuurController implements Initializable {

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
    @FXML
    private TextField Field7;
    @FXML
    private Button bereken;
    @FXML
    private Text prijs;
    @FXML
    private Text voornaam;
    @FXML
    private Text achternaam;
    @FXML
    private TextField Field8;
    @FXML
    private TextField Field9;

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
    public void logoutButton(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    public void setUser(User u) {
        this.u = u;
        nameLabel.setText(this.u.email);

    }

    public void changeVrachtauto() {
        Label1.setText("Laadvermogen");
        Label2.setText("Gewicht");
        Field1.setText(((Vrachtauto) selected).laadvermogen.toString());
        Field2.setText(((Vrachtauto) selected).gewicht.toString());
        Field3.setText(String.valueOf(((Vrachtauto) selected).prijsPerDag));
        Field4.setText(String.valueOf(((Vrachtauto) selected).verzekeringskosten));
        Field5.setText(String.valueOf(((Vrachtauto) selected).verhuurd));
        Field6.setText(String.valueOf(((Vrachtauto) selected).aantalDagen));
        Field7.setText(String.valueOf(((Vrachtauto) selected).verzekering));

    }

    public void changeBoormachine() {
        Label1.setText("Merk");
        Label2.setText("Type");
        Field1.setText(((Boormachine) selected).merk);
        Field2.setText(((Boormachine) selected).type);
        Field3.setText(String.valueOf(((Boormachine) selected).prijsPerDag));
        Field4.setText(String.valueOf(((Boormachine) selected).verzekeringskosten));
        Field5.setText(String.valueOf(((Boormachine) selected).verhuurd));
        Field6.setText(String.valueOf(((Boormachine) selected).aantalDagen));
        Field7.setText(String.valueOf(((Boormachine) selected).verzekering));

    }

    public void changePersoonaut() {
        Label1.setText("Merk");
        Label2.setText("Gewicht");
        Field1.setText(((Personenauto) selected).getMerk());
        Field2.setText(((Personenauto) selected).getGewicht().toString());
        Field3.setText(String.valueOf(((Personenauto) selected).prijsPerDag));
        Field4.setText(String.valueOf(((Personenauto) selected).verzekeringskosten));
        Field5.setText(String.valueOf(((Personenauto) selected).verhuurd));
        Field6.setText(String.valueOf(((Personenauto) selected).aantalDagen));
        Field7.setText(String.valueOf(((Personenauto) selected).verzekering));
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
                    changeVrachtauto();

                } else if (selected.getClass() == Personenauto.class) {
                    changePersoonaut();

                } else {
                    changeBoormachine();

                }


            }
        });

    }

    public void updateVrachtwagen() throws IOException {
        Vrachtauto vrachtauto = (Vrachtauto) selected;

        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.verzekering = Boolean.parseBoolean(Field7.getText());
        vrachtauto.voornaam = Field8.getText();
        vrachtauto.achternaam = Field9.getText();
        ArrayList<Vrachtauto> vrachtautos = IDatabase.getDb(vrachtauto, "vrachtautoDB");
        vrachtautos.remove(Integer.parseInt(vrachtauto.id));
        vrachtautos.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(vrachtautos, "vrachtautoDB");
    }

    public void updateBoormachine() throws IOException {
        Boormachine vrachtauto = (Boormachine) selected;

        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.verzekering = Boolean.parseBoolean(Field7.getText());
        vrachtauto.voornaam = Field8.getText();
        vrachtauto.achternaam = Field9.getText();
        ArrayList<Boormachine> boormachines = IDatabase.getDb(vrachtauto, "boormachineDB");
        boormachines.remove(Integer.parseInt(vrachtauto.id));
        boormachines.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(boormachines, "boormachineDb");
    }

    public void updatePersoonauto() throws IOException {
        Personenauto vrachtauto = (Personenauto) selected;
        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.verzekering = Boolean.parseBoolean(Field7.getText());
        vrachtauto.voornaam = Field8.getText();
        vrachtauto.achternaam = Field9.getText();

        ArrayList<Personenauto> personenautos = IDatabase.getDb(vrachtauto, "PersonenautoDB");
        personenautos.remove(Integer.parseInt(vrachtauto.id));
        personenautos.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(personenautos, "PersonenautoDB");
    }

    @FXML
    public void Update(ActionEvent actionEvent) throws IOException {
        if (selected == null) {
            System.out.println("nee");
        } else if (selected.getClass() == Vrachtauto.class) {
            updateVrachtwagen();

        } else if (selected.getClass() == Personenauto.class) {
            updatePersoonauto();
        } else {
            updateBoormachine();

        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Verhuur.fxml"));
        Parent root = fxmlLoader.load();
        VerhuurController verhuurController = fxmlLoader.getController();
        verhuurController.setUser(u);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void reloadPersoonaut() throws IOException {
        Personenauto vrachtauto = (Personenauto) selected;
        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.verzekering = Boolean.parseBoolean(Field7.getText());

        ArrayList<Personenauto> personenautos = IDatabase.getDb(vrachtauto, "PersonenautoDB");
        personenautos.remove(Integer.parseInt(vrachtauto.id));
        personenautos.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(personenautos, "PersonenautoDB");
    }

    public void reloadVrachtauto() throws IOException {
        Vrachtauto vrachtauto = (Vrachtauto) selected;

        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.verzekering = Boolean.parseBoolean(Field7.getText());
        ArrayList<Vrachtauto> vrachtautos = IDatabase.getDb(vrachtauto, "vrachtautoDB");
        vrachtautos.remove(Integer.parseInt(vrachtauto.id));
        vrachtautos.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(vrachtautos, "vrachtautoDB");
    }

    public void reloadBoormachine() throws IOException {
        Boormachine vrachtauto = (Boormachine) selected;

        vrachtauto.verhuurd = Boolean.parseBoolean(Field5.getText());
        vrachtauto.verzekering=Boolean.parseBoolean(Field7.getText());
        ArrayList<Boormachine> boormachines = IDatabase.getDb(vrachtauto, "boormachineDB");
        boormachines.remove(Integer.parseInt(vrachtauto.id));
        boormachines.add(Integer.parseInt(vrachtauto.id), vrachtauto);
        IDatabase.setDb(boormachines, "boormachineDb");
    }

    @FXML
    public void reload(ActionEvent actionEvent) throws IOException {
        if (selected == null) {
            System.out.println("nee");
        } else if (selected.getClass() == Vrachtauto.class) {
            reloadVrachtauto();

        } else if (selected.getClass() == Personenauto.class) {
            reloadPersoonaut();
        } else {
            reloadPersoonaut();

        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Verhuur.fxml"));
        Parent root = fxmlLoader.load();
        VerhuurController verhuurController = fxmlLoader.getController();
        verhuurController.setUser(u);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void bereken(ActionEvent actionEvent) {
        voornaam.setText("Voornaam");
        achternaam.setText("Achternaam");
        Field8.setOpacity(1);
        Field9.setOpacity(1);
        if (selected == null) {
            System.out.println("nee");
        } else if (selected.getClass() == Boormachine.class) {
            Boormachine boormachine = (Boormachine) selected;
            prijs.setText(String.valueOf(boormachine.berekenprijs(Double.parseDouble(Field3.getText()), Double.parseDouble(Field4.getText()), Integer.parseInt(Field6.getText()))));
        } else if (selected.getClass() == Vrachtauto.class) {
            Vrachtauto vrachtauto = (Vrachtauto) selected;
            prijs.setText(String.valueOf((Double) vrachtauto.berekenprijs(Double.parseDouble(Field3.getText()), Double.parseDouble(Field4.getText()), Integer.parseInt(Field6.getText()))));
        } else {
            Personenauto personenauto = (Personenauto) selected;
            prijs.setText(String.valueOf((Double) personenauto.berekenprijs(Double.parseDouble(Field3.getText()), Double.parseDouble(Field4.getText()), Integer.parseInt(Field6.getText()))));
        }


    }
}
