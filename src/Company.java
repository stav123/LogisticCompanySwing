import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* Created by StefanS on 11/11/14.
*/
public class Company extends JFrame implements ActionListener{
    int selectedIntex;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;


    /*
    tables
     */

    //driver table

     static JTable driverTable = new JTable();

    // vehicle table

    static JTable vehicleTable = new JTable();

    //driver-vehicle table

    static JTable driverVehicleTable = new JTable();

    JScrollPane driverScroller = new JScrollPane(driverTable);
    JScrollPane vehicleScroller = new JScrollPane(vehicleTable);
    JScrollPane driverVehicleScroller = new JScrollPane(driverVehicleTable);

    /*
    end of tables
     */

    /*
    this is the labels part
     */

    //driver labels

    JLabel driverFirstNameLabel = new JLabel("Driver's first name");
    JLabel driverLastNameLabel = new JLabel("Driver's last name");
    JLabel driverAgeLabel = new JLabel("Driver's age");
    JLabel driverExperienceLabel = new JLabel("Driver's experience");
    JLabel driverUniqueNumberLabel = new JLabel("Driver's unique company number");


    //vehicle labels

    JLabel vehicleBrandLabel = new JLabel("Vehicle's brand");
    JLabel vehicleModelLabel = new JLabel("Vehicle's model");
    JLabel vehicleProductionYear = new JLabel("Vehicle's production year");
    JLabel vehicleUniqueID= new JLabel("Vehicle's unique ID");

    //driver-vehicle labels
    JLabel driverIDLabel = new JLabel("Driver's ID");
    JLabel vehicleIDLabel = new JLabel("Vehicle's ID");


    /*
    end of labels part
     */

    /*
    this is the field part
     */

    //driver fields

    JTextField fieldFirstName = new JTextField();
    JTextField fieldLastName = new JTextField();
    JTextField fieldAge = new JTextField();
    JTextField fieldExperience = new JTextField();
    JTextField fieldUniqueNumber = new JTextField();


    //vehicle fields

    JTextField fieldBrand = new JTextField();
    JTextField fieldModel = new JTextField();
    JTextField fieldProductionYear = new JTextField();
    JTextField fieldUniqueID = new JTextField();

    //vehicle-driver fields
    JTextField driverIDField = new JTextField();
    JTextField vehicleIDField = new JTextField();

    /*
    end of fields part
     */



    /*
    this is the buttons part
     */

    //driver buttons

    JButton driverAddButton = new JButton("Add driver");
    JButton driverShowAllButton = new JButton("Show all drivers");
    JButton driverDeleteButton = new JButton("Delete driver");
    JButton driverEditButton = new JButton("Edit driver");
    JButton driverSearchButton = new JButton("Search");

    //vehicle buttons

    JButton vehicleAddButton = new JButton("Add vehicle");
    JButton vehicleShowAllButton = new JButton("Show all vehicles");
    JButton vehicleDeleteButton = new JButton("Delete vehicle");
    JButton vehicleEditButton = new JButton("Edit vehicle");
    JButton vehicleSearchButton = new JButton("Search vehicle");

    //driver-vehicle buttons

    JButton driverVehicleAddButton = new JButton("Add vehicle to driver");
    JButton driverVehicleShowAllButton = new JButton("Show all");
    JButton driverVehicleEditButton = new JButton("Edit");
    JButton driverVEhicleDeleteButton = new JButton("Delete");

    /*
    end of buttons part
     */

    static JComboBox myCombo = new JComboBox();
    static JTabbedPane tabs = new JTabbedPane();

    /*
    this is the panel part
     */

    // driver panels
    JPanel driverTabPanel = new JPanel();
    JPanel driverTopPanel = new JPanel();
    JPanel driverDownPanel = new JPanel();
    JPanel driverTablePanel = new JPanel();
    // vehicle panels
    JPanel vehicleTabPanel = new JPanel();
    JPanel vehicleTopPanel = new JPanel();
    JPanel vehicleDownPanel = new JPanel();
    JPanel vehicleTablePanel = new JPanel();
    //driver-vehicle panels
    JPanel driverVehicleTabPanel = new JPanel();
    JPanel driverVehicleTopPanel = new JPanel();
    JPanel driverVehicleDownPanel = new JPanel();
    JPanel driverVehicleTablePanel = new JPanel();

