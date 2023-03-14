import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("Programmerstasken.txt");
        TestFileWriter testFileWriter = new TestFileWriter();
        TestFileReader testFileReader = new TestFileReader();
        testFileWriter.writeTestFile(file);
        String testFile = testFileReader.readTestFile(file);
        Parser parser = new Parser();
        AnalyticalTool analyticalTool = new AnalyticalTool();
        String[] input = testFile.split(System.getProperty("line.separator"));
        List<WaitingTimeline> waitingTimelines = new ArrayList<>();
        for (String value : input) {
            if (value.startsWith("C")) {
                waitingTimelines.add(parser.parseIntoWaitingTimeline(value));
            }
            if (value.startsWith("D")) {
                String s = analyticalTool.analyzeWaitingTimeLine(waitingTimelines, parser.parseIntoQueryLine(value));
                System.out.println(s);
            }
        }
    }
}