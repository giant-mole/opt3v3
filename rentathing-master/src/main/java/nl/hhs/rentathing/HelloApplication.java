package nl.hhs.rentathing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
        stage.setTitle("Rent-a-Thing");
        stage.setScene(scene);
        stage.show();

//        Vrachtauto a =new Vrachtauto(1.0,1.0,true,1,1.0,1.0);
//        Vrachtauto b =new Vrachtauto(1.0,1.0,true,1,1.1,1.1);
//        Vrachtauto c =new Vrachtauto(1.0,1.0,true,1,1.2,1.2);
//        Boormachine d =new Boormachine(1.0,1.0,true,1,"a","a");
//        Boormachine ee =new Boormachine(1.0,1.0,true,1,"b","b");
//        Boormachine f =new Boormachine(1.0,1.0,true,1,"c","c");
//        Personenauto g =new Personenauto(1.0,1.0,true,1,"c",1.0);
//        Personenauto h =new Personenauto(1.0,1.0,true,1,"c",1.1);
//        Personenauto i =new Personenauto(1.0,1.0,true,1,"c",1.2);
//        ArrayList<Product> Vrachtauto= new ArrayList<>();
//        ArrayList<Product> Boormachine= new ArrayList<>();
//        ArrayList<Product> Personenauto= new ArrayList<>();
//        Vrachtauto.add(a);
//        Vrachtauto.add(b);
//        Vrachtauto.add(c);
//        Boormachine.add(d);
//        Boormachine.add(ee);
//        Boormachine.add(f);
//        Personenauto.add(g);
//        Personenauto.add(h);
//        Personenauto.add(i);
//        try {
//            IDatabase.setDb(Vrachtauto,"vrachtautoDB");
//            IDatabase.setDb(Boormachine,"boormachineDB");
//            IDatabase.setDb(Personenauto,"PersonenautoDB");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    public static void main(String[] args) {
        launch();
    }
}