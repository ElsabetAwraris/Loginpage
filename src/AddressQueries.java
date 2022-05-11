
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressQueries {
    // JDBC driver name and database URL

    private static final String url = "jdbc:mysql://localhost:3306/JDBC";
    private static final String user = "root";
    private static final String password = "12345";

    private Connection connection;
    private PreparedStatement selectAll;
    private PreparedStatement insertNewAddress;

    AddressQueries() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            selectAll = connection
                    .prepareStatement(
                            "SELECT firstName, lastName, email,password FROM login ORDER BY firstName, lastName");
            insertNewAddress = connection.prepareStatement("INSERT INTO login " +
                    "(firstName, lastName, email,password) " +
                    "VALUES(?, ?, ?,?)");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public List<Address> getAllAddresses() {
        try (ResultSet resultStore = selectAll.executeQuery()) {
            List<Address> results = new ArrayList<>();

            while (resultStore.next()) {
                results.add(new Address(
                        resultStore.getString(1),
                        resultStore.getString(2),
                        resultStore.getString(3),
                        resultStore.getString(4)));
            }
            return results;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addAddress(String fName, String lName, String email, String pass) {
        try {
            insertNewAddress.setString(1, fName);
            insertNewAddress.setString(2, lName);
            insertNewAddress.setString(3, email);
            insertNewAddress.setString(4, pass);

            return insertNewAddress.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }

    public int authenticate(String email, String password) {
        try (ResultSet resultSet = selectAll.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(email) && resultSet.getString(4).equals(password)) {
                    returned = 1;
                    break;
                } else {
                    returned = 0;
                }

            }
            return returned;
        } catch (Exception e) {
            return 0;
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
