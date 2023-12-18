
package banco_dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    
    public static Connection getConnection(){
        try{
        	
        	Properties prop = getProp();
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbaulads?useTimezone=true&serverTimezone=UTC"
                    , "root"
                    , ""
                    );
        } 
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public static void closeConnection(Connection con){
        try{
            if(!con.isClosed()){
                con.close();
            }
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm){
        try{
            if(!con.isClosed()){
                con.close();
            }
            
            if(!stm.isClosed()){
                stm.close();
            }
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs){
        try{
            if(!con.isClosed()){
                con.close();
            }
            
            if(!stm.isClosed()){
                stm.close();
            }
            
            if(!rs.isClosed()){
                rs.close();
            }
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
   
	private static Properties getProp() {
    	
    	Properties prop = new Properties();
    	try {
    		FileInputStream file = new FileInputStream("./properties/config.properties");
    		prop.load(file);
    		file.close();
    	} catch(IOException e) {
    		throw new RuntimeException(e);
    	}
    	return prop;
    }
}
