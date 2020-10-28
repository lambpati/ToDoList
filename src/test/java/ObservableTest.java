import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ObservableTest {
    Observable observable = new Observable();

    //Make new arrays of TestValues
    ArrayList<String> currentTestValues = new ArrayList<>(10);
    ArrayList<String> archivedTestValues = new ArrayList<>(10);

    @Test
    void checkIfChanged() throws IOException {
        for (int i = 0; i < 9; i++) {
            currentTestValues.add("Current Test Value " + i);
            archivedTestValues.add("Archived Test Value " + i);
        }
        //Set the buttonHandler values to the TestValues
        observable.buttonHandler.currentValues = currentTestValues;
        observable.buttonHandler.archivedValues = archivedTestValues;

        observable.checkIfChanged(currentTestValues,archivedTestValues);

        //Check that the values have not changed
        assertEquals(observable.buttonHandler.currentValues,currentTestValues);
        assertEquals(observable.buttonHandler.archivedValues, archivedTestValues);

        //Change buttonHandlerValues
        for (int i = 0; i < 3; i++) {
            observable.buttonHandler.currentValues.add("Added current value " + i);
            observable.buttonHandler.archivedValues.add("Added archived value " + i);
        }

        observable.checkIfChanged(currentTestValues,archivedTestValues);

        //Check that values have changed
        assertNotEquals(observable.buttonHandler.currentValues.iterator(), currentTestValues.iterator());
        assertNotEquals(observable.buttonHandler.archivedValues.iterator(), archivedTestValues.iterator());


    }
}