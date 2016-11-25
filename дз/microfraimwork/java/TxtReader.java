import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Read the txt file
 */
public class TxtReader {
    private final String PATH = ".\\data.txt";

    /**
     * read the txt file and write command in arrayList
     *
     * @param linne - ArrayList for writing commands
     * @return ArrayList with all commands from txt file
     */
    public ArrayList<String> readTxt(ArrayList<String> linne) {
        try {
            Path path = Paths.get(PATH);
            BufferedReader br = Files.newBufferedReader(path);
            String line;
            while ((line = br.readLine()) != null) {
                linne.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println();
        }
        return linne;
    }
}
