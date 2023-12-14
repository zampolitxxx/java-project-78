package hexlet.code.schemas;

//import hexlet.code.schemas.BaseSchema;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super.required();
    }

    @Override
    public BaseSchema required() {
        super.addRule(Integer.class::isInstance);
        return this;
    }

    public NumberSchema positive() {
        addRule(obj -> obj == null
                || obj instanceof Number
                && (int) obj > 0
        );
        return this;
    }

    public NumberSchema range(int startRange, int endRange) {
        addRule(obj -> obj == null
                || obj instanceof Number
                && (int) obj >= startRange
                && (int) obj <= endRange
        );
        return this;
    }

}
