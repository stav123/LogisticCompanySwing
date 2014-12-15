import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.*;

/**
 * Created by StefanS on 11/11/14.
 */
public class DBUtility {

    static Connection connection = null;

        static Connection getConnection(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","letmein");
                return connection;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
           return null;
        }

    public static ResultSet selectAll(String tableName) throws SQLException {


        if(tableName.equals("driver") || tableName.equals("vehicle")){
            connection = getConnection();
            String sql = "SELECT * FROM " + tableName;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        }else{
            connection = getConnection();
            String sql = "select driver.firstName, driver.lastName, vehicle.brand, vehicle.model FROM driver INNER JOIN driver_vehicle ON driver.d_id = driver_vehicle.id_driver INNER JOIN vehicle ON vehicle.v_id = driver_vehicle.id_vehicle";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        }

    }

    public static void refreshTable(JTable t, String tableName) throws SQLException{
        MyTable m = new MyTable(selectAll(tableName));
        System.out.println(t.getName());
        m.fireTableDataChanged();
        t.setModel(m);
        t.repaint();
    }


}