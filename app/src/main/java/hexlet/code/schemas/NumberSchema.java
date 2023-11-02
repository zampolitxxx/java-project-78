package hexlet.code.schemas;

import hexlet.code.schemas.BaseSchema;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
    }

    @Override
    public BaseSchema required() {
        super.required();
        super.addRule("required1", Integer.class::isInstance);
        return this;
    }

    public BaseSchema positive() {
        this.addRule("positive", obj ->
            obj == null || obj instanceof Integer integer && integer > 0);
        return this;
    }

    public BaseSchema range(int min, int max) {
        this.addRule("range", obj ->
                obj == null || obj instanceof Integer integer && (min < integer && integer < max));
        return this;
    }
}
