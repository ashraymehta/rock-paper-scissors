# Rock Paper Scissors

Rock Paper Scissors is a small java application to play the popular game of [Rock Paper and Scissors](https://en.wikipedia.org/wiki/Rock-paper-scissors).

## Build

Use the following command to build the project:

```bash
./gradlew clean build
```

This command will also run all the tests.

#### Note

This project uses Java 11. Please make sure Java 11 is available on the build environment.


## Run

Use the following command to start the application:
```
java -jar ./build/libs/rock-paper-scissors.jar
```

#### Note

The command will only work after a successful `build` or `assemble` task. If you wish to run the application without building you may use `./gradlew clean run` instead.