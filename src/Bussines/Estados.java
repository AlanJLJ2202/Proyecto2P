
package Bussines;

import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Estados {
    private DataAccess dataAccess = DataAccess.Instance();
    
   private int idEstado;
   private String estado;
  
   
   public Estados(){
       
   }

    public Estados(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
        
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
   
    public DefaultTableModel GetAllModel(){
        String query = "SELECT idEstado AS ID, estado AS Estado FROM dbo.Estados";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel Ascendente(){
        String query = "SELECT idEstado AS ID, estado AS Nombre " +
                          "FROM Estados " +
                          "ORDER BY nombre ASC";
        return dataAccess.Query(query);
    }
    
    public DefaultTableModel Descendente(){
        String query = "SELECT idEstado AS ID, estado AS Nombre " +
                          "FROM Estados " +
                          "ORDER BY nombre DESC";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Estados(estado) " +
                "VALUES('" + estado + "');";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Estados SET " +
                
                "estado = '" + estado + "' " +
                
               
                "WHERE idEstado = " +idEstado;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Estados WHERE idEstado = " + idEstado;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Estados WHERE idEstado = " + idEstado;
        DefaultTableModel res = dataAccess.Query(query);
        idEstado= (int)res.getValueAt(0, 0);
        estado = (String)res.getValueAt(0, 1);
        
        
    }
}
