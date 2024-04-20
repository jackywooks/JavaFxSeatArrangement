module org.example.assignment_three {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.naming;


    opens org.example.assignment_three to javafx.fxml;
    exports org.example.assignment_three;
}