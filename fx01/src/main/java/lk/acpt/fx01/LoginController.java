package lk.acpt.fx01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField textEmail;

    @FXML
    private PasswordField textPassword;

    @FXML
    void login(ActionEvent event) {

        String email = textEmail.getText();
        String password = textPassword.getText();

        if (email.equals("Menuka") && password.equals("1234") ){

            System.out.println("Login is successfully..!");
        }

        else {

            System.out.println("Try again..!");
        }

    }

}
