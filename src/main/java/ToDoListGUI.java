import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * Creates the GUI for the ToDoList
 */
public class ToDoListGUI extends JFrame implements Runnable{
    String[] columnNames = {"Task", "Date added"};
    private JButton newButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTextField textField1;
    private JCheckBox checkBox1;
    private JTextPane textPane1;

    private ListManager listManager;

    public void addNewCheckbox(){
        if(newButton.isSelected()){

        }
    }


    @Override
    public void run() {

    }
}
