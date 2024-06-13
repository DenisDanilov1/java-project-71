package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parser(String data, String dataType) throws IOException {
        ObjectMapper objectmapper = chooseFormat(dataType);
        return objectmapper.readValue(data, new TypeReference<>() { });
    }

    private static ObjectMapper chooseFormat(String dataType) {
        return "json".equals(dataType) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
