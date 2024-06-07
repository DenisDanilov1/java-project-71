package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> differences) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> node : differences) {
            switch (node.get("status").toString()) {
                case "removed" -> result.append("  - ").
                                append(node.get("key")).
                                append(": ").
                                append(node.get("oldValue")).
                                append("\n");
                case "added" -> result.append("  + ").
                        append(node.get("key")).
                        append(": ").
                        append(node.get("newValue")).
                        append("\n");
                case "unchanged" -> result.append("    ").
                        append(node.get("key")).
                        append(": ").
                        append(node.get("oldValue")).
                        append("\n");
                default -> {
                    result.append("  - ").
                            append(node.get("key")).
                            append(": ").
                            append(node.get("oldValue")).
                            append("\n");
                    result.append("  + ").
                            append(node.get("key")).
                            append(": ").
                            append(node.get("newValue")).
                            append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
