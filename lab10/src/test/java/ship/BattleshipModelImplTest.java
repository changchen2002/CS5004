package ship;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleshipModelImplTest {
  private BattleshipModelImpl model;

  @BeforeEach
  public void setUp() {
    // Set a high number for maximum guesses to facilitate testing.
    model = new BattleshipModelImpl(100);
  }

  @Test
  public void testValidGuesses() {
    String result = model.makeGuess(0, 0);
    assertNotNull(result, "The guess result should not be null.");
    CellState[][] grid = model.getGrid();
    assertNotEquals(CellState.UNKNOWN, grid[0][0],
        "The cell state should be updated after a guess.");
  }

  @Test
  public void testInvalidGuesses_OutOfBounds() {
    String result1 = model.makeGuess(-1, 0);
    String result2 = model.makeGuess(0, 10);
    assertEquals("Invalid coordinates.", result1,
        "A negative row coordinate should return an invalid coordinates message.");
    assertEquals("Invalid coordinates.", result2,
        "A column coordinate out of bounds should return an invalid coordinates message.");
  }

  @Test
  public void testInvalidGuesses_SameCellTwice() {
    String firstResult = model.makeGuess(1, 1);
    // The first guess might return "Hit!", "Miss!" or "Hit and sunk <ShipType>".
    assertTrue(firstResult.startsWith("Hit") || firstResult.equals("Miss!"),
        "The first guess should return a valid message indicating a hit or miss.");
    String secondResult = model.makeGuess(1, 1);
    assertEquals("You already guessed that cell.", secondResult,
        "Guessing the same cell twice should return a message indicating the cell was already guessed.");
  }

  @Test
  public void testGameOver_ByMaxGuesses() {
    // Create a model with maximum guesses set to 1.
    BattleshipModelImpl smallModel = new BattleshipModelImpl(1);
    smallModel.makeGuess(0, 0);
    assertTrue(smallModel.isGameOver(),
        "The game should be over after reaching the maximum number of guesses.");
  }

  @Test
  public void testGridDeepCopy() {
    CellState[][] grid1 = model.getGrid();
    // Modify the returned grid.
    grid1[0][0] = CellState.HIT;
    // Retrieve the grid again from the model.
    CellState[][] grid2 = model.getGrid();
    // If getGrid returns a deep copy, grid2[0][0] should remain unaffected.
    assertNotEquals(grid1[0][0], grid2[0][0],
        "Modifying the returned grid copy should not affect the model's internal grid state.");
  }
}