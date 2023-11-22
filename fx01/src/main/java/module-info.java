module lk.acpt.fx01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens lk.acpt.fx01 to javafx.fxml;
    exports lk.acpt.fx01;
}