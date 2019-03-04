# bol

The [Spring Boot](https://projects.spring.io/spring-boot/) backend for [mancalive](https://secure-cliffs-35079.herokuapp.com/auth), a realtime mancala experiment.

## TOC
- [Requirements](#requirements)
- [Building the project](#building-the-project)
- [Running the project](#running-the-project)
- [FAQ](#faq)
  * [Frontend code repository](#frontend-code-repository)
- [License](#license)
- [Author](#author)

## Requirements

- Java 1.8+
- Maven 3.x

## Building the project
```bash
mvn package
```

## Running the project
```bash
java -jar target/bol-0.0.1-SNAPSHOT.jar
```

## FAQ

#### Frontend code repository
The project contains the "built" frontend code in `src/main/resources/static`.

The frontend code repository is [here](https://github.com/lifenautjoe/bol-www/).

## License

MIT

## Author

Joel Hernández ([@lifenautjoe](www.lifenautjoe.com))