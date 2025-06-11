package com.example.tictactoe.service

import org.springframework.stereotype.Service

@Service
class GameService {
    data class Game(
        val board: Array<CharArray> = Array(3) { CharArray(3) { ' ' } },
        var next: Char = 'X',
        var winner: Char? = null
    )

    private var game: Game = Game()

    fun newGame(): Game {
        game = Game()
        return game
    }

    fun getGame(): Game = game

    fun play(row: Int, col: Int): Game {
        require(row in 0..2 && col in 0..2) { "Invalid position" }
        if (game.winner != null) return game
        if (game.board[row][col] != ' ') return game
        game.board[row][col] = game.next
        if (checkWin(game.next)) {
            game.winner = game.next
        } else if (game.board.all { r -> r.all { it != ' ' } }) {
            game.winner = 'D' // draw
        } else {
            game.next = if (game.next == 'X') 'O' else 'X'
        }
        return game
    }

    private fun checkWin(player: Char): Boolean {
        val b = game.board
        return (0..2).any { i ->
            (b[i][0] == player && b[i][1] == player && b[i][2] == player) ||
            (b[0][i] == player && b[1][i] == player && b[2][i] == player)
        } ||
            (b[0][0] == player && b[1][1] == player && b[2][2] == player) ||
            (b[0][2] == player && b[1][1] == player && b[2][0] == player)
    }
}
