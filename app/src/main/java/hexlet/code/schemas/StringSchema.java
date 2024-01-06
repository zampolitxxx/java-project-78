package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addRule(v -> v == null || v instanceof String);
    }

    @Override
    public StringSchema required() {
        super.addRule(v -> v != null
                && !((String) v).isEmpty()
        );
        return this;
    }

    public StringSchema minLength(int minLength) {
        addRule(v -> v == null || ((String) v).length() >= minLength
        );
        return this;
    }

    public StringSchema contains(String pattern) {
        addRule(v -> v == null || ((String) v).contains(pattern)
        );
        return this;
    }
}