    /*
    end of panel part
     */

    // START OF THE CONSTRUCTOR

    public Company(){
        super("");
        this.setSize(600,600);
        this.setTitle("Logistic company");
        this.add(tabs);
        tabs.add("Drivers", driverTabPanel);
        tabs.add("Vehicles", vehicleTabPanel);
        tabs.add("Driver-Vehicle", driverVehicleTabPanel);

        //DRIVERS TAB

        driverTabPanel.setLayout(new GridLayout(3, 1));
        driverTabPanel.add(driverTopPanel);
        driverTabPanel.add(driverDownPanel);
        driverTabPanel.add(driverTablePanel);

        //driver top panel

        driverTopPanel.setLayout(new GridLayout(5, 2));
        driverTopPanel.add(driverFirstNameLabel);
        driverTopPanel.add(fieldFirstName);
        driverTopPanel.add(driverLastNameLabel);
        driverTopPanel.add(fieldLastName);
        driverTopPanel.add(driverAgeLabel);
        driverTopPanel.add(fieldAge);
        driverTopPanel.add(driverExperienceLabel);
        driverTopPanel.add(fieldExperience);
        driverTopPanel.add(driverUniqueNumberLabel);
        driverTopPanel.add(fieldUniqueNumber);

        //driver down panel

        driverDownPanel.add(driverAddButton);
        driverDownPanel.add(driverShowAllButton);
        driverDownPanel.add(driverSearchButton);
        driverDownPanel.add(myCombo);
        driverDownPanel.add(driverEditButton);
        driverDownPanel.add(driverDeleteButton);




        //VEHICLE TAB

        vehicleTabPanel.setLayout(new GridLayout(3, 1));
        vehicleTabPanel.add(vehicleTopPanel);
        vehicleTabPanel.add(vehicleDownPanel);
        vehicleTabPanel.add(vehicleTablePanel);

        //vehicle top panel

        vehicleTopPanel.setLayout(new GridLayout(5, 2));
        vehicleTopPanel.add(vehicleBrandLabel);
        vehicleTopPanel.add(fieldBrand);
        vehicleTopPanel.add(vehicleModelLabel);
        vehicleTopPanel.add(fieldModel);
        vehicleTopPanel.add(vehicleProductionYear);
        vehicleTopPanel.add(fieldProductionYear);
        vehicleTopPanel.add(vehicleUniqueID);
        vehicleTopPanel.add(fieldUniqueID);

        //vehicle down panel

        vehicleDownPanel.add(vehicleAddButton);
        vehicleDownPanel.add(vehicleShowAllButton);
        vehicleDownPanel.add(vehicleSearchButton);
        vehicleDownPanel.add(vehicleEditButton);
        vehicleDownPanel.add(vehicleDeleteButton);

        //DRIVER-VEHICLE TAB

        driverVehicleTabPanel.setLayout(new GridLayout(3,1));
        driverVehicleTabPanel.add(driverVehicleTopPanel);
        driverVehicleTabPanel.add(driverVehicleDownPanel);
        driverVehicleTabPanel.add(driverVehicleTablePanel);

        //driver-vehicle top panel
        driverVehicleTopPanel.setLayout(new GridLayout(3,3));
        driverVehicleTopPanel.add(driverIDLabel);
        driverVehicleTopPanel.add(driverIDField);
        driverVehicleTopPanel.add(vehicleIDLabel);
        driverVehicleTopPanel.add(vehicleIDField);

        //driver-vehicle down panel

        driverVehicleDownPanel.add(driverVehicleAddButton);
        driverVehicleDownPanel.add(driverVehicleEditButton);
        driverVehicleDownPanel.add(driverVehicleShowAllButton);
        driverVehicleDownPanel.add(driverVEhicleDeleteButton);



        /*
        buttons part - each button has a new inner Action listener class overriding the actionPerformed method
         */

        //driver button logic

        driverDeleteButton.addActionListener(this);
        driverAddButton.addActionListener(this);
        driverSearchButton.addActionListener(this);
        driverEditButton.addActionListener(this);
        driverShowAllButton.addActionListener(this);


        // Vechicle Button Logic

        vehicleDeleteButton.addActionListener(this);
        vehicleAddButton.addActionListener(this);
        vehicleSearchButton.addActionListener(this);
        vehicleEditButton.addActionListener(this);
        vehicleShowAllButton.addActionListener(this);

        // driver vehicle button logic

        driverVehicleAddButton.addActionListener(this);
        driverVehicleShowAllButton.addActionListener(this);
        driverVehicleEditButton.addActionListener(this);
        driverVEhicleDeleteButton.addActionListener(this);

    driverTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
    driverTable.setFillsViewportHeight(true);

    driverScroller.setPreferredSize(new Dimension(500, 150));
    driverTablePanel.add(driverScroller);


    //VEHICLE SCROLLER AND TABLE
//    vehicleTable = new JTable();
    vehicleTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
    vehicleTable.setFillsViewportHeight(true);

    vehicleScroller.setPreferredSize(new Dimension(500,150));
    vehicleTablePanel.add(vehicleScroller);

    //DRIVER-VEHICLE SCROLLER AND TABLE

//    driverVehicleTable = new JTable();
    driverVehicleTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
    driverVehicleTable.setFillsViewportHeight(true);

    driverVehicleScroller.setPreferredSize(new Dimension(500,150));
    driverVehicleTablePanel.add(driverVehicleScroller);




}
    //
    static void setComboBox(JComboBox jComboBox){
        connection = DBUtility.getConnection();

        try {


            preparedStatement = connection.prepareStatement("SELECT DISTINCT firstName FROM DRIVER ");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                jComboBox.addItem(resultSet.getString("firstName"));

            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // end of constructor

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == driverAddButton){
            String firstName = fieldFirstName.getText();
            String lastName = fieldLastName.getText();
            String age = fieldAge.getText();
            String experience = fieldExperience.getText();
            int uniqueCompanyNumber = Integer.parseInt(fieldUniqueNumber.getText());
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO driver (firstName, lastName, age, experience, uniqueNumber)VALUES(?,?,?,?,?)");
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, age);
                preparedStatement.setString(4, experience);
                preparedStatement.setInt(5, uniqueCompanyNumber);
                preparedStatement.execute();
                setComboBox(myCombo);
                preparedStatement.close();
                connection.close();
//                    DBUtility.refreshTable(driverTable, "driver");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "The user has been added", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(driverTable, "driver");
            } catch (SQLException e1) {
                e1.printStackTrace();
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Please insert number for age/unique number", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }

            fieldFirstName.setText("");
            fieldLastName.setText("");
            fieldAge.setText("");
            fieldExperience.setText("");
            fieldUniqueNumber.setText("");

        }


