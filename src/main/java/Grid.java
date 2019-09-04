import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Collection;
import java.util.Random;

public class Grid {

    private final int width;

    private final int height;

    private Canvas canvas;

    private GraphicsContext gc;

    private Random random;

    public Grid(int width, int height, Canvas canvas) {
        this.width = width;
        this.height = height;
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.random = new Random();
    }

    public void clear() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void drawSnake(Cell headPos, Collection<Cell> tail) {
        gc.setFill(Color.YELLOW);
        drawCell(headPos);
        gc.setFill(Color.WHITE);
        for (Cell cell : tail) {
            drawCell(cell);
        }
    }

    private void drawCell(Cell headPos) {
        double cellWidth = canvas.getWidth() / width;
        double cellHeight = canvas.getHeight() / height;
        gc.fillRect(cellWidth * headPos.getX(), cellHeight * headPos.getY(), cellWidth, cellHeight);
    }

    public Cell getRandomFreePosition(Snake snake) {
        Cell freeCell;
        do {
            freeCell = getRandomPosition();
        } while (snake.intersectsWith(freeCell));
        return freeCell;
    }

    private Cell getRandomPosition() {
        return new Cell(random.nextInt(width), random.nextInt(height));
    }

    public void drawApple(Cell applePosition) {
        gc.setFill(Color.RED);
        drawCell(applePosition);
    }

}
