package cup.main;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PenFX extends Application {

  double speed;
  Rectangle[][] rectangles;
  List<FillTransition> fillTransitions;
  GridPane gridPane;

  public Color selectColor(final String color) {
    switch (color) {
      case "A":
        return Color.BLUE;
      case "R":
        return Color.RED;
      case "V":
        return Color.GREEN;
      case "B":
        return Color.WHITE;
      case "Ne":
        return Color.BLACK;
      default:
        return Color.WHITE;
    }
  }

  public void addTransition(final int x, final int y, final String c1, final String c2) {
    fillTransitions.add(new FillTransition(Duration.millis(3000.0 / speed), rectangles[49 - y][x],
        selectColor(c1), selectColor(c2)));
  }

  public void setSpeed(final double speed) {
    this.speed = speed;
  }

  @Override
  public void start(final Stage primaryStage) throws Exception {

    rectangles = new Rectangle[50][50];
    fillTransitions = new ArrayList<FillTransition>();
    gridPane = new GridPane();
    for (int i = 0; i < 50; ++i) {
      for (int j = 0; j < 50; ++j) {
        rectangles[i][j] = new Rectangle(14, 14, Color.WHITE);
        GridPane.setConstraints(rectangles[i][j], j, i);
      }
      gridPane.getChildren().addAll(rectangles[i]);
    }

    final Pen pen = new Pen(this);
    final Parser parser = new Parser();
    parser.setPen(pen);
    parser.parse();

    final Scene scene = new Scene(gridPane, 700, 700);

    primaryStage.setScene(scene);

    for (int i = 0; i < fillTransitions.size() - 1; ++i) {
      final FillTransition next = fillTransitions.get(i + 1);
      fillTransitions.get(i).setOnFinished(new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent event) {
          next.play();
        }
      });
    }
    if (fillTransitions.size() > 0) {
      fillTransitions.get(0).play();
    }

    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("m.png")));

    primaryStage.setTitle("Teoría - Tarea 2 - PenFX - （╯°□°）╯︵ ┻━┻");


    primaryStage.show();
  }

  public static void main(final String[] args) {
    launch(args);
  }

}
