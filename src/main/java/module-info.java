module com.example.typingexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.typingexercise to javafx.fxml;
    exports com.example.typingexercise;
}