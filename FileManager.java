import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public String[] readFileToStringArray(String path) throws FileNotFoundException {
        ArrayList<String> fileLines = new ArrayList<String>();
        Scanner sc = new Scanner(new File(path));
        while (sc.hasNextLine())
            fileLines.add(sc.nextLine());
        sc.close();
        return fileLines.toArray(new String[fileLines.size()]);
    }

    public void writeFileFromStringArray(String[] dataToWrite) throws IOException {
        FileWriter writer = new FileWriter("./exp_postfijas.txt");
        for (String str : dataToWrite) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

}
