package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
    }

    @Override
    public BaseSchema required() {
        return super.required();
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
