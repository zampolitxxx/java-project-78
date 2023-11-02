package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapTest {
    private MapSchema schema;
    private Validator v;

    @BeforeEach
    void initializing() {
        v = new Validator();
        schema = v.map();
    }

    @Test
    void nullTest() {
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    void newMapTest() {
        assertTrue(schema.isValid(new HashMap()));
    }

    @Test
    void sizeofTest() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
}
