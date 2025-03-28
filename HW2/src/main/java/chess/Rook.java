package chess;

import static java.lang.Math.abs;

public class Rook extends ChessPiece {

  public Rook(int row, int column, Color color) {
    super(row, column, color, null);
  }
  @Override
  public boolean canMove(int row, int col) {
    return ROW == row || COLUMN == col;
  }
}
