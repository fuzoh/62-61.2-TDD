package ch.hearc.bnd.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    private TableauAffichage display;
    private Game game;

    @BeforeEach
    void setUp() {
        display = mock(TableauAffichage.class);
        game = new Game(display);
    }

    @Test
    void new_GivenGameCreation_ShouldConnectToDisplay() {
        verify(display, times(1));
    }

}
