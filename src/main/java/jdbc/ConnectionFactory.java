package jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ConnectionFactory implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return Connection
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {

        try {
            
            String host = "localhost";
            String porta = "5432"; 
            String maintenancedb = "postgres";
            String username = "postgres";
            String password = "root";
            
            Class.forName("org.postgresql.Driver");           
            
            

            return DriverManager.getConnection("jdbc:postgresql://" + host + ":" + porta + "/" + maintenancedb + "?autoReconnect=true", username, password);   
                                                                                                   
           
            
           
        } catch (Exception e) {
            throw new Exception("Erro ao conectar ao Banco de Dados. " + e.getMessage());
        }
    }

    public static void closeConnection(Connection con, Statement stmt,
            ResultSet rs) throws Exception {
        close(con, stmt, rs);
    }

    public static void closeConnection(Connection con, Statement stmt)
            throws Exception {
        close(con, stmt, null);
    }

    public static void closeConnection(Connection con) throws Exception {
        close(con, null, null);
    }

    private static void close(Connection con, Statement stmt, ResultSet rs)
            throws Exception {
        try {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    ;
                }

                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    ;
                }

                stmt = null;
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    ;
                }
                con = null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

