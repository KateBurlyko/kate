/**
 * parse commands from arraylist
 */
public class CommandGetting {

    /**
     * delete quotes from command
     *
     * @param line - command from file
     * @return comand without quotes
     */
    public String line_2(String line) {
        String newLine = "";
        char k = '"';
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != k) {
                newLine += line.charAt(i);
            }
        }
        return newLine;
    }

    /**
     * select operation from command
     *
     * @param line command
     * @return executed operation
     */
    public String parseOperation(String line) {
        String operation = line.split("\\s+")[0];
        return operation;
    }

    /**
     * take url from line
     *
     * @param line command
     * @return line with url
     */
    public String parseOpenUrl(String line) {
        return line_2(line).split("\\s+")[1];
    }

    /**
     * take time from line
     *
     * @param line command
     * @return line with time
     */
    public String parseOpenTime(String line) {
        return line_2(line).split("\\s+")[2];
    }

    /**
     * choose commands argument
     *
     * @param line command
     * @return commands argument
     */
    public String parseArg(String line) {
        String[] strLine = new String[1];
        strLine[0] = line_2(line).split("\\s+")[0];
        String comm = "";
        if (line_2(line).contains(strLine[0])) {
            comm = line_2(line).replaceAll(strLine[0], "");
        }
        if (comm.contains(" ")) {
            comm = comm.replaceFirst(" ", "");
        }
        return comm;
    }
}
