# TicTacToe Spring Boot Example

This project provides a simple REST API to play Tic Tac Toe built with Spring Boot and Kotlin.

## Building

```bash
./gradlew build
```

## Running

```bash
./gradlew bootRun
```

The API exposes the following endpoints:

- `POST /game` - start a new game
- `GET /game` - get the current game state
- `POST /game/move?row=0&col=0` - play a move

## Testing

Run unit tests with:

```bash
./gradlew test
```
