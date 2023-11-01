package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema {
    private static Map<String, Predicate> rules;
    private static boolean nullable;

    public StringSchema() {
        rules = new HashMap<>();
        rules.put("required", String.class::isInstance);
        StringSchema.nullable = true;
    }

    public void required() {
        StringSchema.nullable = false;
    }

//    public StringSchema minLength(int minLength) {
//        rules.put("minLength", x -> ((String) x).length() >= minLength);
//        return this;
//    }

    public StringSchema contains(String requiredString) {
        rules.put("isContaine", x -> ((String) x).contains(requiredString));
        return this;
    }
    public boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return nullable;
        }
        return rules.values().stream()
                .allMatch(predicate -> predicate.test(obj));
    }
}
