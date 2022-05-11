import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class AddressBookController implements Initializable {

    @FXML
    private Button addEntryButtonPress;

    @FXML
    private TableColumn<Address, String> emailCol;

    @FXML
    private TextField emailTextField;

    @FXML
    private TableColumn<Address, String> firstCol;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Label firstnameTextField;

    @FXML
    private TableColumn<Address, String> lastCol;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private HBox listview;

    @FXML
    private TableColumn<Address, String> phoneCol;

    @FXML
    private PasswordField phoneTextField;

    @FXML
    private TableView<Address> table;
    private AddressQueries ad = new AddressQueries();
    final ObservableList<Address> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        data.setAll(ad.getAllAddresses());

        firstCol.setCellValueFactory(new PropertyValueFactory<Address, String>("firstName"));
        lastCol.setCellValueFactory(new PropertyValueFactory<Address, String>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Address, String>("email"));

        table.setItems(data);

        addEntryButtonPress.setOnAction(e -> {
            //
            if (firstNameTextField.getText() == "") {
                Alert alert = new Alert(AlertType.WARNING, "Field is Empty");
                alert.show();
            } else {
                int response = ad.addAddress(
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        emailTextField.getText(),
                        phoneTextField.getText());

                if (response == 1) {
                    data.setAll(ad.getAllAddresses());
                }
                firstNameTextField.clear();
                lastNameTextField.clear();
                emailTextField.clear();
                phoneTextField.clear();
            }
        });
    }

}
