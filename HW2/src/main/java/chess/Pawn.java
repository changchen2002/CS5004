package chess;

import static chess.Color.BLACK;
import static chess.Color.WHITE; //is there any other way to import?

public class Pawn extends ChessPiece {
  /**
   * pawn_move_directions[0]: white pawn move
   * pawn_move_directions[1]: white pawn move from game start row
   * pawn_move_directions[2]: black pawn move
   * pawn_move_directions[3]: black pawn move from game start row

   * pawn_kill_directions: pawn piece can kill diagonally
   * pawn_kill_directions[0] and pawn_kill_directions[1]: white pawn killing move
   * pawn_kill_directions[2] and pawn_kill_directions[3]: black pawn killing move
   */
  private static final int[][] pawn_move_directions = {{1, 0}, {2, 0}, {-1, 0}, {-2, 0}};
  private final int[][] pawn_kill_directions = {{1, -1}, {1, 1}, {-1, -1}, {-1, 1}};

  public Pawn(int row, int column, Color color) {
    super(row, column, color, pawn_move_directions);
    if ((color == WHITE && row == 0) || (color == BLACK && row == 7)) {
      throw new IllegalArgumentException("No pawns may be created in the \"royal\" row");
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    if (COLOR == WHITE) {
      //check white pawn move ahead 1 step
      if ((ROW + pawn_move_directions[0][0] == row) &&
          (COLUMN + pawn_move_directions[0][1] == col))
        return true;
      //check white pawn from game start row, move ahead 2 steps
      if (ROW == 1) {
        return (ROW + pawn_move_directions[1][0] == row) &&
            (COLUMN + pawn_move_directions[1][1] == col);
      }
    }

    if (COLOR == BLACK) {
      //check black pawn move ahead 1 step
      if ((ROW + pawn_move_directions[2][0] == row) &&
          (COLUMN + pawn_move_directions[2][1] == col))
        return true;
      //check black pawn from game start row, move ahead 2 steps
      if (ROW == 6) {
        return (ROW + pawn_move_directions[3][0] == row) &&
            (COLUMN + pawn_move_directions[3][1] == col);
      }
    }

    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    if (COLOR != piece.getColor()) {
      if (COLOR == WHITE) {
        for (int i = 0; i < 2; i++) {
          if (ROW + pawn_kill_directions[i][0] == piece.getRow() &&
              COLUMN + pawn_kill_directions[i][1] == piece.getColumn())
            return true;
        }
      }
      if (COLOR == BLACK) {
        for (int i = 2; i < 4; i++) {
          if (ROW + pawn_kill_directions[i][0] == piece.getRow() &&
              COLUMN + pawn_kill_directions[i][1] == piece.getColumn())
            return true;
        }
      }
    }
    return false;
  }
}
