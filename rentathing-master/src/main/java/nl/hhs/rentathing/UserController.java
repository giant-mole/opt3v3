package nl.hhs.rentathing;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class    UserController {
    User u;
    @javafx.fxml.FXML
    private Label nameLabel;

    public void setUser(User u){
        this.u = u;
        nameLabel.setText(this.u.email);

    }

    @javafx.fxml.FXML
    public void beheerButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("beheer.fxml"));
        Parent root = fxmlLoader.load();
        BeheerController beheerController = fxmlLoader.getController();
        beheerController.setUser(u);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
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

    @javafx.fxml.FXML
    public void overzichtButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("overzicht-view.fxml"));
        Parent root = fxmlLoader.load();
        OverzichtController overzichtController = fxmlLoader.getController();
        overzichtController.setUser(u);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @javafx.fxml.FXML
    public void voegToe(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Toevoegen.fxml"));
        Parent root = fxmlLoader.load();
        ToevoegenController toevoegenController = fxmlLoader.getController();
        toevoegenController.setUser(u);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