        if(e.getSource() == driverShowAllButton){
            int selectedIntex = 0;
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM driver");
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    resultSet.getInt("d_id");
                    resultSet.getString("firstName");
                    resultSet.getString("lastName");
                    resultSet.getString("age");
                    resultSet.getString("experience");
                    resultSet.getString("uniqueNumber");

                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                DBUtility.refreshTable(driverTable, "driver");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            driverEditButton.setEnabled(true);
            driverSearchButton.setEnabled(true);

        }
        if(e.getSource() == driverDeleteButton){
            String uniqueNumber = fieldUniqueNumber.getText();
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("DELETE FROM driver WHERE uniqueNumber=?");
                preparedStatement.setString(1, uniqueNumber);
                preparedStatement.execute();
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "The user has been deleted", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(driverTable, "driver");
                DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            fieldFirstName.setText("");
            fieldLastName.setText("");
            fieldAge.setText("");
            fieldExperience.setText("");
            fieldUniqueNumber.setText("");
        }
        if(e.getSource() == driverEditButton){
            String firstName = fieldFirstName.getText();
            String lastName = fieldLastName.getText();
            String age = fieldAge.getText();
            String experience = fieldExperience.getText();
            int uniqueCompanyNumber = Integer.parseInt(fieldUniqueNumber.getText());
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("UPDATE driver SET firstName=?, lastName=?, age=?, experience=?, uniqueNumber=? WHERE d_id=?");
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, age);
                preparedStatement.setString(4, experience);
                preparedStatement.setInt(5, uniqueCompanyNumber);
                preparedStatement.setInt(6, selectedIntex);
                preparedStatement.execute();

