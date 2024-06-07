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

    private final Path pathStylish1 =
            Paths.get("src/test/resources/expected/testStylish").toAbsolutePath().normalize();
    private final Path pathStylish2 =
            Paths.get("src/test/resources/expected/testComplexStylish").toAbsolutePath().normalize();

    public DifferTest() throws IOException {
    }

    @Test
    public void test1() throws Exception {
        String expected = Files.readString(pathStylish1);
        assertEquals(expected, Differ.generate(path1, path2, "stylish"));
    }
    @Test
    public void test2() throws Exception {
        String expected = Files.readString(pathStylish2);
        assertEquals(expected, Differ.generate(path3, path4, "stylish"));
    }
}
