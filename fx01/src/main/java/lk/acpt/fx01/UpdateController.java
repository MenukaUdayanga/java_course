package lk.acpt.fx01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class UpdateController {

    @FXML
    private TextField textid;

    @FXML
    private TextField textname;

    @FXML
    private TextField textprice;

    @FXML
    private TextField textquy;

    @FXML
    private TextField textsin;

    @FXML
    void cancel(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    void search(ActionEvent event) {

        String id = textid.getText();

        try {

            //Load connector-driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");

            //create sql query

            PreparedStatement stm = connection.prepareStatement("select * from book where bid=?");
            stm.setObject(1,id);

            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next())
            {
                textname.setText(resultSet.getString(2));
                textsin.setText(resultSet.getString(3));
                textquy.setText(String.valueOf(resultSet.getInt(4)));
                textprice.setText(String.valueOf(resultSet.getDouble(5)));
            }


        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void update(ActionEvent event) {

        try {

            //Load connector-driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");

            //create sql query

            PreparedStatement stm = connection.prepareStatement("update book set name=?,sin=?,qty=?,price=? where bid=?");
            stm.setObject(1,textname.getText());
            stm.setObject(2,textsin.getText());
            stm.setObject(3, Integer.parseInt(textquy.getText()));
            stm.setObject(4, Double.parseDouble(textprice.getText()));
            stm.setObject(5,textid.getText());


            int executed =stm.executeUpdate();

            System.out.println(executed);

        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }





    }


}
