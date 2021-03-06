package core;

import Graphic.Render;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //load game information (load in a Object name gameField)
        //TODO: level menu, if level 0(tutorial) filename is "Map/Level/Level0.txt", if level 1 filename is "Map/Level/Level1.txt"
        GameField gameField = GameStage.loadGameField("Map/Level/Level0.txt");
        //Create new Window
        Render renderGame = new Render();
        Group root = new Group();
        Scene theScene = new Scene(root, Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT + 120);
        Canvas canvas = new Canvas(Config.CANVAS_WIDTH, Config.CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Render.generateWindow(primaryStage, root, theScene);
        root.getChildren().addAll(canvas);
        /*
        | Menu game + Game loop
         */
        //gameField = GameController.selectLevel(canvas, theScene, gameField, root, gc, primaryStage);
        GameController.menu(canvas, theScene, gameField, root, gc, primaryStage);
    }

    public static void main (String[] args){
        launch(args);
    }
}
