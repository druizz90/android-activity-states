package com.example.states

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculateIndexTest {
    @Test
    fun calculatePreviousIndex_1() {
        val teamIndex = 0
        val teamsSize = 4
        val expected = 3
        val actual = calculatePreviousIndex(teamIndex, teamsSize)
        assertEquals(expected, actual)
    }

    @Test
    fun calculatePreviousIndex_2() {
        val teamIndex = 3
        val teamsSize = 4
        val expected = 2
        val actual = calculatePreviousIndex(teamIndex, teamsSize)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateNextIndex_1() {
        val teamIndex = 0
        val teamsSize = 4
        val expected = 1
        val actual = calculateNextIndex(teamIndex, teamsSize)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateNextIndex_2() {
        val teamIndex = 3
        val teamsSize = 4
        val expected = 0
        val actual = calculateNextIndex(teamIndex, teamsSize)
        assertEquals(expected, actual)
    }
}