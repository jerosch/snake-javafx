import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private Cell position;

    private Direction direction = Direction.RIGHT;

    private int length = 5;

    private Deque<Cell> tail = new ArrayDeque<Cell>();

    public Snake(Cell position) {
        this.position = position;
    }

    public void grow() {
        length += 1;
    }

    public void move() {
        tail.addLast(position);
        if (tail.size() > length) {
            tail.removeFirst();
        }
        position = position.next(direction);
        if (tail.contains(position)) {
            throw new BitMySelfException();
        }
        System.out.println("At Position " + position + ", looking " + direction);
    }

    public void render(Grid grid) {
        grid.drawSnake(position, tail);
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public boolean intersectsWith(Cell freeCell) {
        return position.equals(freeCell) || tail.contains(freeCell);
    }
}
