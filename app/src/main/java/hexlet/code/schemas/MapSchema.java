package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        super.required();
    }

    @Override
    public MapSchema required() {
        addRule(obj -> obj instanceof Map);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        addRule(obj -> obj == null
                || obj instanceof Map
                && ((Map) obj).size() == size
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema schema = entry.getValue();

            addRule(obj -> obj == null
                    || obj instanceof Map
                    && schema.isValid(((Map) obj).get(key))
            );
        }

        return this;
    }
}
