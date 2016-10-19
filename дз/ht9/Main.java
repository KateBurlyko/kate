package ht9;

import java.io.File;
import java.io.IOException;

/**
 * entry point of program
 */
public class Main {

    /**
     * find all files and derectoris in current directory
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String currentDir = new File(".").getAbsolutePath();
        File f = new File(currentDir);
        File[] listOfFiles = f.listFiles();
        String row = "";
        long size = 0;
        String fileName = "table.html";
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (File directoryItem : listOfFiles) {
            FileInfo fi = new FileInfo();
            row = "<tr bgcolor=" + fi.color() + "><td>" + directoryItem.getName() +
                    "</td><td>" + fi.typeInfo(directoryItem) + "</td>" +
                    "<td>" + fi.dateFormat(directoryItem) + "</td><td>" + fi.convert(size) + "</td>";
            HtmlFile hf = new HtmlFile();
            hf.htmlFile(row, file);
        }
    }
}
