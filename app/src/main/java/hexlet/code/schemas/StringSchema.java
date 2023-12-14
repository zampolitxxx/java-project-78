package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super.required();
    }

    @Override
    public StringSchema required() {
        super.addRule(String.class::isInstance);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        addRule(obj -> obj == null
                || obj instanceof String
                && ((String) obj).length() >= minLength
        );

        return this;
    }

    public final StringSchema contains(String pattern) {
        addRule(obj -> obj == null
                || obj instanceof String
                && ((String) obj).contains(pattern)
        );

        return this;
    }
}
