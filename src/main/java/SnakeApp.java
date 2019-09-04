import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class SnakeApp extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(Game.WIDTH * 20, Game.HEIGHT * 20);
        Game game = new Game(canvas);

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new DirectionHandler(game));

        stage.setScene(scene);
        stage.setTitle("JavaFX Snake");

        GameLoop loop = new GameLoop(game);
        loop.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
