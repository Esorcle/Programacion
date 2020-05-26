import org.graalvm.compiler.phases.graph.ScopedPostOrderNodeIterator;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Connection connection = ConexionBD.getConnection();
        if (connection != null) {
            boolean result;

            firstTransaction(connection);
            secondTransaction(connection);

            try {
                System.out.println("1º Consulta");
                ADClassicModels.namesCustomSalesToString(401);

                System.out.println("\n2º Consulta");
                ADClassicModels.orderToString2(401, 10426);

            } catch (ClassicModelsException e) {
                e.printStackTrace();
            }

            ConexionBD.close();
        } else {
            System.out.println("No se ha podido conectar");
        }
    }

    /**
     * Método para realizar la 1º transacción
     * @param connection
     */
    private static void firstTransaction(Connection connection) {
        boolean result;
        try {
            connection.setAutoCommit(false);

            result = ADClassicModels.insertOffice(new Office(
                    "8", "Sevilla", "+34 956 521 578",
                    "Plaza España", "", "",
                    "España", "41960", "EMEA"));
            if (result) {
                System.out.println("Se ha insertado la oficina");

                result = ADClassicModels.insertEmployee(new Employee(1800,
                        "Clemente",
                        "Ortiz", "x52463", "esonafa@adclassic.com",
                        "8", 1102, "Sales Resp"));
                if (result) {
                    System.out.println("Se ha insertado la empleado");

                    result = ADClassicModels.insertEmployee(new Employee(1801,
                            "Lopez",
                            "Guti", "x5gf63", "asjeitnsjfa@adclassic.com",
                            "8", 1102, "Sales Resp"));
                    if (result) {
                        System.out.println("Se ha insertado el empledado");

                        result = ADClassicModels.insertCustomer(new Customer(401,
                                "Antonio", "Vázquez",
                                "Cruz", "6528245633", "Salvador",
                                null, "Sevilla", null,
                                "41960", "España",
                                1801, (float) 500.55));
                        if (result) {
                            System.out.println("Se ha insertado el cliente");

                            connection.commit();

                        } else {
                            System.out.println("Error, el cliente no se ha podido introducir");
                            if (connection != null) {
                                System.out.println("Dejamos la BD en su estado inicial");
                                connection.rollback();
                            }
                        }
                    } else {
                        throw new ClassicModelsException("Error, el segundo empleado no se ha podido introducir");
                    }
                } else {
                    throw new ClassicModelsException("Error, el primer empleado no se ha podido introducir");
                }
            } else {
                throw new ClassicModelsException("Error, la oficina no se ha podido introducir");
            }
        } catch (SQLException | ClassicModelsException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    System.out.println("Dejamos la BD en su estado inicial");
                    connection.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el rollback");
                ex.printStackTrace();
            }
        }
    }

    /**
     * Método para realizar la 2º transacción
     * @param connection
     */
    private static void secondTransaction(Connection connection) {
        boolean result;

        try {
            connection.setAutoCommit(false);

            result = ADClassicModels.insertOrderCustomer(401, new Order(0, 401, createDate(2020, 5, 20),
                    createDate(2020, 5, 26), createDate(2020, 5, 23), "Shipped", null));
                    System.out.println("Se ha abierto un nuevo pedido al cliente " + 401);

            if (result) {
                result = ADClassicModels.insertProductoOrder("S10_4962", 10426,3 );
                System.out.println("Se ha introducido el 1º producto");

                if (result) {
                    result = ADClassicModels.insertProductoOrder("S12_3891", 10426, 5);
                    System.out.println("Se ha introducido el 2º producto");

                    if (!result) {
                        throw new ClassicModelsException("Error. No se pudo insertar el 2º producto");
                    }
                } else {
                    throw new ClassicModelsException("Error. No se pudo insertar el 1º producto");
                }
            } else {
                throw new ClassicModelsException("Error. No se pudo insertar el nuevo pedido");
            }

            connection.commit();
        } catch (ClassicModelsException | SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    System.out.println("Dejamos la BD en su estado inicial");
                    connection.rollback();
                }
            } catch (SQLException ex) {
                System.out.println("Error en el rollback");
                ex.printStackTrace();
            }
        }
    }

    /**
     * Método para dar formato de date para sql de una fecha
     * @param year
     * @param mes
     * @param dia
     * @return
     */
    private static Date createDate(int year, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, mes - 1, dia);

        return new Date(calendar.getTimeInMillis());
    }
}