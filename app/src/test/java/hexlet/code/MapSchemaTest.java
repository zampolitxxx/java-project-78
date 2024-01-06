package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {
    private MapSchema schema;
    private Validator v;

    @BeforeEach
    void initializing() {
        v = new Validator();
        schema = v.map();
    }

    @Test
    void nullSchemaTest() {
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void sizeofSchemaTest() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        schema.sizeof(2);
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    void shapeSchemaTest() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);
        assertTrue(schema.isValid(null));
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));
    }
}
