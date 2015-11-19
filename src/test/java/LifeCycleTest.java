import cgk.workshop.gameoflife.Game;
import cgk.workshop.gameoflife.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LifeCycleTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void givenALiveCellWithNoNeighbor_WhenAGenerationPasses_CellDies(){
        game.resurrectCell(new Cell(3, 2));

        game.passGeneration();

        assertThat(game.isAlive(new Cell(3, 2))).isFalse();
    }

    @Test
    public void givenALiveCellWithOneAliveNeighbor_WhenAGenerationPasses_CellDies(){
        game.resurrectCell(new Cell(3, 2));
        game.resurrectCell(new Cell(3, 3));

        game.passGeneration();

        assertThat(game.isAlive(new Cell(3, 2))).isFalse();
        assertThat(game.isAlive(new Cell(3, 3))).isFalse();
    }

    @Test
    public void givenALiveCellWithTwoAliveNeighbor_WhenAGenerationPasses_CellDies(){
        game.resurrectCell(new Cell(2, 2));
        game.resurrectCell(new Cell(2, 1));
        game.resurrectCell(new Cell(2, 3));

        game.passGeneration();

        assertThat(game.isAlive(new Cell(2, 2))).isTrue();
        assertThat(game.isAlive(new Cell(2, 1))).isFalse();
        assertThat(game.isAlive(new Cell(2, 3))).isFalse();
    }
}
