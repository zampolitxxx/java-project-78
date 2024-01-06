package hexlet.code.schemas;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate<Object>> rules;

    protected BaseSchema() {
        rules = new ArrayList<>();
    }

    /**
     *
     * @return BaseSchema object
     */
    protected BaseSchema required() {
        addRule(v -> v != null);
        return this;
    }

    public final boolean isValid(Object v) {
        return rules.stream()
                .allMatch(x -> x.test(v));
    }

    protected final void addRule(Predicate<Object> predicate) {
        this.rules.add(predicate);
    }
}
