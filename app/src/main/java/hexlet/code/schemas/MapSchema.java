package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addRule(v -> v == null || v instanceof Map);
    }

    public BaseSchema required() {
        return super.required();
    }

    public MapSchema sizeof(Integer size) {
        addRule(v -> v == null || ((Map) v).size() == size
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema schema = entry.getValue();

            addRule(v -> v == null || schema.isValid(((Map) v).get(key))
            );
        }
        return this;
    }
}
