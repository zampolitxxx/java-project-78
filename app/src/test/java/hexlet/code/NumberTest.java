package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberTest {
    private NumberSchema schema;
    private Validator v;
    @BeforeEach
    void initializing() {
        v = new Validator();
        schema = v.number();
    }

    @Test
    void requiredTest() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("5"));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
    }

    @Test
    void positiveTest() {
        assertTrue(schema.positive().isValid(null));
        schema.required();
        assertFalse(schema.positive().isValid(-10));
        assertFalse(schema.positive().isValid(0));
    }

    @Test
    void rangeTest() {
        assertTrue(schema.range(5, 10).isValid(6));
        assertTrue(schema.isValid(7));
        assertTrue(schema.isValid(9));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}

