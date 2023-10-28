package Bank.sql;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Search extends JFrame {
    private JTable table;

    public Search(String user) {
        setTitle("Your Balance History");
        //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Create a JPanel to hold the JTable
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        // Fetch data from the database and populate the JTable
        try {
            String FullQ = new String();
            FullQ = "SELECT * FROM "+user;
            Connection conn = connection.connect();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(FullQ);

            // Create a table model to hold the data
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            Object[][] data = new Object[100][columnCount];  // Assuming a maximum of 100 rows
            int rowCount = 0;
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    data[rowCount][i - 1] = resultSet.getObject(i);
                }
                rowCount++;
            }

            // Create the JTable
            table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String user) {
        SwingUtilities.invokeLater(() -> {
            Search sr = new Search(user);
            sr.setVisible(true);
        });
    }
}
