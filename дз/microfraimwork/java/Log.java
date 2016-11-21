/**
 * write information about tests in file log.txt
 */
public class Log {

    /**
     * write the result of tests and run-time in file
     *
     * @param result  - !-fail test, + passed test
     * @param command execution command
     * @param stOpen  satrt time for command
     * @param finOpen finish time for command
     */
    public void getCommandTime(String result, String command, double stOpen, double finOpen) {
        double time = (finOpen - stOpen);
        int i = (int) Math.round(time);
        time = (double) i / 1000;
        System.err.println(result + command + " " + time);
    }

    /**
     * write in file total number of tests
     *
     * @param allTests number of total tests
     */
    public void getAllTests(int allTests) {
        System.err.println("Total tests: " + allTests);
    }

    /**
     * write in file number of passed and failed tests
     *
     * @param allTests number of total tests
     * @param fail     number of failed tests
     */
    public void getPassedFailed(int allTests, int fail) {
        System.err.println("Passed/Failed: " + (allTests - fail) + "/" + fail);
    }

    /**
     * write in file total time
     *
     * @param st  start time of all tests
     * @param fin finish time of all tests
     */
    public void getTotalTime(double st, double fin) {
        double time = (fin - st) / 1000;
        System.err.format("Total time: " + "%.3f", time);
    }

    /**
     * write average time in file
     *
     * @param st        start time of all tests
     * @param fin       finish time of all tests
     * @param totalTest
     */
    public void getAverageTime(double st, double fin, int totalTest) {
        double averageTime = (fin - st) / (totalTest * 1000);
        System.err.format("\nAverage time: " + "%.3f", averageTime);
    }
}
