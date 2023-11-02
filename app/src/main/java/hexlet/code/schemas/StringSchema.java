package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema required() {
        super.required();
        super.addRule("required", String.class::isInstance);
        return this;
    }

    public StringSchema minLength(int minLength) {
        super.addRule("minLength", x -> ((String) x).length() >= minLength);
        return this;
    }

    public StringSchema contains(String requiredString) {
        super.addRule("contains", x -> ((String) x).contains(requiredString));
        return this;
    }
}
