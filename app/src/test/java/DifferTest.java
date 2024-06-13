import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;
    private static String resultComplexStylish;

    public DifferTest() throws IOException {
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName).toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("resultJson");
        resultPlain = readFixture("resultPlain");
        resultStylish = readFixture("resultStylish");
        resultComplexStylish = readFixture("resultComplexStylish");
    }

    @Test
    public void testDefault1() throws Exception {
        String expected = resultStylish;
        assertEquals(expected, Differ.generate(getFixturePath("file1.json").toString(),getFixturePath("file2.json").toString()));
    }
    @Test
    public void testDefault2() throws Exception {
        String expected = resultComplexStylish;
        assertEquals(expected, Differ.generate(getFixturePath("fileComplex1.json").toString(),getFixturePath("fileComplex2.json").toString()));
    }
    @Test
    public void testStylish1() throws Exception {
        String expected = resultStylish;
        assertEquals(expected, Differ.generate(getFixturePath("file1.json").toString(),getFixturePath("file2.json").toString(), "stylish"));
    }

    @Test
    public void testStylish2() throws Exception {
        String expected = resultComplexStylish;
        assertEquals(expected, Differ.generate(getFixturePath("fileComplex1.json").toString(),getFixturePath("fileComplex2.json").toString(),"stylish"));
    }

    @Test
    public void testPlain1() throws Exception {
        String expected = resultPlain;
        assertEquals(expected, Differ.generate(getFixturePath("fileComplex1.json").toString(),getFixturePath("fileComplex2.json").toString(), "plain"));
    }

    @Test
    public void testPlain2() throws Exception {
        String expected = resultPlain;
        assertEquals(expected, Differ.generate(getFixturePath("fileComplex1.yaml").toString(),getFixturePath("fileComplex2.yaml").toString(), "plain"));
    }

    @Test
    public void testJson1() throws Exception {
        String expected = resultJson;
        assertEquals(expected, Differ.generate(getFixturePath("fileComplex1.json").toString(),getFixturePath("fileComplex2.json").toString(), "json"));
    }

    @Test
    public void testJson2() throws Exception {
        String expected = resultJson;
        assertEquals(expected, Differ.generate(getFixturePath("fileComplex1.yaml").toString(),getFixturePath("fileComplex2.yaml").toString(),"json"));
    }
}
