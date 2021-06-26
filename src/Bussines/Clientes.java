
package Bussines;
import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */

public class Clientes {
    private DataAccess dataAccess = DataAccess.Instance();
    private int idCliente;
    private String nombre;
    private int idContacto;
    private int activo;
    
    public Clientes(){
        
    }

    public Clientes(int idCliente, String nombre, int idContacto, int activo) {
        this.idCliente = idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        String query = "SELECT idCliente AS ID, " +
                              "nombre AS Nombre, " + 
                               "idContacto AS Contacto FROM dbo.Clientes";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Clientes(nombre, idContacto, activo) " +
                "VALUES('" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Clientes SET " +
                
                "nombre = '" + nombre + "', " +
                "idContacto = " + idContacto + ", " +
                "activo = " + activo + " " +
                "WHERE idCliente = " +idCliente;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Clientes WHERE idCliente = " + idCliente;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Clientes WHERE idCliente = " + idCliente;
        DefaultTableModel res = dataAccess.Query(query);
        idCliente = (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        idContacto = (int)res.getValueAt(0, 2);
        activo = (int)res.getValueAt(0, 3);
          }
}
