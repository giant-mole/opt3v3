module nl.hhs.rentathing {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens nl.hhs.rentathing to javafx.fxml;
    exports nl.hhs.rentathing;
}