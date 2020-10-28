import java.io.IOException;
import java.util.ArrayList;

public class Observable {
     ButtonHandler buttonHandler = new ButtonHandler();
     FileHandler fileHandler = new FileHandler();

    protected void checkIfChanged(ArrayList<String> currentValues, ArrayList<String> archivedValues) throws IOException {
        if (buttonHandler.currentValues != currentValues) {
            fileHandler.checkFile("currentFile.txt");
            fileHandler.writeToFile(currentValues);
            notifyAll();
        }
        if (buttonHandler.archivedValues != archivedValues) {
            fileHandler.checkFile("archiveFile.txt");
            fileHandler.writeToFile(archivedValues);
            notifyAll();
        }

    }
}
