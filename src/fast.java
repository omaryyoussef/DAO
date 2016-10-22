import java.sql.*;
public class fast {

	static
    {
        //STEP 1 : Registering The Driver Class
 
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Unable To Load The Driver class");
        }
    }
 
    public static void main(String[] args)
    {
        Connection con = null;
 
        Statement stmt = null;
 
        try
        {
            //Database Credentials
             
            String URL = "jdbc:oracle:thin:@localhost:1521:XE";
 
            String username = "username";
 
            String password = "password";
 
            //STEP 2 : Creating The Connection Object
 
            con = DriverManager.getConnection(URL, username, password);
 
            //STEP 3 : Creating The Statement Object
 
            stmt = con.createStatement();
 
            //Constructing The SQL Query
 
            String sql = "CREATE TABLE PRODUCT(" +
                    "PRODUCT_ID NOT NULL, " +
                    "TYPE VARCHAR2(200), " +
                    "MANUFACTURER VARCHAR2(200), " +
                    "PRODUCTION_DATE VARCHAR2(200)" +
                    "EXPIRY_DATE VARCHAR2 (200))";
 
            //Step 4 : Executing The Query
 
            //We are using executeUpdate() method as we are executing CREATE statement
 
            int i = stmt.executeUpdate(sql);
 
            if(i == 0)
            {
                System.out.println("Table is created");
            }
            else
            {
                System.out.println("Table is not created");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //STEP 5 : Closing The DB Resources
 
            //Closing the Statement object
            try
            {
                if(stmt!=null)
                {
                    stmt.close();
                    stmt=null;
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
 
            //Closing the Connection object
 
            try
            {
                if(con!=null)
                {
                    con.close();
                    con=null;
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
