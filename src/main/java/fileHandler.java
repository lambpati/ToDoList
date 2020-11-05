import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Listens for a change from ButtonHandler to
 * update the Json file to save values.
 */
public class fileHandler implements Observer {
    private final Gson saveFile = new Gson();
    protected ToDoList list = new ToDoList();
    private final Type deserializationType = new TypeToken<List<ToDoList>>() {
    }.getType();
    private String fOutput;

    /**
     * Writes to Json file from ToDoList fInput
     */
    protected void writeToFile(ToDoList fInput) {
        fOutput = saveFile.toJson(fInput);
    }

    protected void readFromFile() {
        saveFile.fromJson(fOutput, deserializationType);
    }

    protected String getfOutput() {
        return fOutput;
    }


    @Override
    /** Following being notified, it will write to a Json file */
    public void notifyObservers() {
        writeToFile(list);
    }
}
