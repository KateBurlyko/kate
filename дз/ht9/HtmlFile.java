package ht9;

import java.io.*;


/**
 * create html file and write information about file in it
 */
public class HtmlFile {

    /**
     * create html file and write in it information about directory item
     *
     * @param row - strind with information about file(size, creation data, type)
     */
    public void htmlFile(String row, File file) throws FileNotFoundException {
        String HEAD = "<html><head> <meta charset=\"utf-8\"><title>Тег table</title>\\n\" +\n" +
                "\"  <style>\\n\" +\n" +
                " \"   table {\\n\" +\n" +
                " \"    width: 520px;\\n\" +\n" +
                " \"    background: white;\\n\" +\n" +
                " \"    color: black;\\n\" +\n" +
                " \"    border-spacing: 1px;\\n\" +\n" +
                " \"\\tfont-family: sans-serif;\\n\" +\n" +
                "  \"   }\\n\" +<body><table ><tr bgcolor=\"cecfce\">" +
                "<th>ИМЯ</th>" +
                "<th>ТИП</th>" +
                "<th>ДАТА СОЗДАНИЯ</th>" +
                "<th>РАЗМЕР (в kb)</th>" +
                "</tr>";
        String FOOT = "</table>" +
                "</body>" +
                "</html>";
        PrintWriter writer = null;


        PrintWriter out = new PrintWriter(file.getAbsoluteFile());

        try {
            writer = new PrintWriter(file, "UTF-8");
            writer.write(HEAD);
            writer.write(row);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.write(FOOT);
            writer.close();
        }
    }
}
