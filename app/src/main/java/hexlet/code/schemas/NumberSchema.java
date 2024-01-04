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
        addRule(obj -> obj == null
                || obj instanceof Integer
                && (int) obj > 0
        );
        return this;
    }

    public NumberSchema range(int startRange, int endRange) {
        addRule(obj -> obj == null
                || obj instanceof Integer
                && (int) obj >= startRange
                && (int) obj <= endRange
        );
        return this;
    }

}
