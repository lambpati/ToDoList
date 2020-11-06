import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Listens for a change from ListManager to
 * update the Json file to save values.
 */
public class GsonHandler implements Observer {
    private final Gson gson = new Gson();
    private final Type deserializationType = new TypeToken<ToDoList>() {
    }.getType();
    private final FileReader fileHandler = new FileReader();
    private final File file = new File("save.txt");
    protected ToDoList list = new ToDoList();
    private String fOutput;

    public GsonHandler() {
        //Leave Empty
    }

    /**
     * Writes to Json file from ToDoList fInput
     */
    protected void writeToFile(ToDoList fInput) {
        try {
            fOutput = gson.toJson(fInput);
            FileWriter fileWriter = new FileWriter(file.getName());
            fileWriter.write(gson.toJson(fInput));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fOutput = gson.toJson(fInput);
    }

    /**
     * Reads from a Json file to a ToDoList
     * and prints out "Empty List!" if the saveFile's list
     * was found to be empty
     */
    protected void readFromFile() {
        try {
            fileHandler.readFromFile();
            list = gson.fromJson(fileHandler.getfInput(), deserializationType);
        } catch (Exception e) {
            System.out.println("Empty list!");
        }
    }

    /**
     * Gets the list created in GsonHandler
     */
    protected ToDoList getList() {
        return list;
    }

    /**
     * Gets the string output from the Json
     */
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
