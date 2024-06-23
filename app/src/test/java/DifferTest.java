import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @ParameterizedTest
    @ValueSource(strings = {"json", "yaml"})
    public void generateTest(String format) throws Exception {
        String flatFilePath1 = getFixturePath("file1." + format).toString();
        String flatFilePath2 = getFixturePath("file2." + format).toString();
        assertThat(Differ.generate(flatFilePath1, flatFilePath2)).isEqualTo(resultStylish);

        String filePath1 = getFixturePath("fileComplex1." + format).toString();
        String filePath2 = getFixturePath("fileComplex2." + format).toString();
        assertThat(Differ.generate(filePath1, filePath2)).isEqualTo(resultComplexStylish);
        assertThat(Differ.generate(filePath1, filePath2, "stylish")).isEqualTo(resultComplexStylish);
        assertThat(Differ.generate(filePath1, filePath2, "plain")).isEqualTo(resultPlain);
        assertThat(Differ.generate(filePath1, filePath2, "json")).isEqualTo(resultJson);
    }
}
