/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Billy
 */
public class OracleDAOFactory extends DAOFactory{
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DBURL = "jdbc:oracle:thin:c##admin/N1nwehMyHearT@localhost:1521:tutorial12c";
    
    //static JDBCConnectionPool pool; 
    //method to create connections
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        //Need to implement connections pool
        /*if (pool == null){
            pool = new JDBCConnectionPool();
        }
        return pool.getConnectionFromPool();*/
        //create connection
        Connection con = null;
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:c##admin/N1nwehMyHearT@localhost:1521:tutorial12c");
        } catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        // TODO: handle exception

        finally{
            return con;
        }
    }
    
    

}
