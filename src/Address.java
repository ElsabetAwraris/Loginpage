import javafx.beans.property.SimpleStringProperty;

public class Address {
    final SimpleStringProperty firstName;
    final SimpleStringProperty lastName;
    final SimpleStringProperty email;
    final SimpleStringProperty password;

    public Address(String fName, String lName, String email, String password) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lName) {
        lastName.set(lName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String uEmail) {
        email.set(uEmail);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String pass) {
        password.set(pass);
    }

}
