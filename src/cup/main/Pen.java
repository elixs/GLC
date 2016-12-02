package cup.main;

import java.util.Arrays;

public class Pen {

  /*
   * Directions: x y S 0 -1 N 0 1 E 0 1 O 0 -1
   */

  String[][] board;
  int x, y, xdir, ydir;
  String color;
  boolean canPaint;

  PenFX penFX;

  public Pen(final PenFX penFX) {
    board = new String[50][50];
    x = y = ydir = 0;
    xdir = 1;
    color = "B";
    canPaint = false;
    for (final String[] row : board) {
      Arrays.fill(row, "B");
    }

    this.penFX = penFX;
  }

  public void setPenDown() {
    canPaint = true;

  }

  public void setPenUp() {
    canPaint = false;
  }

  public void setPenColor(final String color) {
    this.color = color;
  }

  public void setPenDir(final String dir) {
    xdir = ydir = 0;
    switch (dir) {
      case "S":
        ydir = -1;
        break;
      case "N":
        ydir = 1;
        break;
      case "E":
        xdir = 1;
        break;
      case "O":
        xdir = -1;
        break;
      default:
        System.err.println("Direction error: Choose a valid color");
        System.exit(1);
        break;
    }
  }

  public void forward() {
    if (canPaint) {
      this.penFX.addTransition(x, y, board[x][y], color);
      board[x][y] = color;
    }
    x += xdir;
    y += ydir;
    if (x > 49 || y > 49) {
      System.err.println("Edge error: You trespassed a border.");
      System.exit(1);
    }
  }

  public void move(final int n) {
    for (int i = 0; i < n; ++i) {
      this.forward();
    }
  }

  public boolean isBoardColor(final String color) {
    return board[x][y].equals(color);
  }

  public boolean edge() {
    return x + xdir > 49 || x + ydir > 49;
  }

  public boolean checkPenDir(final String dir) {
    switch (dir) {
      case "S":
        return xdir == 0 && ydir == -1;
      case "N":
        return xdir == 0 && ydir == 1;
      case "E":
        return xdir == 1 && ydir == 0;
      case "O":
        return xdir == -1 && ydir == 0;
      default:
        return false;
    }
  }

  public boolean checkPenColor(final String color) {
    return this.color.equals(color);
  }

  public boolean isPenUp() {
    return !canPaint;
  }

  public boolean isPenDown() {
    return canPaint;
  }

  public void print() {
    for (int i = 49; i >= 0; --i) {
      for (int j = 0; j < 50; ++j) {
        if (board[j][i].equals("Ne")) {
          System.out.print("N");
        } else {
          System.out.print(board[j][i]);
        }
      }
      System.out.println();
    }
  }

  public void setSpeed(final double speed) {
    penFX.setSpeed(speed);
  }



}
