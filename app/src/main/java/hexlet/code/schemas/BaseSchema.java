package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private Map<String, Predicate> rules;
    private boolean nullable;

    public BaseSchema() {
        rules = new HashMap<>();
        nullable = true;
    }

    public BaseSchema required() {
        nullable = false;
        return this;
    }

//    public StringSchema minLength(int minLength) {
//        rules.put("minLength", x -> ((String) x).length() >= minLength);
//        return this;
//    }

    public BaseSchema contains(String requiredString) {
        rules.put("isContaine", x -> ((String) x).contains(requiredString));
        return this;
    }

    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return nullable;
        }
        return rules.values().stream()
                .allMatch(predicate -> predicate.test(obj));
    }

    public void addRule(String ruleName, Predicate predicate) {
        this.rules.put(ruleName, predicate);
    }
}
