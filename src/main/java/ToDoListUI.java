import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileNotFoundException;

public class ToDoListUI {
    private final JButton newButton = new JButton("New");
    private JButton deleteButton = new JButton("Delete");
    private JTable toDoTable = new JTable();
    private final JPanel panel = new JPanel(new GridLayoutManager(500,500));
    private final ListManager listManager = new ListManager();
    private final DefaultTableModel model = new DefaultTableModel();
    String[] columnNames = {"Task"};

    public static void main(String[] args) {
        JFrame frame = new JFrame("ToDoListUI");
        frame.setContentPane(new ToDoListUI().panel);
        frame.setSize(5,5);
        ToDoListUI toDoListUI = new ToDoListUI();
        toDoListUI.loadData();
        toDoListUI.setupUI();
        frame.add(toDoListUI.panel, new com.intellij.uiDesigner.core.GridConstraints());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
    public void setupUI(){
        panel.setVisible(true);

        newButton.setVisible(true);

        deleteButton.setVisible(true);

        model.setColumnIdentifiers(columnNames);
        toDoTable.setModel(model);
        toDoTable.setVisible(true);

        panel.add(deleteButton, new com.intellij.uiDesigner.core.GridConstraints());
        panel.add(newButton, new com.intellij.uiDesigner.core.GridConstraints());
        panel.add(toDoTable, new com.intellij.uiDesigner.core.GridConstraints());
    }

    public void loadData() {
        try {
            listManager.initialPopulate();
            for (String s : listManager.getManagedList().getItems()) {
                for (int i = 0; i < listManager.getManagedList().getItems().size(); i++) {
                    Object[] o = new Object[listManager.getManagedList().getItems().size()];
                    o[i] = s;
                    model.addRow(o);
                }
            }
        } catch (NullPointerException e) {
                System.out.println("No data loaded!");
                Object[] o = new Object[1];
                o[0] = "Add new items!";
                model.addRow(o);
        }

    }
}
