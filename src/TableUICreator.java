import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class TableUICreator extends JFrame {
    private JTable table;
    private JPanel panel;

    public TableUICreator(String[] colNames, Object[][] data) {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colNames);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setForeground(new Color(0).WHITE);
        table.getTableHeader().setBackground(new Color(0).BLACK);
        table.setForeground(new Color(0).BLACK);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        for (Object[] datum : data) {
            model.addRow(datum);
        }

        add(scroll);
        setSize(900, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void showTable() {
        setVisible(true);
    }

    public static void main(String[] args) {

        String[] colNames = new String[]{"Account", "Transaction Type", "Amount"};
        Object[][] data = new Object[][]{
                {"Checking", "Credit", "500"},
                {"Checking", "Debit", "350"},
                {"Checking", "Debit", "50"}
        };
        TableUICreator atm = new TableUICreator(colNames, data);
        atm.showTable();
    }

}
