package hexlet.code;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
    }

    @Override
    public MapSchema required() {
        super.required();
        super.addRule("required", Map.class::isInstance);
        return this;
    }

    public void sizeof(Integer size) {
        Predicate<Map<Object, Object>> predicate = (x -> x.size() == size);
        this.addRule("mapSize", predicate);
    }
}
