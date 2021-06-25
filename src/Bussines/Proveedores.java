
package Bussines;

import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Proveedores {
    
   private DataAccess dataAccess = DataAccess.Instance();
   private int idProveedor;
   private String nombre;
   private int idContacto;
   private int activo;
   
   public Proveedores(){
       
       
   }

    public Proveedores(int idProveedor, String nombre, int idContacto, int activo) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.idContacto = idContacto;
        this.activo = activo;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
   
   public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.Proveedores";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Proveedores(idProveedor, nombre, idContacto, activo) " +
                "VALUES(" + idProveedor + ",'" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Proveedores SET " +
                "idProveedor = " + idProveedor + ", " +
                "nombre = " + nombre + ", " +
                "idContacto = '" + idContacto + "', " +
                "activo = '" + activo + "', " +
                "WHERE idProveedor = " +idProveedor;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Proveedores WHERE idProveedor = " + idProveedor;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * dbo.Proveedores WHERE idProveedor = " + idProveedor;
        DefaultTableModel res = dataAccess.Query(query);
        idProveedor= (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        idContacto = (int)res.getValueAt(0, 2);
        activo = (int)res.getValueAt(0, 3);
        
        
        
    }
    
    
}
