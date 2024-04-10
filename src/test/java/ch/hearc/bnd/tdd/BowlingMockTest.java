package ch.hearc.bnd.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class BowlingMockTest {

    private TableauAffichage display;
    private Bowling bowlingGame;

    @BeforeEach
    void setUp() {
        display = mock(TableauAffichage.class);
        bowlingGame = new Bowling(display);
    }

    @Test
    void Game_GivenGameCreation_ShouldConnectToDisplay() {
        verify(display, times(1)).seConnecter();
    }

    @Test
    void Game_GivenSpare_ShouldNotifyDisplay() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.score();
        verify(display, times(1)).showSpare();
    }

    @Test
    void Game_GivenFirstStrike_ShouldNotifyDisplayPremier() {
        bowlingGame.roll(10);
        bowlingGame.score();
        verify(display, times(1)).showStrike(TableauAffichage.StrikeSerie.PREMIER);
    }

    @Test
    void Game_GivenSecondStrike_ShouldNotifyDisplaySecond() {
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.score();
        verify(display, times(1)).showStrike(TableauAffichage.StrikeSerie.SECOND);
    }

    @Test
    void Game_GivenThirdStrike_ShouldNotifyDisplayTroisiemeEtPlus() {
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.score();
        verify(display, times(1)).showStrike(TableauAffichage.StrikeSerie.TROISIEME_ET_PLUS);
    }

    @Test
    void Game_GivenEndGameWithLowerScore_ShouldGetBestScores() {
        when(display.bestScores()).thenReturn(List.of(20)); // simulate only 0 in best scores
        bowlingGame.endGame();
        verify(display, times(1)).bestScores();
    }

        @Test
    void Game_GivenEndGameWithUpperScore_ShouldGetBestScoresAndUpdate() {
        when(display.bestScores()).thenReturn(List.of(0)); // simulate only 0 in best scores
        bowlingGame.roll(10);
        bowlingGame.endGame();
        verify(display, times(1)).bestScores();
        verify(display, times(1)).updateBestScores(10);
    }

}
