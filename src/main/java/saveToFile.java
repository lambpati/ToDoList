import com.google.gson.Gson;

public class saveToFile implements Observer {
    private final Gson saveFile = new Gson();
    protected ToDoList list = new ToDoList();

    protected void writeToFile(ToDoList fInput) {
        saveFile.toJson(fInput);
    }


    @Override
    public void notifyObservers() {
        writeToFile(list);
    }
}
