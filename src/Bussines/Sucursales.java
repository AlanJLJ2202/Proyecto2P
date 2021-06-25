
package Bussines;
import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Sucursales {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idSucursal, idContacto;
    private String nombre;
    private int activo;
    
 
    public Sucursales(){}

    public Sucursales(int idSucursal, int idContacto, String nombre, int activo) {
        this.idSucursal = idSucursal;
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
       public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.Sucursales";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Sucursales(idSucursal, nombre, idContacto, activo) " +
                "VALUES(" + idSucursal + ",'" + nombre + "','" + idContacto + "'," + activo + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Sucursales SET " +
                "idSucursal = " + idSucursal + ", " +
                "nombre = '" + nombre + "', " +
                "idContacto = " + idContacto + ", " +
                "activo = " + activo + " " +
                "WHERE idSucursal = " +idSucursal;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Sucursales WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Sucursales WHERE idSucursal = " + idSucursal;
        DefaultTableModel res = dataAccess.Query(query);
        idSucursal= (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        idContacto = (int)res.getValueAt(0, 2);
        activo = (int)res.getValueAt(0, 3);
          
    }
}
