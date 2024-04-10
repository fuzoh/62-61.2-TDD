package ch.hearc.bnd.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
