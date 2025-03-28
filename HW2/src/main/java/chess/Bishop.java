package chess;

import static java.lang.Math.abs;

public class Bishop extends ChessPiece {

  public Bishop(int row, int column, Color color) {
    super(row, column, color, null);
  }

  @Override
  public boolean canMove(int row, int col) {
    return abs(ROW - row) == abs(COLUMN - col);
  }
}
