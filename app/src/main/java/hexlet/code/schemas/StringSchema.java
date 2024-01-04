package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addRule(v -> v == null || v instanceof String);
    }

    @Override
    public StringSchema required() {
        super.addRule(obj -> obj != null
                && !((String) obj).isEmpty()
        );
        return this;
    }

    public StringSchema minLength(int minLength) {
        addRule(obj -> ((String) obj).length() >= minLength
        );
        return this;
    }

    public StringSchema contains(String pattern) {
        addRule(obj -> ((String) obj).contains(pattern)
        );
        return this;
    }
}
