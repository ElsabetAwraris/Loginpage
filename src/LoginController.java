import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton loginbtn;

    @FXML
    private PasswordField password;

    @FXML
    private JFXButton signupbtn;

    @FXML
    private TextField username;
    int confirm;
    private AddressQueries ad = new AddressQueries();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginbtn.setOnAction(e -> {
            confirm = ad.authenticate(username
                    .getText(), password.getText());
            if (confirm == 1) {

                try {

                    BorderPane root = FXMLLoader.load(getClass().getResource("AddressBook.fxml"));
                    Stage stage = (Stage) username.getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e1) {

                    e1.printStackTrace();
                }
            } else {
                username.setStyle("-fx-border-color:RED");
                password.setStyle("-fx-border-color:RED");

            }

        });
        signupbtn.setOnAction(e -> {
            try {
                BorderPane gd = FXMLLoader.load(getClass().getResource("Registration.fxml"));
                anchor.getChildren().setAll(gd);
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        });

    }

}
