import java.util.Objects;

public class Cell {

    private int x;

    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cell next(Direction direction) {
        int newX = this.x + direction.getDeltaX();
        int newY = this.y + direction.getDeltaY();
        return new Cell(newX >= Game.WIDTH ? 0 : newX < 0 ? Game.WIDTH - 1 : newX,
                        newY >= Game.HEIGHT ? 0 : newY < 0 ? Game.HEIGHT - 1 : newY);
    }

    @Override
    public String toString() {
        return "[" + x + "/" + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}