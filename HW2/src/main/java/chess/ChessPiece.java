package chess;

interface ChessPieceContract {
  public int getRow();
  public int getColumn();
  public Color getColor();
  public boolean canMove(int row, int col);
  public boolean canKill(ChessPiece piece);
}

public abstract class ChessPiece implements ChessPieceContract {

  protected int ROW;
  protected int COLUMN;
  protected Color COLOR;
  //Directions for chess piece movement, represented as {rowOffset, colOffset}.
  protected final int[][] DIRECTIONS;

  public ChessPiece(int row, int column, Color color, int[][] directions) {
    this.DIRECTIONS = directions;
    if (row > 7 || row < 0 || column > 7 || column < 0) {
      throw new IllegalArgumentException("Out of bounds");
    }
    this.ROW = row;
    this.COLUMN = column;
    this.COLOR = color;
  }

  public int getRow() {
    return ROW;
  }

  public int getColumn() {
    return COLUMN;
  }

  public Color getColor() {
    return COLOR;
  }

  public boolean canMove(int row, int col) {
    for (int[] direction : DIRECTIONS) {
      if (ROW + direction[0] == row && COLUMN + direction[1] == col) {
        return true;
      }
    }
    return false;
  }

  public boolean canKill(ChessPiece piece) {
    if (COLOR != piece.getColor()) {
      return canMove(piece.getRow(), piece.getColumn());
    }
    return false;
  }
}
