
package Bussines;
import Data.DataAccess;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author AJLJ-
 */
public class Categoria {
    
    private DataAccess dataAccess = DataAccess.Instance();
    private int idCategoria;
    private String nombre;
    private int activo;
    
    public Categoria(){
        
        
    }

    public Categoria(int idCategoria, String nombre, int activo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
       public DefaultTableModel GetAllModel(){
        String query = "SELECT idCategoria AS ID, nombre AS Categoria FROM dbo.Categorias";
        return dataAccess.Query(query);
    }
       
        public DefaultTableModel Ascendente(){
           String query = "SELECT idCategoria AS ID, nombre AS Nombre " +
                          "FROM Categorias " +
                          "ORDER BY nombre ASC";
        return dataAccess.Query(query);
       }
   
         public DefaultTableModel Descendente(){
           String query = "SELECT idCategoria AS ID, nombre AS Nombre " +
                          "FROM Categorias " +
                          "ORDER BY nombre DESC";
        return dataAccess.Query(query);
       }
         
         public DefaultTableModel Buscar(String entrada){
           String query = "SELECT idCategoria AS ID, nombre AS Nombre " +
                          "FROM Categorias " +
                          "LIKE '%" + entrada + "%'";
        return dataAccess.Query(query);
       }
         
   
   
    public boolean add(){
        String query = "INSERT INTO dbo.Categorias(nombre, activo) " +
                "VALUES('" + nombre + "'," + activo + ");";
        return dataAccess.Execute(query) >= 1;        
    }
    
    
     public boolean Update(){
    //update tabla set c1=v1 c2=v2 c3=v3;    
        String query = "UPDATE dbo.Categorias SET " +
                
                "nombre = '" + nombre + "', " +
                "activo = " + activo + " " +
                "WHERE idCategoria = " + idCategoria;      
        return dataAccess.Execute(query) >= 1; 
    }
    
     public boolean Delete(){
        String query = "DELETE FROM dbo.Categorias WHERE idCategoria = " + idCategoria;
        return dataAccess.Execute(query) >= 1; 
    }
     
       public void GetById(){
        String query =  "SELECT * FROM dbo.Categorias WHERE idCategoria = " + idCategoria;
        DefaultTableModel res = dataAccess.Query(query);
        idCategoria= (int)res.getValueAt(0, 0);
        nombre = (String)res.getValueAt(0, 1);
        activo = (int)res.getValueAt(0, 2);
       
        
    }
    
}
