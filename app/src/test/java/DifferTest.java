import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final String path1 = "src/test/resources/file1.json";
    private final String path2 = "src/test/resources/file2.json";
    private final String path3 = "src/test/resources/fileComplex1.json";
    private final String path4 = "src/test/resources/fileComplex2.json";
    private final String path5 = "src/test/resources/fileComplex1.yaml";
    private final String path6 = "src/test/resources/fileComplex2.yaml";

    private final Path pathStylish1 =
            Paths.get("src/test/resources/expected/testStylish").toAbsolutePath().normalize();
    private final Path pathStylish2 =
            Paths.get("src/test/resources/expected/testComplexStylish").toAbsolutePath().normalize();
    private final Path pathPlain =
            Paths.get("src/test/resources/expected/testPlain").toAbsolutePath().normalize();
    private final Path pathJson =
            Paths.get("src/test/resources/expected/testJson").toAbsolutePath().normalize();


    public DifferTest() throws IOException {
    }

    @Test
    public void test1() throws Exception {
        String expected = Files.readString(pathStylish1);
        assertEquals(expected, Differ.generate(path1, path2));
    }

    @Test
    public void testStylish1() throws Exception {
        String expected = Files.readString(pathStylish1);
        assertEquals(expected, Differ.generate(path1, path2, "stylish"));
    }

    @Test
    public void testStylish2() throws Exception {
        String expected = Files.readString(pathStylish2);
        assertEquals(expected, Differ.generate(path3, path4, "stylish"));
    }

    @Test
    public void testPlain1() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path3, path4, "plain"));
    }

    @Test
    public void testPlain2() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(path5, path6, "plain"));
    }

    @Test
    public void testJson1() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path3, path4, "json"));
    }

    @Test
    public void testJson2() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(path5, path6, "json"));
    }
}
