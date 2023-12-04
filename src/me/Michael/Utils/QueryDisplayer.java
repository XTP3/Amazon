package me.Michael.Utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDisplayer {

	public QueryDisplayer(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                List<String[]> rows = new ArrayList<>();

                // Extract column names
                String[] columnNames = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i);
                }
                rows.add(columnNames);

                // Extract data rows
                while (resultSet.next()) {
                    String[] rowData = new String[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = resultSet.getString(i);
                    }
                    rows.add(rowData);
                }

                // Display data
                DataDisplay.displayData(rows);
            } else {
                System.out.println("ResultSet is null.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}