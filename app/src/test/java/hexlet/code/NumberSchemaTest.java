package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    private NumberSchema schema;
    private Validator v;
    @BeforeEach
    void initializing() {
        v = new Validator();
        schema = v.number();
    }

    @Test
    void requiredSchemaTest() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
    }

    @Test
    void positiveSchemaTest() {
        schema.positive();
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(-10));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(0));
    }

    @Test
    void rangeSchemaTest() {
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(9));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}

