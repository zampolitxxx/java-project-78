package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private Map<String, Predicate> rules;
    private boolean nullable;

    protected BaseSchema() {
        rules = new HashMap<>();
        nullable = true;
    }

    /**
     *
     * @return BaseSchema object
     */
    protected BaseSchema required() {
        this.nullable = false;
        return this;
    }

    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return nullable;
        }
        return rules.values().stream()
                .allMatch(predicate -> predicate.test(obj));
    }

    public final void addRule(String ruleName, Predicate predicate) {
        this.rules.put(ruleName, predicate);
    }
}
