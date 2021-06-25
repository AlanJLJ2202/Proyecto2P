
package Bussines;

import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class ProductoProveedor {
    
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idProductoProveedor;
    private int idProducto;
    private int idProveedor;
    
    public ProductoProveedor(){
        
    }
    
    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }
    

    public ProductoProveedor(int idProductoProveedor, int idProducto, int idProveedor) {
        this.idProductoProveedor = idProductoProveedor;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        
    }

    public int getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(int idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
     public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.productosProveedores";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.productosProveedores(idProducto, idProveedor) " +
                "VALUES(" + idProducto + "," + idProveedor + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.productosProveedores SET " +
                "idProducto = " + idProducto + ", " +
                "idProveedor = " + idProveedor + ", " +
                
                
                "WHERE idProductoProveedor = " +idProductoProveedor;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.productosProveedores WHERE idProductoProveedor = " + idProductoProveedor;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.productosProveedores WHERE idProductoProveedor = " + idProductoProveedor;
        DefaultTableModel res = dataAccess.Query(query);
        idProductoProveedor = (int)res.getValueAt(0, 0);
        idProducto = (int)res.getValueAt(0, 1);
        idProveedor = (int)res.getValueAt(0, 2);
           
    }
    
    
    
    
}
