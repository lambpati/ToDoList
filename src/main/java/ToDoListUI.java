import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ToDoListUI {
    private JButton newButton;
    private JButton deleteButton;
    private JTable toDoTable;
    private final JPanel jPanel = new JPanel();
    private final ListManager listManager = new ListManager();
    private final DefaultTableModel model = new DefaultTableModel();
    String[] columnNames = {"Task"};

    public void loadData() {
        listManager.initialPopulate();
        toDoTable.setModel(model);
        model.setColumnIdentifiers(columnNames);
        if (!listManager.getManagedList().getItems().isEmpty()) {
            for (String s : listManager.getManagedList().getItems()) {
                for (int i = 0; i < listManager.getManagedList().getItems().size(); i++) {
                    Object[] o = new Object[listManager.getManagedList().getItems().size()];
                    o[i] = s;
                    model.addRow(o);
                }
            }
        }
        else {
            Object[] o = new Object[0];
            o[0] = "Add new tasks!";
            model.addRow(o);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ToDoListUI");
        frame.setContentPane(new ToDoListUI().jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        ToDoListUI toDoListUI = new ToDoListUI();
        toDoListUI.loadData();

    }
}
