import com.google.gson.Gson;

import java.util.List;

public class FileHandler extends AbstractObserver {
    @Override
    public void notifyObservers() {

    }

    protected Gson saveFile = new Gson();

    protected void writeToFile(ActiveArchivedLists fInput) {
        saveFile.toJson(fInput);
    }

    protected void readFromFile(ActiveArchivedLists fOutput, String ListType) {
        if (ListType.equals("active")) {
            fOutput.active = saveFile.fromJson("active", List.class);
        }
        if (ListType.equals("archived")) {
            fOutput.archived = saveFile.fromJson("archived", List.class);
        }

    }
}
