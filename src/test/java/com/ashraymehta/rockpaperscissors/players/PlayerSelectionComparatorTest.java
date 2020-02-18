package com.ashraymehta.rockpaperscissors.players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PlayerSelectionComparatorTest {

    private PlayerSelectionComparator playerSelectionComparator;

    @BeforeEach
    void setUp() {
        playerSelectionComparator = new PlayerSelectionComparator();
    }

    @Test
    void shouldCompareRockAndScissors() {
        assertThat(playerSelectionComparator.compare(PlayerSelection.ROCK, PlayerSelection.SCISSORS), is(1));
        assertThat(playerSelectionComparator.compare(PlayerSelection.SCISSORS, PlayerSelection.ROCK), is(-1));
    }

    @Test
    void shouldCompareRockAndPaper() {
        assertThat(playerSelectionComparator.compare(PlayerSelection.PAPER, PlayerSelection.ROCK), is(1));
        assertThat(playerSelectionComparator.compare(PlayerSelection.ROCK, PlayerSelection.PAPER), is(-1));
    }

    @Test
    void shouldCompareScissorsAndPaper() {
        assertThat(playerSelectionComparator.compare(PlayerSelection.SCISSORS, PlayerSelection.PAPER), is(1));
        assertThat(playerSelectionComparator.compare(PlayerSelection.PAPER, PlayerSelection.SCISSORS), is(-1));
    }
}