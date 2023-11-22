package lk.acpt.fx01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteController {


    @FXML
    private TextField textid;

    @FXML
    void cancel(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    void delete(ActionEvent event) {

        String id = textid.getText();


        try {
            //Load connector-driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");

            //Create sql query

            PreparedStatement stm = connection.prepareStatement("delete from book where bid=?");
            stm.setObject(1,id);

            int result = stm.executeUpdate();

            System.out.println(result + " row(s) deleted.");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
