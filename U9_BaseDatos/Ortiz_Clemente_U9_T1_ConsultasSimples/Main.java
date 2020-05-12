import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            //Creo conexión a la base de datos de ejemplo
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NinnuSs\\Desktop\\sampledatabase.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); //Límite tiempo de respuesta

            System.out.println("Consulta que devuelve el listado de los \"customers\" que no tienen \"state\" (el campo \"state\" es nulo)");
            ResultSet rs = statement.executeQuery("SELECT * FROM customers WHERE state IS null");
            while(rs.next()) {
                System.out.println("Nombre = " + rs.getString("customerName"));
            }
            System.out.println();

            System.out.println("Consulta que devuelve el listado de los \"payments\" cuyo \"amount\" sea mayor de 30.000.sobre la cantidad");
            rs = statement.executeQuery("SELECT customerNumber, amount FROM payments WHERE amount > 30000");
            while(rs.next()){
                System.out.print("Cliente: " + rs.getInt("customerNumber"));
                System.out.println(" Cantidad: " + rs.getInt("amount"));
            }
            System.out.println();

            System.out.println("Consulta que devuelve el listado de los \"employees\" que dan cuenta (reportsTo) al empleado con Id = 1143");
            rs = statement.executeQuery("SELECT * FROM employees WHERE reportsTo = 1143 ");
            while(rs.next()){
                System.out.println("Nombre = " + rs.getString("lastName"));
                System.out.println("Apellido = " + rs.getString("firstName"));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } try {
            if(connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
