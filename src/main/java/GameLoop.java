import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    public static final long TICK_DURATION = 100000000;

    private long lastTick;

    private Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    @Override
    public void handle(long now) {
        try {
            if (now >= lastTick + TICK_DURATION) {
                lastTick += TICK_DURATION;
                game.tick();
            }
            game.render();
        } catch (BitMySelfException exception) {
            game.reset();
            lastTick = System.nanoTime();
        }
    }

    @Override
    public void start() {
        lastTick = System.nanoTime();
        super.start();
    }
}
