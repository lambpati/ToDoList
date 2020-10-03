import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
FileHandler handler = new FileHandler();

    @org.junit.jupiter.api.Test
    void checkFile() {
        handler.checkFile("testValues.txt");
        assertTrue(handler.saveFile.exists());
        assertSame("testValues.txt", handler.saveFile.getPath());
    }

    @org.junit.jupiter.api.Test
    ArrayList<String> writeToFile() throws IOException {
        checkFile();
        ArrayList<String> testString = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            testString.add("Hello World Count" + i);

        }
        handler.writeToFile(testString);
        assertTrue(handler.saveFile.canWrite());
        return testString;
    }

    @org.junit.jupiter.api.Test
    void readFromFile() throws IOException {
        ArrayList<String> testOutput = new ArrayList<>();
        writeToFile();
        handler.readFromFile(testOutput);
        assertFalse(testOutput.isEmpty());
    }
}