
package Bussines;

import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Localidades {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idLocalidad, idMunicipio;
    private String localidad;
    
    public Localidades(){
        
    }

    public Localidades(int idLocalidad, int idMunicipio, String localidad) {
        this.idLocalidad = idLocalidad;
        this.idMunicipio = idMunicipio;
        this.localidad = localidad;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
     public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.Localidades";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Localidades(idLocalidad, idMunicipio, localidad) " +
                "VALUES(" + idLocalidad + "," + idMunicipio + ",'" + localidad + "');";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Localidades SET " +
                "idLocalidad = " + idLocalidad + ", " +
                "idMunicipio = " + idMunicipio + ", " +
                "localidad = '" + localidad + "' " +
                
                "WHERE idLocalidad = " +idLocalidad;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Localidades WHERE idLocalidad = " + idLocalidad;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Localidades WHERE idLocalidad = " + idLocalidad;
        DefaultTableModel res = dataAccess.Query(query);
        idLocalidad= (int)res.getValueAt(0, 0);
        idMunicipio = (int)res.getValueAt(0, 1);
        localidad = (String)res.getValueAt(0, 2);
        
        
    }
}
