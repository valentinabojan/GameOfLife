import cgk.workshop.gameoflife.Game;
import cgk.workshop.gameoflife.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResurrectionTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void givenANewGame_WhenACellIsResurrected_ThenItResurrects() {
        Cell cell = new Cell(3, 2);

        game.resurrectCell(cell);

        assertThat(game.isAlive(cell)).isTrue();
    }

    @Test
    public void givenANewGame_WhenTwoCellsAreResurrected_ThenTheyResurrect() {
        Cell cell1 = new Cell(3, 2);
        Cell cell2 = new Cell(4, 2);

        game.resurrectCell(cell1);
        game.resurrectCell(cell2);

        assertThat(game.isAlive(cell1)).isTrue();
        assertThat(game.isAlive(cell2)).isTrue();
    }
}
