import com.google.gson.Gson;

public class FileHandler extends AbstractObserver {
    protected ActiveArchivedLists lists = new ActiveArchivedLists();
    private final Gson saveFile = new Gson();

    @Override
    public void notifyObservers() {

    }


    protected void writeToFile(ToDoList fInput) {
        saveFile.toJson(fInput);
    }

    protected void readFromFile(String ListType) {
        if (ListType.equals("active")) {
            lists.active = saveFile.fromJson(String.valueOf(lists.active), ToDoList.class);
        }
        if (ListType.equals("archived")) {
            lists.archived = saveFile.fromJson("archived", ToDoList.class);
        }

    }
}
