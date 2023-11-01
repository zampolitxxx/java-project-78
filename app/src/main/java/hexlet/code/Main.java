package hexlet.code;


public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        NumberSchema n = new NumberSchema();
        System.out.println(n.isValid(null));
        n.required();
        System.out.println(n.isValid(null));
        System.out.println(n.isValid(5));
//        StringSchema schema = v.string();
//        System.out.println(schema.isValid(""));
//        schema.required();
//        System.out.println(schema.isValid(null));
//        System.out.println(schema.isValid("5"));
//        System.out.println(schema.contains("zhe").isValid("what the fox say"));
//        System.out.println(schema.contains("wh").isValid("what the fox say"));
//        System.out.println(schema.contains("whe").isValid("what the fox say"));
//        System.out.println(schema.isValid("what the fox say"));


    }
}
