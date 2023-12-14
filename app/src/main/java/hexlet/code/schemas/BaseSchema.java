package hexlet.code.schemas;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate<Object>> rules;
    private boolean nullable;

    protected BaseSchema() {
        rules = new ArrayList<>();
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
        for (Predicate<Object> pr : rules) {
            if (!pr.test(obj)) {
                return false;
            }
        }
        return true;
    }

    protected final void addRule(Predicate<Object> predicate) {
        this.rules.add(predicate);
    }
}
