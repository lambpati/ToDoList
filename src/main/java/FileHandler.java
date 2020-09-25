import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileHandler {

    private File saveFile = new File("saveFile.txt");

    protected void checkFile()  throws IOException{
        if (saveFile.exists()) {
            System.out.println("Save file exists... loading save file.");
        } else {
            System.out.println("Creating new save file.");
            throw new IOException("Something went wrong. Sorry about that.");
        }
    }
    protected void writeToFile(List<String> fInput) throws IOException {
       FileWriter writer = new FileWriter("saveFile.txt", true);
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
