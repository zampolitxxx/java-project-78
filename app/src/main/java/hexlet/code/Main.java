package hexlet.code;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema schema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        System.out.println(schemas);
    }
}
