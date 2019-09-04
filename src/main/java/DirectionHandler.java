import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class DirectionHandler implements EventHandler<KeyEvent> {

    private Game game;

    public DirectionHandler(Game game) {
        this.game = game;
    }

    @Override
    public void handle(KeyEvent event) {
        Direction newDirection = Direction.findByKeyCode(event.getCode());
        if (newDirection != null) {
            game.turnSnakeTo(newDirection);
        }
    }

}
