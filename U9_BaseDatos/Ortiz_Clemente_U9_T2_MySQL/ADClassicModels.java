import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ADClassicModels {

    public List<Employee> getEmpleados() {

        //Método estatico que se llama desde la prueba clase
        Connection connection = ConexionBD.getConnection();
        List<Employee> employeeList = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();

            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery("SELECT * FROM employees");

            Employee employee = null;

            while (rs.next()) {

                employee = new Employee();

                employee.setEmployeeNumber(rs.getInt("employeeNumber"));
                employee.setLastName(rs.getString("lastName"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setExtension(rs.getString("extension"));
                employee.setEmail(rs.getString("email"));
                employee.setOfficeCode(rs.getString("officeCode"));
                employee.setReportsTo(rs.getInt("reportsTo"));
                employee.setJobTitle(rs.getString("jobTitle"));

                employeeList.add(employee);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        return employeeList;
    }


    public List<Office> getOffices() {
        //Método estatico que se llama desde la prueba clase
        Connection connection = ConexionBD.getConnection();
        List<Office> officeList = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();

            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery("SELECT * FROM offices");

            Office office = null;

            while (rs.next()) {

                office = new Office();

                office.setOfficeCode(rs.getString("officeCode"));
                office.setCity(rs.getString("city"));
                office.setPhone(rs.getString("phone"));
                office.setAddressLine1(rs.getString("addressLine1"));
                office.setAddressLine2(rs.getString("addressLine2"));
                office.setState(rs.getString("state"));
                office.setCountry(rs.getString("country"));
                office.setPostalCode(rs.getString("postalCode"));
                office.setTerritory(rs.getString("territory"));

                officeList.add(office);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return officeList;
    }
}

