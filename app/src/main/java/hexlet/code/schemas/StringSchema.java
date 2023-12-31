package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
    }

    @Override
    public StringSchema required() {
        super.addRule(obj -> obj instanceof String
                && !((String) obj).isEmpty()
        );
        return this;
    }

    public StringSchema minLength(int minLength) {
        addRule(obj -> (obj == null
                || obj instanceof String)
                && ((String) obj).length() >= minLength
        );
        return this;
    }

    public StringSchema contains(String pattern) {
        addRule(obj -> obj == null
                || obj instanceof String
                && ((String) obj).contains(pattern)
        );

        return this;
    }
}
