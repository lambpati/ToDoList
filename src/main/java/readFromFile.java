import com.google.gson.Gson;

/**
 * Upon startup, this class reads the saved values from the file
 */
public class readFromFile {
    private final Gson saveFile = new Gson();

    /**The Json values for the ToDoList is passed to the ButtonHandler list initially */
    protected void readFromFile(ToDoList lists) {
//        lists = saveFile.fromJson(lists, ToDoList.class);

    }
}
