import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Simple test to test GsonHandler by writing values to a file and reading values from the file,
 * testing FileReader.java by extension.
 */
class GsonHandlerTest {
    GsonHandler handler = new GsonHandler();
    ToDoItem item = new ToDoItem();
    ToDoList test = new ToDoList();
    File file = new File("save.txt");

    /**
     * Creates a simple list of "Active item: " + the current iteration value
     * for values from 0-10 and then adds them to a list and notifies subscribers of
     * changes.
     */
    void createListValues() {
        for (int i = 0; i < 10; i++) {
            item.setDescription("Active item: " + i);
            item.setPriority(i);
//            System.out.println(item.getDescription());
//            System.out.println(item.getPriority());
            test.addItem(item);
            test.notifySubscribers();
        }
    }

    /**
     * Writes precreated values to the Gson and save file
     * and then asserts that the written values contain the items written to it.
     */
    @Test
    void writeToFile() {
        createListValues();
        handler.writeToFile(test);
//        System.out.println(handler.getfOutput());
        assertTrue(handler.getfOutput().contains(item.getDescription()));
    }

    /**
     * Tests both readFromFile() in GsonHandler along with FileReader by extension
     * by writing to file, then reading from the file and testing to make sure the items
     * in the original list match the ouput list and the list written to file.
     * and then deletes it to ensure that tested values are not in the actual list.
     */
    @Test
    void readFromFile() {
        handler.readFromFile();
        writeToFile();
        handler.readFromFile();
//        System.out.println(handler.getList().getItems());
        assertEquals(handler.getList().getItems(), test.getItems());
        file.delete();
    }
}