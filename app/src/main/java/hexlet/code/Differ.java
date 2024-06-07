package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.parser;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }
        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        String fileType1 = getFType(String.valueOf(path1));
        String fileType2 = getFType(String.valueOf(path2));

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        Map<String, Object> map1 = parser(content1, fileType1);
        Map<String, Object> map2 = parser(content2, fileType2);

        List<Map<String, Object>> result = GetDifference.differ(map1, map2);

        return Formatter.formatStyle(result, format);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
    public static String getFType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }
}
