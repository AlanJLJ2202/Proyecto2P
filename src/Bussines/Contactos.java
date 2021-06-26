
package Bussines;

import Data.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AJLJ-
 */
public class Contactos {
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idContacto;
    private String entidad;
    private int idMunicipio;
    private String calle;
    private int codigoPostal;
    private int telefono;
    
    public Contactos(){
        
    }

    public Contactos(int idContacto, String entidad, int idMunicipio, String calle, int codigoPostal, int telefono) {
        this.idContacto = idContacto;
        this.entidad = entidad;
        this.idMunicipio = idMunicipio;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.telefono = telefono;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }


    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public int getMunicipio() {
        return idMunicipio;
    }

    public void setMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.Contactos";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Contactos(entidad, idMunicipio, calle, codigoPostal, telefono) " +
                "VALUES('" + entidad +"," + idMunicipio + ",'" + calle + "'," + codigoPostal + "," + telefono + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Contactos SET " +
                "entidad = '" + entidad + "', " +
                "idMunicipio = " + idMunicipio + ", " +
                "calle = '" + calle + "', " +
                "codigoPostal = " + codigoPostal + ", " +
                "telefono = " + telefono + " " +
                
                "WHERE idContacto = " +idContacto;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Contactos WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Contactos WHERE idContacto = " + idContacto;
        DefaultTableModel res = dataAccess.Query(query);
        idContacto= (int)res.getValueAt(0, 0);
        entidad = (String)res.getValueAt(0, 1);
        idMunicipio = (int)res.getValueAt(0, 2);
        calle = (String)res.getValueAt(0, 3);
        codigoPostal = (int)res.getValueAt(0, 4);
        telefono = (int)res.getValueAt(0, 5);
        
        
    }
    
}
