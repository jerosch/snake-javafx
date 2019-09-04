import javafx.scene.canvas.Canvas;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    public static final int WIDTH = 40;

    public static final int HEIGHT = 25;

    private Grid grid;

    private Snake snake;

    private Cell applePosition;

    private Queue<Direction> directionQueue = new LinkedList<>();

    public Game(Canvas canvas) {
        this.grid = new Grid(WIDTH, HEIGHT, canvas);
        reset();
    }

    public void render() {
        grid.clear();
        snake.render(grid);
        grid.drawApple(applePosition);
    }

    public void tick() {
        if (!directionQueue.isEmpty()) {
            snake.setDirection(directionQueue.poll());
        }
        snake.move();
        if (snake.intersectsWith(applePosition)) {
            snake.grow();
            applePosition = grid.getRandomFreePosition(snake);
        }
    }

    public void turnSnakeTo(Direction newDirection) {
        directionQueue.add(newDirection);
    }

    public void reset() {
        this.snake = new Snake(new Cell(20, 12));
        this.applePosition = grid.getRandomFreePosition(snake);
    }

}
