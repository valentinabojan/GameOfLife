import cgk.workshop.gameoflife.Game;
import cgk.workshop.gameoflife.Cell;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Earth2070Test {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void givenALiveCellWithEightAliveNeighbor_WhenAGenerationPasses_CellDies(){
        game.resurrectCell(new Cell(2, 2));
        game.resurrectCell(new Cell(1, 1));
        game.resurrectCell(new Cell(1, 2));
        game.resurrectCell(new Cell(1, 3));
        game.resurrectCell(new Cell(2, 1));
        game.resurrectCell(new Cell(2, 3));
        game.resurrectCell(new Cell(3, 1));
        game.resurrectCell(new Cell(3, 2));
        game.resurrectCell(new Cell(3, 3));

        game.passGeneration();

        assertThat(game.isAlive(new Cell(1, 1))).isTrue();
        assertThat(game.isAlive(new Cell(1, 2))).isFalse();
        assertThat(game.isAlive(new Cell(1, 3))).isTrue();
        assertThat(game.isAlive(new Cell(2, 1))).isFalse();
        assertThat(game.isAlive(new Cell(2, 2))).isFalse();
        assertThat(game.isAlive(new Cell(2, 3))).isFalse();
        assertThat(game.isAlive(new Cell(3, 1))).isTrue();
        assertThat(game.isAlive(new Cell(3, 2))).isFalse();
        assertThat(game.isAlive(new Cell(3, 3))).isTrue();
    }
}
