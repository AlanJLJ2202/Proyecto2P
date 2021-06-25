
package Data;




import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DataAccess {
    private static DataAccess instance;
    private Connection con=null;
    private Statement  statement;
    private ResultSet resultSet;
    
    
    
    
    private DataAccess(){}
    
    public static DataAccess Instance(){
        if(instance == null)
            instance =  new DataAccess();
        return instance;
    }
    
    public void ConectarDB(){
        String URL = "jdbc:sqlserver://DESKTOP-2R4CM0U\\SQLEXPRESS:1433;databaseName=Proyecto2P;user=Usuario2P;password=Proyecto2P";
        
        try{
            con = DriverManager.getConnection(URL);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la conexion: " + e.getMessage());
        }
        
    }
    
    private void DesconectarDB(){
        try{
          
          resultSet.close();
          statement.close();
          con.close();
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la desconexion: " + e.getMessage()); 
        }
    }
    
   
    
    
    
    
    public DefaultTableModel Query(String query){
        try{
            ConectarDB();
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            Vector<String> columnNames =  new Vector<String>();
            int columnCount = resultSet.getMetaData().getColumnCount();
            for(int column = 1; column <= columnCount; column++){
                columnNames.add(resultSet.getMetaData().getColumnName(column));
            }
            
            
            Vector<Vector<Object>> data =  new Vector<Vector<Object>>();
            while(resultSet.next()){
                Vector<Object> vector = new Vector<Object>();
                for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                    vector.add(resultSet.getObject(columnIndex));
                }
                data.add(vector);
            }
            return new DefaultTableModel(data, columnNames);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
             return null;
        }finally {
            DesconectarDB();
        }
    }
    public int Execute(String query){
        try{
         ConectarDB();
         statement = con.createStatement();
         return statement.executeUpdate(query);
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error en el comando: " + e.getMessage()); 
           return 0;
        }finally{
            DesconectarDB();
        }
    }
}
