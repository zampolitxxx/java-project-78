### Hexlet tests and linter status:
[![Actions Status](https://github.com/zampolitxxx/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/zampolitxxx/java-project-78/actions)
### Codeclimate maintainability status:
[![Maintainability](https://api.codeclimate.com/v1/badges/e2c9084e56d52e9808b3/maintainability)](https://codeclimate.com/github/zampolitxxx/java-project-78/maintainability)
### Codeclimate test coverage status:
<a href="https://codeclimate.com/github/zampolitxxx/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/e2c9084e56d52e9808b3/test_coverage" /></a>

Валидатор данных – библиотека, с помощью которой можно проверять корректность любых данных. Подобных библиотек множество в каждом языке, так как практически все программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями.

### Поддерживаемые форматы
1) String
2) Numbers
3) Map

### Использование:
1) Подготовка библиотеки:

1.1) Клонируем репозиторий командой

git clone https://github.com/zampolitxxx/java-project-78

1.2) Переходим в директорию app и создаем jar файл:
$ cd app
$ gradle build
Файл будет находится в директории java-project-78/app/build/libs/
или просто скачиваем jar-файл из репозитория
2) Запускаем jshell и импортируем библиотеку:
   $ jshell --class-path app-1.0-SNAPSHOT.jar
   jshell> import hexlet.code.*
   jshell> var v = new Validator();

3) Используем для строк:

jshell> var schema = v.string();
jshell> schema.isValid("");         //true
jshell> schema.required();
jshell> schema.isValid("what does the fox say");    //true
jshell> schema.minLength(7);
jshell> schema.isValid("hexlet");   //false
jshell> schema.isValid("hexlettt");   //true

4) Используем для чисел:

// Пока не вызван метод required(), null считается валидным
jshell> schema.isValid(null); // true
jshell> schema.positive().isValid(null); // true

jshell> schema.required();

jshell> schema.isValid(null); // false
jshell> schema.isValid("5"); // false
jshell> schema.isValid(10); // true

// Потому что ранее мы вызвали метод positive()
jshell> schema.isValid(-10); // false
//  Ноль — не положительное число
jshell> schema.isValid(0); // false

jshell> schema.range(5, 10);

jshell> schema.isValid(5); // true
jshell> schema.isValid(10); // true
jshell> schema.isValid(4); // false
jshell> schema.isValid(11); // false

5) Используем для map:

jshell> MapSchema schema = v.map();
schema.isValid(null); // true

schema.required();

jshell> schema.isValid(null); // false
jshell> schema.isValid(new HashMap()); // true
jshell> Map<String, String> data = new HashMap<>();
jshell> data.put("key1", "value1");
jshell> schema.isValid(data); // true

jshell> schema.sizeof(2);

jshell> schema.isValid(data);  // false
jshell> data.put("key2", "value2");
jshell> schema.isValid(data); // true