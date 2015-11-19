import cgk.workshop.gameoflife.Game;
import cgk.workshop.gameoflife.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSomeTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void givenADeadCellWithThreeAliveNeighbor_WhenAGenerationPasses_CellAlive(){
        game.resurrectCell(new Cell(1, 1));
        game.resurrectCell(new Cell(1, 2));
        game.resurrectCell(new Cell(2, 1));

        game.passGeneration();

        assertThat(game.isAlive(new Cell(1, 1))).isTrue();
        assertThat(game.isAlive(new Cell(1, 2))).isTrue();
        assertThat(game.isAlive(new Cell(1, 3))).isFalse();
        assertThat(game.isAlive(new Cell(2, 1))).isTrue();
        assertThat(game.isAlive(new Cell(2, 2))).isTrue();
        assertThat(game.isAlive(new Cell(2, 3))).isFalse();
        assertThat(game.isAlive(new Cell(3, 1))).isFalse();
        assertThat(game.isAlive(new Cell(3, 2))).isFalse();
        assertThat(game.isAlive(new Cell(3, 3))).isFalse();
    }

}
