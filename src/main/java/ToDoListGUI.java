import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * Creates the GUI for the ToDoList
 */
public class ToDoListGUI {
    String[] columnNames = {"Task", "Date added"};
    private JTabbedPane tabbedPane1;
    private JTable archivedTable;
    private JTable currentTable;
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTextField textField1;
    private JButton archiveButton;
    private JTextPane textPane1;

    private ListManager listManager;

    private void SetupTables() throws FileNotFoundException {
//        listManager.initializeGUI();
//        ArrayList<String> currentValues = listManager.currentValues;
        String[] columnNames = {"Task", "Date Added"};
//        DefaultTableModel defaultCurrent = new DefaultTableModel(currentValues.toArray(), columnNames);
    }

}
