package chess;

import static chess.Color.WHITE;
import static chess.Color.BLACK;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChessPieceTest {
  private ChessPiece bishop;
  private ChessPiece knight;
  private ChessPiece queen;
  private ChessPiece king;
  private ChessPiece rook;
  private ChessPiece pawn;
  private ChessPiece pawn2;

  @BeforeEach
  void setUp() {
    this.bishop = new Bishop(0, 2, WHITE);
    this.knight = new Knight(7, 1, BLACK);
    this.queen = new Queen(0, 3, WHITE);
    this.king = new King(7, 4, BLACK);
    this.rook = new Rook(0, 0, WHITE);
    this.pawn = new Pawn(6, 6, BLACK);
    this.pawn2 = new Pawn(5, 6, BLACK);
  }

  @Test
  void testOutOfBound() {
    //test creating a piece outside of board boundary
    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
      new Bishop(-1, 2, WHITE);
    });
    assertEquals("Out of bounds", exception1.getMessage());

    //test creating a pawn on row 0
    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
      new Pawn(0, 6, WHITE);
    });
    assertEquals("No pawns may be created in the \"royal\" row", exception2.getMessage());
  }

  @Test
  void canMove() {
    assertTrue(bishop.canMove(4, 6));
    assertFalse(bishop.canMove(4, 2));
    assertTrue(knight.canMove(6, 3));
    assertFalse(knight.canMove(6, 2));
    assertTrue(queen.canMove(4, 7));
    assertFalse(queen.canMove(4, 1));
    assertTrue(king.canMove(6, 3));
    assertFalse(king.canMove(5, 2));
    assertTrue(rook.canMove(7, 0));
    assertFalse(rook.canMove(1, 1));
    assertTrue(pawn.canMove(5, 6));
    assertTrue(pawn.canMove(4, 6)); //for first move pawn can move 2 steps
    assertFalse(pawn2.canMove(3, 6));
    assertFalse(pawn2.canMove(6, 6));
  }

  @Test
  void canKill() {
    assertTrue(bishop.canKill(new Knight(2, 0, BLACK)));
    assertFalse(bishop.canKill(new Knight(2, 0, WHITE)));
    assertTrue(knight.canKill(new Queen(6, 3, WHITE)));
    assertFalse(knight.canKill(new Queen(0, 3, WHITE)));
    assertTrue(queen.canKill(new King(7, 3, BLACK)));
    assertFalse(queen.canKill(new King(7, 4, BLACK)));
    assertTrue(king.canKill(new Rook(7, 3, WHITE)));
    assertFalse(king.canKill(new Rook(7, 2, WHITE)));
    assertTrue(rook.canKill(new Pawn(6, 0, BLACK)));
    assertFalse(rook.canKill(new Pawn(6, 6, BLACK)));
    assertTrue(pawn.canKill(new Bishop(5, 5, WHITE)));
    assertFalse(pawn.canKill(new Bishop(4, 6, WHITE)));
    assertFalse(pawn2.canKill(new Bishop(6, 7, WHITE)));
    assertFalse(pawn2.canKill(new Bishop(4, 6, WHITE)));
  }
}