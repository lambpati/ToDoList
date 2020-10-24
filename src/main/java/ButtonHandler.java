import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ButtonHandler {
    protected ArrayList<String> currentValues;
    protected ArrayList<String> archivedValues;
    private boolean addButton;
    private boolean deleteButton;
    private boolean editButton;
    private ObserveValues observeValues;


    protected void initializeGUI() throws FileNotFoundException {
        observeValues.update("current", currentValues);
        observeValues.update("archive", archivedValues);
    }

}
