import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * read file
 */
public class ReadFile {

    /**
     * read file and input string in arraylist
     *
     * @param koord arraylist with value of string from file
     */
    public static void readFile(ArrayList koord) {
        ArrayList<String> koor = koord;
        try {
            File file = new File("C:\\Users\\Janek\\Desktop\\test.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while ((line != null)) {

                koor.add(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}