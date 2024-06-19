package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Map<String, Object> map1 = getData(filepath1);
        Map<String, Object> map2 = getData(filepath2);

        List<Map<String, Object>> result = GetDifference.differ(map1, map2);

        return Formatter.formatStyle(result, format);
    }

    private static Path getFullPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName).toAbsolutePath().normalize();
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    private static Map<String, Object> getData(String filePath) throws Exception {
        Path fullPath = getFullPath(filePath);

        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }

        String content = Files.readString(fullPath);
        String dataFormat = getDataFormat(filePath);

        return Parser.parser(content, dataFormat);
    }

    public static String getDataFormat(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }
}
