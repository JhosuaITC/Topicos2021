package sample.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String server = "127.0.0.1";
    private static String user = "ibiza21";
    private static String pwd = "toor";
    private static String db = "micasete";
    private static Connection coexion;

    public static void getConexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            coexion = DriverManager.getConnection("jdbc:mariadb://"+server+":3306/"+db,user,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
