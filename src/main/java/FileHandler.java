import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    protected File saveFile;
    protected void checkFile(String saveLocation){
        saveFile = new File(saveLocation);
        try {
            if (saveFile.exists()) {
                System.out.println("Save file exists... loading save file.");
            } else {
                saveFile.createNewFile();
                System.out.println("Creating new save file.");
            }
        }
        catch(IOException e){
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }
    protected void writeToFile(List<String> fInput) throws IOException {
       FileWriter writer = new FileWriter(saveFile, true);
        writer.write(fInput + System.lineSeparator());
        writer.close();
    }
    protected void readFromFile(List<String> fOutput) throws FileNotFoundException {
        Scanner reader = new Scanner(saveFile);
        while(reader.hasNextLine()){
            fOutput.add(reader.nextLine());
        }
        reader.close();
    }
}
