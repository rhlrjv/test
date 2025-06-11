package com.example.tictactoe

import com.example.tictactoe.service.GameService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameServiceTest {
    private lateinit var service: GameService

    @BeforeEach
    fun setup() {
        service = GameService()
    }

    @Test
    fun `new game has empty board`() {
        val game = service.newGame()
        for (row in game.board) {
            assertTrue(row.all { it == ' ' })
        }
    }

    @Test
    fun `play alternates players`() {
        service.newGame()
        service.play(0,0)
        assertEquals('O', service.getGame().next)
        service.play(0,1)
        assertEquals('X', service.getGame().next)
    }

    @Test
    fun `detect win`() {
        service.newGame()
        service.play(0,0) // X
        service.play(1,0) // O
        service.play(0,1) // X
        service.play(1,1) // O
        val finalGame = service.play(0,2) // X wins
        assertEquals('X', finalGame.winner)
    }
}
