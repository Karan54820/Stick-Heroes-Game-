module com.example.approject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.approject to javafx.fxml;
    exports com.example.approject;
}