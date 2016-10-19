package ht9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

/**
 * get size, creation date, type ot files
 */
public class FileInfo {

    /**
     * @param directoryItem - file or directory in current directory
     * @return date ot creation of file
     * @throws IOException
     */
    public String dateFormat(File directoryItem) throws IOException {
        BasicFileAttributes attr = Files.readAttributes(Paths.get(directoryItem.getCanonicalPath()), BasicFileAttributes.class);
        FileTime date = attr.creationTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd.yyyy");
        String creationDate = simpleDateFormat.format(date.toMillis());
        return creationDate;
    }

    /**
     * determinate file is file or file of directory
     *
     * @param directoryItem file or directory in current directory
     * @return type of file
     */
    public String typeInfo(File directoryItem) {
        String row1 = "";
        if (directoryItem.isDirectory()) {

            row1 += "DIR";
        }
        if (directoryItem.isFile()) {
            row1 += "FILE";
        }
        return row1;
    }

    /**
     * specifies the color of bar table
     *
     * @return color of bar table
     */
    public String color() {
        String COLOR1 = "#efefef";
        String COLOR2 = "#f7f7f7";
        String COLOR = "#efefef";
        if (COLOR.equals(COLOR1))

        {
            return COLOR2;
        } else

        {
            return COLOR1;
        }
    }

    /**
     * specifies zise of item
     *
     * @param f current directory
     * @return size of item
     * @throws IOException
     */
    public long sizeDir(File f) throws IOException {
        File[] listOfFiles = f.listFiles();
        long size = 0;
        File dir = new File(String.valueOf(f));
        File[] listOfFile = dir.listFiles();
        for (File item : listOfFile) {
            if (item.isDirectory()) {
                size += sizeDir(listOfFile, item.getPath());
            }
            if (item.isFile()) {
                size += item.length();
            }
        }
        return size;
    }

    /**
     * specifaes size of folder
     *
     * @param directoryItem file or directory in current directory
     * @return size of file
     */
    public long sizeFile(File directoryItem) {
        long size = directoryItem.length();
        return size;
    }

    /**
     * convert size to kb
     *
     * @param size - size of directory
     * @return converted size
     */
    public long convert(long size) {
        if (size == 0) {
            return 0;
        }
        if (size < 1024) {
            return 1;
        } else {
            return size / 1024;
        }
    }
}
