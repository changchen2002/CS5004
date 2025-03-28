package chess;

public class Knight extends ChessPiece {
  private static final int[][] knight_directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

  public Knight(int row, int column, Color color) {
    super(row, column, color, knight_directions);
  }
}
