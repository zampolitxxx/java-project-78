package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StrSchemaTest {
    private StringSchema schema;
    private Validator v;
    @BeforeEach
    void initializing() {
        v = new Validator();
        schema = v.string();
    }

    @Test
    void nullSchemaTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    void containsSchemaTest() {
        schema.contains("what");
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("wha does the fox say"));
    }

    @Test
    void minLengthSchemaTest() {
        assertTrue(schema.isValid("what does the fox say"));
        schema.minLength(6);
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid("what"));
        assertTrue(schema.isValid("what does the fox say"));
    }

}
