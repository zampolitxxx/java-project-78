package hexlet.code.schemas;

//import hexlet.code.schemas.BaseSchema;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addRule(v -> v == null || v instanceof Integer);
    }

    public BaseSchema required() {
        return super.required();
    }

    public NumberSchema positive() {
        addRule(v -> v == null || (int) v > 0
        );
        return this;
    }

    public NumberSchema range(int startRange, int endRange) {
        addRule(v -> v == null
                || (int) v >= startRange
                && (int) v <= endRange
        );
        return this;
    }

}
