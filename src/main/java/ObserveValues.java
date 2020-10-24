import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ObserveValues {
    private FileHandler fileHandler;

    protected void update(String location, ArrayList<String> listValues) throws FileNotFoundException {
        if (location.equals("current")) {
            fileHandler.checkFile("currentFile.txt");
            fileHandler.readFromFile(listValues);
        }
        if (location.equals("archive")) {
            fileHandler.checkFile("archiveFile.txt");
            fileHandler.readFromFile(listValues);
        }

    }
}
