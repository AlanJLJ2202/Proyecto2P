
package Bussines;
import Data.DataAccess;
import javax.swing.table.DefaultTableModel;


public class Usuarios {
    
    private DataAccess dataAccess = DataAccess.Instance();
    
    private int idUsuario, idSucursal, idContacto;
    private String nombre, tipoUsuario, usuario, password;
    
    public Usuarios(){
        
    }

    public Usuarios(int idUsuario, int idSucursal, int idContacto, String nombre, String tipoUsuario, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public DefaultTableModel GetAllModel(){
        String query = "SELECT * FROM dbo.Usuarios";
        return dataAccess.Query(query);
    }
   
    public boolean add(){
        String query = "INSERT INTO dbo.Usuarios(idSucursal, tipoUsuario, nombre, idContacto, usuario, password) " +
                "VALUES(" + idSucursal + ",'" + tipoUsuario + "','" + nombre + "'," + idContacto + ",'" + usuario + "','" + password + "');";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Usuarios SET " +
                
                "idSucursal = " + idSucursal + ", " +
                "tipoUsuario = '" + tipoUsuario + "', " +
                "nombre = '" + nombre + "', " +
                "idContacto = " + idContacto + ", " +
                "usuario = '" + usuario + "', " +
                "password = '" + password + "' " + 
                "WHERE idUsuario = " +idUsuario;      
        return dataAccess.Execute(query) >= 1; 
    }
     
     public boolean Empezar(){
         String query = "idUsuario int IDENTITY (1,1) PRIMARY KEY";
         
         return dataAccess.Execute(query) >=1;
     }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Usuarios WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Usuarios WHERE idUsuario = " + idUsuario;
        DefaultTableModel res = dataAccess.Query(query);
        idUsuario= (int)res.getValueAt(0, 0);
        idSucursal = (int)res.getValueAt(0, 1);
        tipoUsuario = (String)res.getValueAt(0, 2);
        nombre = (String)res.getValueAt(0, 3);
        idContacto = (int)res.getValueAt(0, 4);
        usuario = (String)res.getValueAt(0, 5);
        password = (String)res.getValueAt(0, 6);
        
    }
    
}
