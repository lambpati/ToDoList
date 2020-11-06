import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests that given an item's description and priority, the ToDoList can add, remove and clear
 * items from the list.
 */
class ToDoListTest {
    ToDoList testList = new ToDoList();
    ToDoItem item = new ToDoItem();

    /**
     * Creates a general Item with priority 0 and a description of "String at
     * priority 0".
     */
    void setItem() {
        item.setPriority(0);
        item.setDescription("String at priority 0");
    }

    /**
     * Uses the set item to add to a testList instance of a ToDoList and then asserts
     * that the original item's description and testList's item's description match.
     */
    @Test
    void addItem() {
        setItem();
        testList.addItem(item);
        assertEquals(testList.getItems().get(0), item.getDescription());
    }

    /**
     * Adds the general Item to a list and them removes it,
     * testing that the testList removed the item and is now empty.
     */
    @Test
    void removeItem() {
        addItem();
        testList.removeItem(item);
        assertTrue(testList.getItems().isEmpty());
    }

    /**
     * Adds the general Item to a list and then clears the list,
     * testing that the testList is empty.
     */
    @Test
    void clear() {
        addItem();
        testList.clear();
        assertTrue(testList.getItems().isEmpty());
    }
}