                setComboBox(myCombo);

                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "The user has been updated", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(driverTable, "driver");
                DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");

            } catch (SQLException e1) {
                e1.printStackTrace();
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "This unique number has already been used, please try another", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
            driverSearchButton.setEnabled(true);

        }
        if(e.getSource() == driverSearchButton){
            String selection = (String) myCombo.getSelectedItem();
            String lastName = fieldLastName.getText();
            String uniqueCompanyNumber = fieldUniqueNumber.getText();

            connection = DBUtility.getConnection();

            try {
                if(uniqueCompanyNumber != null && !uniqueCompanyNumber.trim().equals("")){
                    preparedStatement = connection.prepareStatement("select * from driver where uniqueNumber=? and age=?");
                    preparedStatement.setString(1, uniqueCompanyNumber);
                    preparedStatement.setString(2, fieldAge.getText());
                    resultSet = preparedStatement.executeQuery();
                }else{
                    preparedStatement = connection.prepareStatement("select * from driver where firstName=? and lastName=?");
                    preparedStatement.setString(1, selection);
                    preparedStatement.setString(2, fieldLastName.getText());
//                    preparedStatement.setString(2, lastName);
//                    preparedStatement.setString(3, fieldExperience.getText());
//                    preparedStatement.setString(4, fieldUniqueNumber.getText());
                    resultSet = preparedStatement.executeQuery();
                }

                while(resultSet.next()){
                    fieldFirstName.setText(resultSet.getString("firstName"));
                    fieldLastName.setText(resultSet.getString("lastName"));
                    fieldAge.setText(resultSet.getString("age"));
                    fieldExperience.setText(resultSet.getString("experience"));
                    fieldUniqueNumber.setText(resultSet.getString("uniqueNumber"));
                    selectedIntex = resultSet.getInt("d_id");
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException e1) {
                //  TODO Auto-generated catch block
                e1.printStackTrace();
            }

            driverEditButton.setEnabled(true);

        }
        if(e.getSource() == vehicleAddButton){
            connection = DBUtility.getConnection();
            try {

                preparedStatement = connection.prepareStatement("INSERT INTO vehicle(brand, model, yearOfProd, uniqueID) VALUES(?,?,?,?)");
                preparedStatement.setString(1, fieldBrand.getText());
                preparedStatement.setString(2, fieldModel.getText());
                preparedStatement.setString(3, fieldProductionYear.getText());
                preparedStatement.setString(4, fieldUniqueID.getText());
                preparedStatement.execute();
                DBUtility.refreshTable(driverTable, "driver");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "The vehicle has been added", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(vehicleTable, "vehicle");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        if(e.getSource() == vehicleShowAllButton){
            int selectedIntex = 0;
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM vehicle");
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    resultSet.getInt("v_id");
                    resultSet.getString("brand");
                    resultSet.getString("model");
                    resultSet.getString("yearOfProd");
                    resultSet.getString("uniqueID");
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                DBUtility.refreshTable(vehicleTable, "vehicle");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            driverEditButton.setEnabled(true);
            driverSearchButton.setEnabled(true);
        }
        if(e.getSource() == vehicleDeleteButton){
            String uniqueNumber = fieldUniqueID.getText();
            connection = DBUtility.getConnection();
            try {

                preparedStatement = connection.prepareStatement("DELETE FROM vehicle WHERE uniqueID=?");
                preparedStatement.setString(1, uniqueNumber);
                preparedStatement.execute();
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "The vehicle has been deleted", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(vehicleTable, "vehicle");
                DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            fieldBrand.setText("");
            fieldModel.setText("");
            fieldProductionYear.setText("");
            fieldUniqueID.setText("");


        }
        if(e.getSource() == vehicleSearchButton){
            //String selection = (String) myCombo.getSelectedItem();
            String firstName = fieldFirstName.getText();
            String lastName = fieldLastName.getText();
            connection = DBUtility.getConnection();

            try {
                if(fieldUniqueID.getText() != null && !fieldUniqueID.getText().trim().equals("")) {
                    preparedStatement = connection.prepareStatement("select * from vehicle where uniqueID=? AND yearOfProd=?");
                    preparedStatement.setString(1, fieldUniqueID.getText());
                    preparedStatement.setString(2, fieldProductionYear.getText());
                    resultSet = preparedStatement.executeQuery();
                }else{
                    preparedStatement = connection.prepareStatement("select * from vehicle where brand=? AND model=?");
                    preparedStatement.setString(1, fieldBrand.getText());
                    preparedStatement.setString(2, fieldModel.getText());
                    resultSet = preparedStatement.executeQuery();
                }
                while(resultSet.next()){
                    fieldBrand.setText(resultSet.getString("brand"));
                    fieldModel.setText(resultSet.getString("model"));
                    fieldProductionYear.setText(resultSet.getString("yearOfProd"));
                    fieldUniqueID.setText(resultSet.getString("uniqueID"));
                    selectedIntex = resultSet.getInt("v_id");
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            vehicleEditButton.setEnabled(true);
        }
        if(e.getSource() == vehicleEditButton){
            String brand = fieldBrand.getText();
            String model = fieldModel.getText();
            String yearOfProd = fieldProductionYear.getText();
            String uniqueID = fieldUniqueID.getText();
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("UPDATE vehicle SET brand=?, model=?, yearOfProd=?, uniqueID=? WHERE v_id=?");
                preparedStatement.setString(1, brand);
                preparedStatement.setString(2, model);
                preparedStatement.setString(3, yearOfProd);
                preparedStatement.setString(4, uniqueID);
                preparedStatement.setInt(5, selectedIntex);
                preparedStatement.execute();

                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "The vehicle has been updated", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(vehicleTable, "vehicle");
                DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        if(e.getSource() == driverVehicleAddButton){
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO driver_vehicle(id_driver, id_vehicle) VALUES(?,?) ");
                preparedStatement.setString(1, driverIDField.getText());
                preparedStatement.setString(2, vehicleIDField.getText());
                preparedStatement.execute();
                resultSet.close();
                preparedStatement.close();
                connection.close();
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "The record has been updated", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");

                DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");
            } catch (SQLException e1) {
                e1.printStackTrace();
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Please insert a valid record", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
        }
        if(e.getSource() == driverVehicleShowAllButton){
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM driver_vehicle");
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    driverIDField.setText(resultSet.getString("id_driver"));
                    vehicleIDField.setText(resultSet.getString("id_vehicle"));

                }
                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (SQLException e1) {
                e1.printStackTrace();

            }
        }
        if(e.getSource() == driverVehicleEditButton){

        }
        if(e.getSource() == driverVEhicleDeleteButton){
            connection = DBUtility.getConnection();
            try {
                preparedStatement = connection.prepareStatement("DELETE FROM driver_vehicle WHERE id_driver=?");
                preparedStatement.setString(1, driverIDField.getText());
                preparedStatement.execute();
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, "Please record has been deleted", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");
                DBUtility.refreshTable(driverTable, "driver");
                DBUtility.refreshTable(vehicleTable, "vehicle");

            } catch (SQLException e1) {
                e1.printStackTrace();

            }

        }

    }

    public static void main(String[] args){

        Company company = new Company();
        company.setVisible(true);
        try {
            DBUtility.refreshTable(driverTable, "driver");
            DBUtility.refreshTable(vehicleTable, "vehicle");
            DBUtility.refreshTable(driverVehicleTable, "driver_vehicle");
        } catch (SQLException e) {
            e.printStackTrace();

        }
        setComboBox(myCombo);
        company.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
