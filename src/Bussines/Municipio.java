
package Bussines;

import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Municipio {
    private DataAccess dataAccess = DataAccess.Instance();
    private int idMunicipio, idEstado;
    private String municipio;
    
    public Municipio(){
        
    }

    public Municipio(int idMunicipio, int idEstado, String municipio) {
        this.idMunicipio = idMunicipio;
        this.idEstado = idEstado;
        this.municipio = municipio;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
     public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.Municipios";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Municipios(idEstado, municipio) " +
                "VALUES(" + idEstado + ",'" + municipio + "');";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Municipios SET " +
                
                "idEstado = " + idEstado + ", " +
                "municipio = '" + municipio + "' " +
                
                "WHERE idMunicipio = " +idMunicipio;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Municipios WHERE idMunicipio = " + idMunicipio;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Municipios WHERE idMunicipio = " + idMunicipio;
        DefaultTableModel res = dataAccess.Query(query);
        idMunicipio= (int)res.getValueAt(0, 0);
        idEstado = (int)res.getValueAt(0, 1);
        municipio = (String)res.getValueAt(0, 2);
       
        
    }
}
