import com.google.gson.Gson;

/**
 * Listens for a change from ButtonHandler to
 * update the Json file to save values.
 */
public class saveToFile implements Observer {
    private final Gson saveFile = new Gson();
    protected ToDoList list = new ToDoList();

    /** Writes to Json file from ToDoList fInput */
    protected void writeToFile(ToDoList fInput) {
        saveFile.toJson(fInput);
    }

    @Override
    /** Following being notified, it will write to a Json file */
    public void notifyObservers() {
        writeToFile(list);
    }
}
