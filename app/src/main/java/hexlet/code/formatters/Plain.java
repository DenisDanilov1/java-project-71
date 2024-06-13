package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Plain {
    public static String formatPlain(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> diffs : differences) {
            String status = diffs.get("status").toString();
            switch (status) {
                case "removed" -> result.append("Property ").append("'")
                        .append(diffs.get("key")).append("'").append(" was removed").append("\n");
                case "added" -> result.append("Property ").append(complexValue(diffs.get("key")))
                        .append(" was added with value: ")
                        .append(complexValue(diffs.get("newValue")))
                        .append("\n");
                case "updated" ->
                        result.append("Property ").append(complexValue(diffs.get("key")))
                                .append(" was updated. From ")
                                .append(complexValue(diffs.get("oldValue"))).append(" to ")
                                .append(complexValue(diffs.get("newValue")))
                                .append("\n");
                case "unchanged" -> result.append("");
                default -> throw new RuntimeException("Unknown status: " + status);
            }
        }
        return result.toString().trim();
    }

    public static String complexValue(Object data) {
        if (data == null) {
            return null;
        } else if (data instanceof Object[] || data instanceof Collections || data instanceof Map
                || data instanceof ArrayList<?>) {
            return "[complex value]";
        } else if (data instanceof String) {
            return "'" + data + "'";
        }
        return data.toString();
    }
}
