import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ADClassicModels {

    private static final DecimalFormat decimalFormat = new DecimalFormat("####.##");

    /**
     * Tarea U9_T4
     * Método para insertar una oficia
     *
     * @param office
     * @return
     * @throws ClassicModelsException
     */
    public static boolean insertOffice(Office office) throws ClassicModelsException {

        Connection connection = ConexionBD.getConnection();
        boolean result = false;
        boolean existed;
        int resultInsert = 0;

        try {
            existed = existOffice(office.getOfficeCode());

            if (existed) {
                throw new ClassicModelsException("Error, la oficina a introducir ya existe");
            } else {
                String sqlInsertOffice = "INSERT INTO offices (officeCode, city, phone, addressLine1," +
                        "addressLine2, state, country, postalCode, territory) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stInsertOffice = connection.prepareStatement(sqlInsertOffice);
                stInsertOffice.setString(1, office.getOfficeCode());
                stInsertOffice.setString(2, office.getAddressLine1());
                stInsertOffice.setString(3, office.getAddressLine2());
                stInsertOffice.setString(4, office.getCity());
                stInsertOffice.setString(5, office.getCountry());
                stInsertOffice.setString(6, office.getPhone());
                stInsertOffice.setString(7, office.getPostalCode());
                stInsertOffice.setString(8, office.getState());
                stInsertOffice.setString(9, office.getTerritory());

                resultInsert = stInsertOffice.executeUpdate();

                if (resultInsert != 0)
                    result = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    /**
     * Tarea U9_T4
     * Método para insertar un empleado
     *
     * @param employee
     * @return
     * @throws ClassicModelsException
     */
    public static boolean insertEmployee(Employee employee) throws ClassicModelsException {
        Connection connection = ConexionBD.getConnection();
        boolean aux = false;
        boolean result = false;
        int resultInsert = 0;

        try {
            aux = existEmployee(employee.getEmployeeNumber());

            if (aux) {
                throw new ClassicModelsException("Error, el empleado a introducir ya existe");
            } else {
                aux = existOffice(employee.getOfficeCode());

                if (aux) {
                    String sqlInsertEmployee = "INSERT INTO employees (employeeNumber, Email," +
                            "Extension, FirstName, JobTitle, LastName, OfficeCode, ReportsTo) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stInsertEmployee = connection.prepareStatement(sqlInsertEmployee);
                    stInsertEmployee.setInt(1, employee.getEmployeeNumber());
                    stInsertEmployee.setString(2, employee.getEmail());
                    stInsertEmployee.setString(3, employee.getExtension());
                    stInsertEmployee.setString(4, employee.getFirstName());
                    stInsertEmployee.setString(5, employee.getJobTitle());
                    stInsertEmployee.setString(6, employee.getLastName());
                    stInsertEmployee.setString(7, employee.getOfficeCode());
                    stInsertEmployee.setInt(8, employee.getReportsTo());
                    resultInsert = stInsertEmployee.executeUpdate();

                    if (resultInsert != 0) {
                        result = true;
                    }
                } else {
                    throw new ClassicModelsException("Error, la oficina a introducir no existe");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    /**
     * Tarea U9_T4
     * Método para insertar un nuveo pedido a un cliente
     * @param customerNumber
     * @param order
     * @return
     */
    public static boolean insertOrderCustomer(int customerNumber, Order order) throws ClassicModelsException{

        Connection connection = ConexionBD.getConnection();
        boolean existed = false;
        int lastOrderNumber;
        int inserted;

        try {
            //Compruebo si existe el cliente
            existed = existCustomer(customerNumber);
            if (existed) {
                //Saco el número del último pedido registrado
                String sqlLastOrderNumber = "SELECT orderNumber FROM orders ORDER BY orderNumber DESC LIMIT 1";
                PreparedStatement stLastOrderNumber = connection.prepareStatement(sqlLastOrderNumber);

                ResultSet rsLastOrderNumber = stLastOrderNumber.executeQuery();

                if (rsLastOrderNumber.next()) {
                    lastOrderNumber = rsLastOrderNumber.getInt("orderNumber");

                    //Creo el nuevo pedido
                    String sqlInsertOrder = "INSERT INTO orders (orderNumber, customerNumber, orderDate, requiredDate," +
                            "shippedDate, status, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stInsertOrder = connection.prepareStatement(sqlInsertOrder);
                    stInsertOrder.setInt(1,++lastOrderNumber);
                    stInsertOrder.setInt(2, customerNumber);
                    stInsertOrder.setDate(3, order.getOrderDate());
                    stInsertOrder.setDate(4, order.getRequiredDate());
                    stInsertOrder.setDate(5, order.getShippedDate());
                    stInsertOrder.setString(6, order.getStatus());
                    stInsertOrder.setString(7, order.getComments());

                    inserted = stInsertOrder.executeUpdate();

                    if(inserted != 0) {
                        existed = true;
                    }
                }
            } else {
                throw new ClassicModelsException("Error, el cliente no existe");
            }

    } catch (SQLException e) {
            e.printStackTrace();
        }
        return existed;
    }

    /**
     * Tarea U9_T4
     * Método para insertar un nuevo cliente
     *
     * @param customer
     * @return
     */
    public static boolean insertCustomer(Customer customer) throws ClassicModelsException {
        boolean inserted = false;
        //int customerNumber;

        Connection connection = ConexionBD.getConnection();

        try {
            //Compruebo si el cliente que quiero introducir existe ya en la BD
            inserted = existCustomer(customer.getCustomerNumber());

            //Si exite lanzo un error
            if (inserted) {
                throw new ClassicModelsException("Lo siento, pero ese número de cliente ya existe. Ingrese un nuevo número de usuario");
                //Si no exixte, continuo
            } else {
                //Compruebo si el vendedor exite
                inserted = existEmployee(customer.getSalesRepEmployeeNumber());

                if (inserted) {
                    //Creo la sentencia SQL
                    String sqlInsertCustomer = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName," +
                            "phone, addressLine1, addressLine2, city, state, postalCode, country, SalesRepEmployeeNumber, creditLimit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                    statement.setInt(12, customer.getSalesRepEmployeeNumber());

                    if ("".equals(customer.getCreditLimit())) {
                        statement.setNull(13, Types.FLOAT);
                    } else {
                        statement.setFloat(13, customer.getCreditLimit());
                    }

                    int rs = statement.executeUpdate();
                    if (rs != 0) {
                        inserted = true;
                    } else {
                        inserted = false;
                    }
                } else {
                    throw new ClassicModelsException("Error, el número de empleado no existe");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return inserted;
    }

    /**
     * Tarea U9_T4
     * Método para insertar un producto en un pedido
     *
     * @param productCode
     * @param orderNumber
     * @param quantityOrdered
     * @return
     * @throws ClassicModelsException
     */
    public static boolean insertProductoOrder(String productCode, int orderNumber, int quantityOrdered) {

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
                        statementInsertProductoOrder.setDouble(4, buyPrice * quantityOrdered);
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
        } catch (SQLException | ClassicModelsException e ) { //Atrapo la excepción de fallos en SQL que nada le importa al user
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return inserted;
    }

    /**
     * Tarea U9_T4
     * Método para comprobar si existe el cliente en la BD
     * @param customerNumber
     * @return
     */
    private static boolean existCustomer(int customerNumber) {

        Connection connection = ConexionBD.getConnection();
        boolean existed = false;

        try {
            String sqlCustomer = "SELECT * FROM customers WHERE customerNumber = ?";
            PreparedStatement statementCustomer = connection.prepareStatement(sqlCustomer);
            statementCustomer.setInt(1, customerNumber);

            ResultSet existed2 = statementCustomer.executeQuery();
            if(existed2.next()) {
                existed = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existed;
    }

    /**
     * Tarea U9_T4
     * Método para comprobar si existe el empleado en la BD
     * @param employeeNumber
     * @return
     */
    private static boolean existEmployee(int employeeNumber) {

        Connection connection = ConexionBD.getConnection();
        boolean existed = false;

        try {
            String sqlEmployee = "SELECT * FROM employees WHERE employeeNumber = ?";
            PreparedStatement stEmployee = connection.prepareStatement(sqlEmployee);
            stEmployee.setInt(1, employeeNumber);

            ResultSet existed2 = stEmployee.executeQuery();
            if(existed2.next()) {
                existed = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existed;
    }

    /**
     * Tarea U9_T4
     * Método para comprobar si existe la oficina en la BD
     * @param officeCode
     * @return
     */
    private static boolean existOffice(String officeCode) {

        Connection connection = ConexionBD.getConnection();
        boolean existed = false;

        try {
            String sqlExistOffice = "SELECT officeCode FROM offices WHERE officeCode = ?";
            PreparedStatement stExistOffice = connection.prepareStatement(sqlExistOffice);
            stExistOffice.setString(1, officeCode);

            ResultSet existed2 = stExistOffice.executeQuery();

            if(existed2.next()) {
                existed = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existed;
    }

    public static void namesCustomSalesToString(int customerNumber) throws ClassicModelsException {
        Connection connection = ConexionBD.getConnection();
        boolean existed;

        try {
            existed = existCustomer(customerNumber);
            if(existed) {
                String sqlNamesCustomSalesToString = "SELECT c.customerName, e.firstName, " +
                        "o.city FROm customers c INNER JOIN employees e ON c.salesRepEmployeeNumber = e.employeeNumber " +
                        "INNER JOIN offices o ON e.officeCode = o.officeCode WHERE c.customerNumber = ?";
                PreparedStatement stnamesCustomSalesToString = connection.prepareStatement(sqlNamesCustomSalesToString);
                stnamesCustomSalesToString.setInt(1,customerNumber);

                ResultSet rsnamesCustomSalesToString = stnamesCustomSalesToString.executeQuery();

                while(rsnamesCustomSalesToString.next()) {
                    String customerName = rsnamesCustomSalesToString.getString("customerName");
                    String firstNameEmployee = rsnamesCustomSalesToString.getString("firstName");
                    String city = rsnamesCustomSalesToString.getString("city");

                    System.out.println("Nombre del cliente: " + customerName + "\nNombre del empleado: " + firstNameEmployee
                    + "\nCiudad de la oficina: " + city);
                }
            } else {
                throw new ClassicModelsException("Error. No se encontró el cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Tarea U9_T4
     * 2º Método para imprimir por pantalla los detalles del pedido.
     * @param orderNumber
     * @throws ClassicModelsException
     */
    public static void orderToString2(int customerNumber, int orderNumber) throws ClassicModelsException {
        Connection connection = ConexionBD.getConnection();

        try {
            String sqlOrderToString2 = "SELECT c.customerName, o.orderDate, o.status, p.productName, " +
                    "od.quantityOrdered,od.quantityOrdered, p.buyPrice*od.quantityOrdered AS totalProducto FROM orders o " +
                    "INNER JOIN customers c ON o.customerNumber = c.customerNumber " +
                    "INNER JOIN orderdetails od ON o.orderNumber = od.orderNumber " +
                    "INNER JOIN products p ON p.productCode = od.productCode " +
                    "WHERE c.customerNumber = ? AND o.orderNumber = ? GROUP BY o.orderNumber, p.productName";
            PreparedStatement stOrderToString2 = connection.prepareStatement(sqlOrderToString2);
            stOrderToString2.setInt(1, customerNumber);
            stOrderToString2.setInt(2, orderNumber);

            ResultSet rsOrderToString2 = stOrderToString2.executeQuery();

            if (rsOrderToString2.next()) {
                String customerName = rsOrderToString2.getString("customerName");
                String pedido = "\nLos detalles del pedido: " + orderNumber + " para el cliente " + customerName + " son:\n";
                boolean primero = true;

                while (primero || rsOrderToString2.next()) {
                    Date orderDate = rsOrderToString2.getDate("orderDate");
                    String status = rsOrderToString2.getString("status");
                    String productName = rsOrderToString2.getString("productName");
                    int quantityOrdered = rsOrderToString2.getInt("quantityOrdered");
                    double totalProducto = rsOrderToString2.getDouble("totalProducto");

                    pedido += "\nNombre del producto: " + productName + "\n\tCantidad: " + quantityOrdered +
                            "\n\tPrecio total producto: " + decimalFormat.format(totalProducto) + "\nOrderDate = " + orderDate + "\nStatus = " + status +
                            "\n--------------------------------------------------";
                    primero = false;
                }
                System.out.println(pedido);
            } else {
                throw new ClassicModelsException("Error, no se ha podido encontrar el pedido con ese número");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para asignar un vendedor a un cliente
     *
     * @param salesID
     * @param customerID
     * @return
     * @throws ClassicModelsException
     */
    public static boolean assingnSales(int salesID, int customerID) throws ClassicModelsException {

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
     * Método para sacar por pantalla los detalle de un pedido
     *
     * @param orderNumber
     */
    public static void orderToString(int orderNumber) throws ClassicModelsException {

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
                            "\n\tPrecio total producto: " + priceEach + "\nOrderDate = " + orderDate + "\nRequiered = " + requiredDate + "\nShippedDate = " + shippedDate +
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
    public static List<Employee> getEmpleados() {

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
        }
        return employeeList;
    }

    /**
     * Método para conocer la lista de oficinas
     *
     * @return una lista
     */
    public static List<Office> getOffices() {
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
        }
        return officeList;
    }



}


