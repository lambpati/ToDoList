import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ToDoListUI {
    private final JButton newButton = new JButton();
    private JButton deleteButton;
    private JTable toDoTable;
    private final JPanel panel = new JPanel();
    private final ListManager listManager = new ListManager();
    private final DefaultTableModel model = new DefaultTableModel();
    String[] columnNames = {"Task"};

    public static void main(String[] args) {
        JFrame frame = new JFrame("ToDoListUI");
        frame.setContentPane(new ToDoListUI().panel);
        ToDoListUI toDoListUI = new ToDoListUI();
        toDoListUI.loadData();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public void loadData() {
        System.out.println(panel.isValid());
        panel.setVisible(true);
        panel.add(newButton);
        newButton.setVisible(true);
        try {
            listManager.initialPopulate();
            for (String s : listManager.getManagedList().getItems()) {
                for (int i = 0; i < listManager.getManagedList().getItems().size(); i++) {
                    Object[] o = new Object[listManager.getManagedList().getItems().size()];
                    o[i] = s;
                    model.addRow(o);
                }
            }
            toDoTable.setModel(model);
            model.setColumnIdentifiers(columnNames);
        } catch (NullPointerException e) {
            System.out.println("No data loaded!");
        }
//        jPanel.add(toDoTable);

    }
}
