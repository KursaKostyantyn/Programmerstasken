import java.io.*;

public class TestFileReader {
    public  String readTestFile(File file){
        StringBuilder stringBuilder=new StringBuilder();
        String separator=System.getProperty("line.separator");
        try (FileReader fileReader=new FileReader(file)){
            BufferedReader reader=new BufferedReader(fileReader);
            String line=reader.readLine();
            while (line!=null){
                stringBuilder.append(line);
                stringBuilder.append(separator);
                line= reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
