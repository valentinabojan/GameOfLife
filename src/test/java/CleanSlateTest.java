import cgk.workshop.gameoflife.Game;
import cgk.workshop.gameoflife.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CleanSlateTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void givenANewGame_AllCellsAreDead() {
        Cell cell = new Cell(3, 2);

        assertThat(game.isAlive(cell)).isFalse();
    }

    @Test
    public void givenANewGame_AllCellsAreDeadWithNegativeCell() {
        Cell cell = new Cell(-5, 12);

        assertThat(game.isAlive(cell)).isFalse();
    }
}
