import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * parse the txt files
 */
public class FileParser {
    public static List<List<String>> parseFile(String filename) {
        List<List<String>> list = new ArrayList<>();
        try {
            InputStream resourceAsStream = FileParser.class.getClassLoader().getResourceAsStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String s;
            reader.readLine();
            while ((s = reader.readLine()) != null) {
                if (s.isEmpty()) {
                    continue;
                }
                String[] data = s.split("\\s+");
                list.add(Arrays.asList(data));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }


}
