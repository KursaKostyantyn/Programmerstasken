import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public  void writeTestFile(File file){

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write("7");
            writer.append('\n');
            writer.append("C 1.1 8.15.1 P 15.10.2012 83");
            writer.append('\n');
            writer.append("C 1 10.1 P 01.12.2012 65");
            writer.append('\n');
            writer.append("C 1.1 5.5.1 P 01.11.2012 117");
            writer.append('\n');
            writer.append("D 1.1 8 P 01.01.2012-01.12.2012");
            writer.append('\n');
            writer.append("C 3 10.2 N 02.10.2012 100");
            writer.append('\n');
            writer.append("D 1 * P 8.10.2012-20.11.2012");
            writer.append('\n');
            writer.append("D 3 10 P 01.12.2012");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
