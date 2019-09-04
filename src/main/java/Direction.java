import javafx.scene.input.KeyCode;

public enum Direction {

    UP(0, -1, KeyCode.UP),
    RIGHT(1, 0, KeyCode.RIGHT),
    DOWN(0, 1, KeyCode.DOWN),
    LEFT(-1, 0, KeyCode.LEFT);

    public static Direction findByKeyCode(KeyCode keyCode) {
        for (Direction direction : values()) {
            if (direction.keyCode == keyCode) {
                return direction;
            }
        }
        return null;
    }

    private int deltaX;

    private int deltaY;

    private KeyCode keyCode;

    Direction(int deltaX, int deltaY, KeyCode keyCode) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.keyCode = keyCode;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

}
