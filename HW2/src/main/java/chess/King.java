package chess;

public class King extends ChessPiece {

  private static final int[][] king_directions = {
      {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
      {1, 0}, {-1, 0}, {0, 1}, {0, -1}
  };

  public King(int row, int column, Color color) {
    super(row, column, color, king_directions);
  }
}
