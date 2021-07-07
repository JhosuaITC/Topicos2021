package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class CancionesDAO {
    private int id_cancion;
    private String nombre_cancion;
    private int duracion;
    private String portada;
    private int year;
    private String letra;

    public int getId_cancion() {
        return id_cancion;
    }
    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }
    public String getNombre_cancion() {
        return nombre_cancion;
    }
    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getPortada() {
        return portada;
    }
    public void setPortada(String portada) {
        this.portada = portada;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    //manda datos
    //Conexion conexion;
    public void INSERT(){
        try {
            String query = "INSERT INTO tbl_canciones (nombre_cancion, duracion, portada, year, letra) " +
                    "VALUES('"+nombre_cancion+"',"+duracion+",'"+portada+"',"+year+",'"+letra+"')";
            //Conexion.getConexion();
            Statement statement =Conexion.coexion.createStatement();
            statement.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //manda datos
    public void UPDATE(){
        try {
            String query ="UPDATE tbl_canciones SET nombre_cancion= '"+nombre_cancion+"',duracion= "+duracion+", "+
                    "portada ='"+portada+"',year= "+year+", letra='"+letra+"' WHERE id_cancion = "+id_cancion;
            Statement statement = Conexion.coexion.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //actualiza la BD
    public void DELETE(){
        try{
            String query= "DELETE FROM tbl_canciones WHERE id_cancion = "+id_cancion;
            Statement statement = Conexion.coexion.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //trae datos
    public ObservableList<CancionesDAO> SELECT(){
        ObservableList<CancionesDAO> list= FXCollections.observableArrayList();
        try {
            CancionesDAO dao;
            //DESC ordenamiento decendiente
            String query = "SELECT * FROM tbl_canciones ORDER BY nombre_cancion ASC";
            Statement statement = Conexion.coexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                dao=new CancionesDAO();
                dao.id_cancion= resultSet.getInt("id_cancion");
                dao.nombre_cancion=resultSet.getString("nombre_cancion");
                dao.duracion=resultSet.getInt("duracion");
                dao.portada= resultSet.getString("portada");
                dao.year= resultSet.getInt("year");
                dao.letra=resultSet.getString("letra");
                list.add(dao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }
}
