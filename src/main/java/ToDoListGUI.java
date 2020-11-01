import javax.swing.*;
import java.io.FileNotFoundException;

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

    private ButtonHandler buttonHandler;

    private void SetupTables() throws FileNotFoundException {
//        buttonHandler.initializeGUI();
//        ArrayList<String> currentValues = buttonHandler.currentValues;
        String[] columnNames = {"Task", "Date Added"};
//        DefaultTableModel defaultCurrent = new DefaultTableModel(currentValues.toArray(), columnNames);
    }

}
