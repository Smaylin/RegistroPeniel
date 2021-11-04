package Conexion;

import java.sql.*;

public class Conectar{

    static String bd = "u279581364_webpeniel";
    static String login = "u279581364_peniel";
    static String password = "S8092730489s";
    static String url = "jdbc:mysql://sql550.main-hosting.eu/"+bd;
    Connection connection = null;

    public Conectar(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,login,password);
        if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar(){
        connection = null;
    }


}
