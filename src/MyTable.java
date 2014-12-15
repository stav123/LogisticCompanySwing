import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class MyTable extends AbstractTableModel{

    ResultSet result = null;
    ArrayList arr = new ArrayList();
    int columnCount = 0;
    int rowCount = 0;
    String[] columnNames;


    public MyTable(ResultSet r){
        try{
            convertRS(r);

        }
            catch(SQLException e){
                e.printStackTrace();
            }
    }

        public void convertRS(ResultSet r) throws SQLException{
        this.result = r;
        ResultSetMetaData metaData = result.getMetaData();
        columnCount = metaData.getColumnCount();
        columnNames = new String[columnCount];

        while(result.next()){
            Object[] row = new Object[columnCount];
            for(int i = 0; i<columnCount;i++){
                row[i] = result.getObject(i+1);
                columnNames[i] = metaData.getColumnName(i+1);
            }
            arr.add(row);
            rowCount++;
        }
    }


    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnCount;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return rowCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
            Object[] row = (Object[]) arr.get(rowIndex);
            return row[colIndex];
    }

    public String getColumnName(int colIndex){
        return columnNames[colIndex];
    }

}
