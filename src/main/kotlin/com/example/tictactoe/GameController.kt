package com.example.tictactoe

import com.example.tictactoe.service.GameService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/game")
class GameController(private val service: GameService) {

    @PostMapping
    fun newGame(): GameService.Game = service.newGame()

    @GetMapping
    fun getGame(): GameService.Game = service.getGame()

    @PostMapping("/move")
    fun play(@RequestParam row: Int, @RequestParam col: Int): GameService.Game =
        service.play(row, col)
}
