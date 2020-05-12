import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static Connection connection=null;

    public static Connection getConnection(){
        try{
            if( connection== null ){
               // String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
                String url="jdbc:mysql://localhost/classicmodels?autoReconnect=true";
                String pwd="976431Fy++";
                String usr="Fany";
              //  Class.forName(driver);
                connection= DriverManager.getConnection(url,usr,pwd);
                System.out.println("Conexión establecida");
            }
        }
        catch(/*ClassNotFoundException |*/ SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }


    public static void close() {
            try {
                if(connection != null) {
                    connection.close();
                }
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}


