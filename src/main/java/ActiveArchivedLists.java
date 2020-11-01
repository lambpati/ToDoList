import java.util.ArrayList;
import java.util.List;

public class ActiveArchivedLists {
    List<ToDoList> active;
    List<ToDoList> archived;

    public ActiveArchivedLists() {
        active = new ArrayList<>();
        archived = new ArrayList<>();
    }
}
