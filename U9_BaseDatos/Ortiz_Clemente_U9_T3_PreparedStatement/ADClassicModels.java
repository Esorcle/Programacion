import java.lang.reflect.Type;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

public class ADClassicModels {

    DecimalFormat decimalFormat = new DecimalFormat("####.##");

    /**
     * Método para insertar un cliente
     *
     * @param customer
     * @return
     */
    public boolean insertCustomer(Customer customer) throws ClassicModelsException {
        boolean inserted = false;
        //int customerNumber;

        Connection connection = ConexionBD.getConnection();

        try {
            //Compruebo si el cliente que quiero introducir existe ya en la BD
            String sqlExistCustomerNumber = "SELECT customerNumber FROM customers WHERE customerNumber = ?";
            PreparedStatement statementExistCustomerNumber = connection.prepareStatement(sqlExistCustomerNumber);
            statementExistCustomerNumber.setInt(1, customer.getCustomerNumber());
            ResultSet rsExistCustomerNumber = statementExistCustomerNumber.executeQuery();

            //Si exite lanzo un error
            if (rsExistCustomerNumber.next()) {
                throw new ClassicModelsException("Lo siento, pero ese número de cliente ya existe. Ingrese un nuevo número de usuario");
                //Si no exixte, continuo
            } else {

                /*Obtengo el número del último cliente
                String sqlCustomerNumber = "SELECT customerNumber FROM customers ORDER BY customerNumber DESC LIMIT 1";
                PreparedStatement statementCustomerNumber = connection.prepareStatement(sqlCustomerNumber);

                ResultSet rsCustomerNumber = statementCustomerNumber.executeQuery();
                if (rsCustomerNumber.next()) {
                    customerNumber = rsCustomerNumber.getInt("CustomerNumber");*/

                //Creo la sentencia SQL
                String sqlInsertCustomer = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName," +
                        "phone, addressLine1, addressLine2, city, state, postalCode, country, creditLimit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = connection.prepareStatement(sqlInsertCustomer);

                statement.setInt(1, customer.getCustomerNumber());
                statement.setString(2, customer.getCustomerName());
                statement.setString(3, customer.getContactLastName());
                statement.setString(4, customer.getContactFirstName());
                statement.setString(5, customer.getPhone());
                statement.setString(6, customer.getAddressLine1());

                if ("".equals(customer.getAddressLine2())) {
                    statement.setString(7, null);
                } else {
                    statement.setString(7, customer.getAddressLine2());
                }
                statement.setString(8, customer.getCity());

                if ("".equals(customer.getState())) {
                    statement.setString(9, null);
                } else {
                    statement.setString(9, customer.getState());
                }
                if ("".equals(customer.getPostalCode())) {
                    statement.setString(10, null);
                } else {
                    statement.setString(10, customer.getPostalCode());
                }
                statement.setString(11, customer.getCountry());
/*
                    if (customer.getSalesRepEmployeeNumber() == null) {
                        statement.setNull(12, Types.INTEGER);
                    } else {
                        statement.setInt(12, customer.getSalesRepEmployeeNumber());
                    }
                    */

                if ("".equals(customer.getCreditLimit())) {
                    statement.setNull(12, Types.FLOAT);
                } else {
                    statement.setFloat(12, customer.getCreditLimit());
                }

                int rs = statement.executeUpdate();
                if (rs != 0) {
                    inserted = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return inserted;
    }

    /**
     * Método para asignar un vendedor a un cliente
     *
     * @param salesID
     * @param customerID
     * @return
     * @throws ClassicModelsException
     */
    public boolean assingnSales(int salesID, int customerID) throws ClassicModelsException {

        Connection connection = ConexionBD.getConnection();
        boolean update = false;

        try {
            String sqlSales = "SELECT * FROM employees WHERE employeeNumber = ?";
            PreparedStatement statementSales = connection.prepareStatement(sqlSales);
            statementSales.setInt(1, salesID);

            ResultSet rsSales = statementSales.executeQuery();

            if (rsSales.next()) {
                String sqlCustomer = "SELECT * FROM customers WHERE customerNumber = ?";
                PreparedStatement statementCustomer = connection.prepareStatement(sqlCustomer);
                statementCustomer.setInt(1, customerID);

                ResultSet rsCustomer = statementCustomer.executeQuery();

                if (rsCustomer.next()) {
                    String sqlAssignSales = "UPDATE customers SET salesRepEmployeeNumber = ? WHERE customerNumber = ?";
                    PreparedStatement statementAssignSales = connection.prepareStatement(sqlAssignSales);
                    statementAssignSales.setInt(1, salesID);
                    statementAssignSales.setInt(2, customerID);

                    int returnAssignSales = statementAssignSales.executeUpdate();
                    if (returnAssignSales != 0) {
                        update = true;
                    }
                } else {
                    throw new ClassicModelsException("Error. No se ha encontrado el cliente");
                }
            } else {
                throw new ClassicModelsException("Error. No se ha encontrado el empledado");
            }
        } catch (SQLException e) { //Atrapo la excepción de fallos en SQL que nada le importa al user
            System.out.println(e.getMessage());
        }
        return update;
    }

    /**
     * Método para insertar un producto en un pedido
     *
     * @param productCode
     * @param orderNumber
     * @param quantityOrdered
     * @return
     * @throws ClassicModelsException
     */
    public boolean insertProductoOrder(String productCode, int orderNumber, int quantityOrdered) throws
            ClassicModelsException {

        //Variables
        Connection connection = ConexionBD.getConnection();
        boolean inserted = false;
        int update;

        try {
            //Compruebo si hay un pedido con ese número
            String sqlOrder = "SELECT * FROM orders WHERE orderNumber = ?";
            PreparedStatement statementOrder = connection.prepareStatement(sqlOrder);
            statementOrder.setInt(1, orderNumber);

            ResultSet rsOrder = statementOrder.executeQuery();

            if (rsOrder.next()) {

                //Compruebo si hay un producto ya en este pedido
                String sqlProdutInOrder = "SELECT productCode, quantityOrdered FROM orderdetails WHERE productCode = ? AND orderNumber = ?";
                PreparedStatement stProductInOrder = connection.prepareStatement(sqlProdutInOrder);
                stProductInOrder.setString(1, productCode);
                stProductInOrder.setInt(2, orderNumber);

                ResultSet rsProductInOrder = stProductInOrder.executeQuery();

                //Si hay, tomo el valor de la cantidad ya ordenada y lo sumo a la dada ahora
                if (rsProductInOrder.next()) {
                    quantityOrdered += rsProductInOrder.getInt("quantityOrdered");

                    //Actualizo la cantidad ordenada
                    String sqlUpdateProductInOrder = "UPDATE orderdetails SET quantityOrdered = ? WHERE orderNumber = ? AND productCode = ?";
                    PreparedStatement stUpdateProductInOrder = connection.prepareStatement(sqlUpdateProductInOrder);
                    stUpdateProductInOrder.setInt(1, quantityOrdered);
                    stUpdateProductInOrder.setInt(2, orderNumber);
                    stUpdateProductInOrder.setString(3, productCode);

                    update = stUpdateProductInOrder.executeUpdate();
                    if (update != 0) {
                        inserted = true;
                    }

                    //Si no existe ese producto en el pedido
                } else {

                    //Saco el precio de compra del producto y de paso compruebo si existe como tal en la BD
                    String sqlProduct = "SELECT buyPrice FROM products WHERE productCode = ?";
                    PreparedStatement statementProduct = connection.prepareStatement(sqlProduct);
                    statementProduct.setString(1, productCode);

                    ResultSet rsProduct = statementProduct.executeQuery();

                    //Si existe el producto
                    if (rsProduct.next()) {

                        //Guardo su precio de compra
                        double buyPrice = rsProduct.getDouble("buyPrice");

                        //Genero la sql para obtener el número de orden donde iría el producto que vamos a añadir
                        String sqlOrderLineNumber = "SELECT orderLineNumber FROM orderdetails WHERE orderNumber= ? ORDER BY orderLineNumber DESC LIMIT 1";
                        PreparedStatement statementOrderLineNumber = connection.prepareStatement(sqlOrderLineNumber);
                        statementOrderLineNumber.setInt(1, orderNumber);

                        ResultSet rsorderLineNumber = statementOrderLineNumber.executeQuery();

                        int orderLineNumber = 0;
                        if (rsorderLineNumber.next()) {
                            orderLineNumber = rsorderLineNumber.getInt("orderLineNumber");
                        }
                        //Genero sql para introducir producto
                        String sqlInsertProductOrder = "INSERT INTO orderdetails VALUES (?,?,?,?,?)";
                        PreparedStatement statementInsertProductoOrder = connection.prepareStatement(sqlInsertProductOrder);
                        statementInsertProductoOrder.setInt(1, orderNumber);
                        statementInsertProductoOrder.setString(2, productCode);
                        statementInsertProductoOrder.setInt(3, quantityOrdered);
                        statementInsertProductoOrder.setDouble(4, buyPrice*quantityOrdered);
                        statementInsertProductoOrder.setInt(5, ++orderLineNumber);

                        //Compruebo si el proceso se ha realizado con exito y devuelvo en consecuencia
                        int returnInsertProductOrder = statementInsertProductoOrder.executeUpdate();
                        if (returnInsertProductOrder != 0) {
                            inserted = true;
                        }

                    } else {
                        throw new ClassicModelsException("Error. No existe un producto con ese código");
                    }
                }
            } else {
                throw new ClassicModelsException("Error. No exite pedido con ese número");
            }
        } catch (SQLException e) { //Atrapo la excepción de fallos en SQL que nada le importa al user
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return inserted;
    }

    /**
     * Método para sacar por pantalla los detalle de un pedido
     *
     * @param orderNumber
     */
    public void orderToString(int orderNumber) throws ClassicModelsException {

        Connection connection = ConexionBD.getConnection();
        double totalOrderDetails = 0;

        try {
            String sqlOrderToString = "SELECT o.orderDate, o.requiredDate, o.shippedDate, o.comments, o.customerNumber," +
                    "p.productName, od.quantityOrdered, od.priceEach, (od.quantityOrdered * od.priceEach) AS total FROM orderdetails od INNER JOIN products p ON " +
                    " p.productCode = od.productCode INNER JOIN orders o ON o.orderNumber = od.orderNumber WHERE o.orderNumber = ? " +
                    " ORDER BY p.productName";
            PreparedStatement statementOrderToString = connection.prepareStatement(sqlOrderToString);
            statementOrderToString.setInt(1, orderNumber);

            ResultSet rsOrderToString = statementOrderToString.executeQuery();

            if (rsOrderToString.next()) {
                int customerNumber = rsOrderToString.getInt("customerNumber");
                String pedido = "\nLos detalles para el pedido con OrderNumber = " + orderNumber + " y número de cliente: " + customerNumber + " son:\n";
                boolean primero = true;

                while (primero || rsOrderToString.next()) {
                    Date orderDate = rsOrderToString.getDate("orderDate");
                    Date requiredDate = rsOrderToString.getDate("requiredDate");
                    Date shippedDate = rsOrderToString.getDate("shippedDate");
                    String comments = rsOrderToString.getString("comments");
                    String productName = rsOrderToString.getString("productName");
                    int quantify = rsOrderToString.getInt("quantityOrdered");
                    double priceEach = rsOrderToString.getDouble("priceEach");
                    totalOrderDetails += rsOrderToString.getDouble("total");

                    pedido += "\nNombre del producto: " + productName + "\n\tCantidad: " + quantify +
                            "\n\tPrecio total producto: " + priceEach  + "\nOrderDate = " + orderDate + "\nRequiered = "+ requiredDate + "\nShippedDate = " + shippedDate +
                            "\nComments = " + comments + "\n--------------------------------------------------";
                    primero = false;
                }

                pedido += "\n--------------------------------------------------\nTotal pedido: " + decimalFormat.format(totalOrderDetails);
                System.out.println(pedido);
            } else {
                throw new ClassicModelsException("Error. No se ha encontrado pedido con ese número");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para conocer la lista de empleados
     *
     * @return una lista
     */
    //Método estático que se llama desde la prueba clase
    public List<Employee> getEmpleados() {

        Connection connection = ConexionBD.getConnection();
        List<Employee> employeeList = new ArrayList<>();

        try {

            String sql = "SELECT * FROM employees";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();

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
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return employeeList;
    }

    /**
     * Método para conocer la lista de oficinas
     *
     * @return una lista
     */
    public List<Office> getOffices() {
        //Método estatico que se llama desde la prueba clase
        Connection connection = ConexionBD.getConnection();
        List<Office> officeList = new ArrayList<>();

        try {

            String sql = "SELECT * FROM offices";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery();

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
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return officeList;
    }
}

