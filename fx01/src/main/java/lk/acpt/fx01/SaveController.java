package lk.acpt.fx01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveController {

    @FXML
    private TextField textid;

    @FXML
    private TextField textname;

    @FXML
    private TextField textprice;

    @FXML
    private TextField textqty;

    @FXML
    private TextField textsin;

    @FXML
    void cancel(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    void save(ActionEvent event) throws ClassNotFoundException {

        String id = textid.getText();
        String name= textname.getText();
        String sin = textsin.getText();
        int qty = Integer.parseInt(textqty.getText());
        double price = Double.parseDouble(textprice.getText());

      try {

          //Load connector-driver
          Class.forName("com.mysql.cj.jdbc.Driver");

          //create connection with database
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");

          //create sql query

          PreparedStatement stm = connection.prepareStatement("insert into book values(?,?,?,?,?)");
          stm.setObject(1,id);
          stm.setObject(2,name);
          stm.setObject(3,sin);
          stm.setObject(4,qty);
          stm.setObject(5,price);

          int result = stm.executeUpdate();

          if (result >=1) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Successfully save");
              alert.show();
               clear();

          }

          else

          {
              System.out.println("Not save");

          }


      }
      catch (ClassNotFoundException | SQLException e) {
          throw new RuntimeException(e);
      }


    }

 public void clear()

 {

     textid.clear();
     textname.clear();
     textsin.clear();
     textqty.clear();
     textprice.clear();

 }



}
