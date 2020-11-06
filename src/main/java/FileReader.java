import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads initial values from a "save.txt" file on startup, passing the values
 * to the GsonHandler.
 */
public class FileReader {
    private final File file = new File("save.txt");
    private String fInput;

    /**
     * Tries to create a new Scanner and then write all the inputs to the Scanner
     * printing the Stack if the File is not found.
     */
    protected void readFromFile() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                fInput = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String getfInput() {
        return fInput;
    }
}
