import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Start point of the program
 */
public class Main {

    /**
     * run the test commands
     *
     * @param args - arguments from command line
     */
    public static void main(String[] args) {
        ArrayList<String> linne = new ArrayList<>();

        TxtReader readerTxt = new TxtReader();
        readerTxt.readTxt(linne);

        if (linne.isEmpty()) {
            try {
                XmlReader readerXml = new XmlReader();
                readerXml.readCommand(linne);
            } catch (Exception e) {
                System.out.println("input commands");
            }
        }

        if (linne.isEmpty()) {
            CmdReader cmd = new CmdReader();
            cmd.readCmd(linne);
        }
        try {
            CommandGetting parser = new CommandGetting();
            SiteTest s = new SiteTest();
            System.setErr(new PrintStream(new File("log.txt")));
            double start = System.currentTimeMillis();
            for (int i = 0; i < linne.size(); i++) {
                if (parser.parseOperation(linne.get(i)).equals("open")) {
                    String url = parser.parseOpenUrl(linne.get(i));
                    String timeGiven = parser.parseOpenTime(linne.get(i));
                    s.testURL(url, timeGiven);
                }
                if (parser.parseOperation(linne.get(i)).equals("checkPageTitle")) {
                    String title = parser.parseArg(linne.get(i));
                    s.pageTitle(title);
                }
                if (parser.parseOperation(linne.get(i)).equals("checkPageContains")) {
                    String text = parser.parseArg(linne.get(i));
                    s.containPage(text);
                }
            }
            double finish = System.currentTimeMillis();
            Log log = new Log();
            log.getAllTests(linne.size());
            log.getPassedFailed(linne.size(), s.getFail());
            log.getTotalTime(start, finish);
            log.getAverageTime(start, finish, linne.size());
        } catch (Exception e) {
            System.out.println("");
        }
    }
}
