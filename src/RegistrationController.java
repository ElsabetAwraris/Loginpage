import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RegistrationController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private BorderPane gd;

    @FXML
    private TextField lastName;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerbtn;
    private AddressQueries ad = new AddressQueries();
    final ObservableList<Address> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        registerbtn.setOnAction(e -> {
            //
            if (firstName.getText() == "") {
                Alert alert = new Alert(AlertType.WARNING, "Field is Empty");
                alert.show();
            } else {
                int response = ad.addAddress(
                        firstName.getText(),
                        lastName.getText(),
                        email.getText(),
                        password.getText());

                if (response == 1) {
                    data.setAll(ad.getAllAddresses());
                }
                firstName.clear();
                lastName.clear();
                email.clear();
                password.clear();

                try {
                    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    gd.getChildren().setAll(pane);
                } catch (IOException e1) {

                    e1.printStackTrace();
                }

            }
        });
    }

}
