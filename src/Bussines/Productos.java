
package Bussines;

import Data.DataAccess;

import java.sql.Timestamp;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class Productos {
    
    private DataAccess dataAccess = DataAccess.Instance();
    
    
    private int idProducto, idCategoria;
    private String nombre;
    private int precio;
    private String caducidad;
    private double descuento;
    private int activo;
    
    public Productos(){
        
    }

    public Productos(int idProducto, int idCategoria, String nombre, int precio, String caducidad, double descuento, int activo) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.precio = precio;
        this.caducidad = caducidad;
        this.descuento = descuento;
        this.activo = activo;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

   public int isActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
     public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.Productos";
        return dataAccess.Query(query);
    }
     
     public void GetById(){
        String query =  "SELECT * FROM dbo.Productos WHERE idProducto = " + idProducto;
        DefaultTableModel res = dataAccess.Query(query);
        idProducto= (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        precio = (int)res.getValueAt(0, 2);
        caducidad = (String)res.getValueAt(0, 3);
        idCategoria = (int)res.getValueAt(0, 4);
        descuento = (double)res.getValueAt(0, 5);
        activo = (int)res.getValueAt(0, 6);
        
    }
    //INSERT INTO TABLA(C1, C2) VALUES(V1, V2);
    public boolean add(){
        String query = "INSERT INTO dbo.Productos(idProducto, nombre, precio, caducidad, idCategoria, descuento, activo) " +
                "VALUES(" + idProducto + ",'" + nombre + "'," + precio + "," + caducidad + "," + idCategoria + "," + descuento + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    public boolean Delete(){
        String query = "DELETE FROM dbo.Productos WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1; 
    }
    
    public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Productos SET " +
                "idProducto= '" + idProducto + "', " +
                "nombre = '" + nombre + "', " +
                "precio = " + precio + ", " +
                "caducidad = " + caducidad + ", " +
                "idCategoria = " + idCategoria + ", " +
                "descuento = " + descuento + ", " +
                "activo = " + activo + " " + 
                "WHERE idProductos = " +idProducto;      
        return dataAccess.Execute(query) >= 1; 
    }
    
    
    
    
    
}
