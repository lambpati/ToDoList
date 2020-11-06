import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Listens for a change from ListManager to
 * update the Json file to save values.
 */
public class FileHandler implements Observer {
    private final Gson saveFile = new Gson();
    private final Type deserializationType = new TypeToken<ToDoList>() {
    }.getType();
    private ToDoList list = new ToDoList();
    private String fOutput;
    /**
     * Writes to Json file from ToDoList fInput
     */
    protected void writeToFile(ToDoList fInput) {
        fOutput = saveFile.toJson(fInput);
    }

    protected void readFromFile() {
        try {
            list = saveFile.fromJson(fOutput, deserializationType);
        } catch (Exception e) {
            System.out.println("Empty list!");
        }
    }

    protected ToDoList getList() {
        return list;
    }

    protected String getfOutput() {
        return fOutput;
    }


    /**
     * Following being notified, it will write to a Json file
     */
    @Override
    public void notifyObservers() {
        writeToFile(list);
    }
}
