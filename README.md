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

`git clone https://github.com/zampolitxxx/java-project-78`

1.2) Переходим в директорию app и создаем jar файл:
```
$ cd app
$ gradle build
```
Файл будет находится в директории java-project-78/app/build/libs/
или просто скачиваем jar-файл из репозитория
2) Запускаем jshell и импортируем библиотеку:
```
$ jshell --class-path app-1.0-SNAPSHOT.jar
jshell> import hexlet.code.*
```
