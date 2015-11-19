package cgk.workshop.gameoflife;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private Set<Cell> cells = new HashSet<>();

    public void resurrectCell(Cell cell) {
        cells.add(cell);
    }

    public Boolean isAlive(Cell cell){
        return cells.contains(cell);
    }

    public void passGeneration() {
        Set<Cell> toRemove = new HashSet<>();
        Set<Cell> toResurrect = new HashSet<>();

        for(Cell cell : cells){
            int aliveNeighbors = getAliveNeighborsNumber(cell);
            if(aliveNeighbors < 2 || aliveNeighbors > 3)
                toRemove.add(cell);

            toResurrect.addAll(getDeadCellsThatWillRessurect(cell));
        }

        cells.removeAll(toRemove);
        cells.addAll(toResurrect);
    }

    private int getAliveNeighborsNumber(Cell cell){
        int count = 0;

        for (int i = cell.getX() - 1; i <= cell.getX() + 1; i++)
            for (int j = cell.getY() - 1; j <= cell.getY() + 1; j++)
                if(i != cell.getX() || j !=  cell.getY())
                    count += isAlive(new Cell(i, j)) ? 1 : 0;

        return count;
    }

    private Set<Cell> getDeadCellsThatWillRessurect(Cell cell){
        Set<Cell> toAlive = new HashSet<>();

        for (int i = cell.getX() - 1; i <= cell.getX() + 1; i++)
            for (int j = cell.getY() - 1; j <= cell.getY() + 1; j++)
                if(i != cell.getX() || j !=  cell.getY()) {
                    Cell neighbor = new Cell(i, j);
                    if(!isAlive(neighbor) && getAliveNeighborsNumber(neighbor) == 3)
                            toAlive.add(neighbor);
                }

        return toAlive;
    }
}
