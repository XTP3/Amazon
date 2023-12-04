package me.Michael.Utils;

import java.util.List;

public class DataDisplay {

    /*public static void displayData(List<String[]> rows) {
        if(rows.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }

        // Find maximum length for each column
        int columnCount = rows.get(0).length;
        int[] columnWidths = new int[columnCount];

        for(String[] row : rows) {
            for (int i = 0; i < columnCount; i++) {
                columnWidths[i] = Math.max(columnWidths[i], row[i].length());
            }
        }

        // Display data
        for(String[] row : rows) {
            for(int i = 0; i < columnCount; i++) {
                String cell = row[i];
                System.out.print(padRight(cell, columnWidths[i] + 2)); // Add 2 for padding
            }
            System.out.println();
        }
    }*/

    // Helper function to pad strings to the right with spaces
    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    
    public static void displayData(List<String[]> rows) {
        if (rows.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }

        // Find maximum length for each column
        int columnCount = rows.get(0).length;
        int[] columnWidths = new int[columnCount];

        // Calculate column widths
        for (String[] row : rows) {
            for (int i = 0; i < columnCount; i++) {
                if (row[i] != null) {
                    columnWidths[i] = Math.max(columnWidths[i], row[i].length());
                }
            }
        }

        // Display data
        for (String[] row : rows) {
            for (int i = 0; i < columnCount; i++) {
                String cell = (row[i] != null) ? row[i] : ""; // Handle null values
                System.out.print(padRight(cell, columnWidths[i] + 2) + "|"); // Add separator
            }
            System.out.println();
            
            // Print horizontal line after headers
            if (row == rows.get(0)) {
                for (int i = 0; i < columnCount; i++) {
                    for (int j = 0; j < columnWidths[i] + 2; j++) {
                        System.out.print("-");
                    }
                    System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    
    /*
     * List<String[]> data = new ArrayList<>();
		data.add(new String[]{"Name", "Age", "City"});
	    data.add(new String[]{"Alice", "25", "New York"});
	    data.add(new String[]{"Bob", "30", "San Francisco"});
	    data.add(new String[]{"Charlie", "22", "Seattle"});
	       
	    DataDisplay.displayData(data);
     * */
}