package ship;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BattleshipModelImpl {
  private final int GRID_SIZE = 10;
  private final CellState[][] grid;
  private final List<Ship> ships;
  private final int maxGuesses;
  private int guessesMade;
  private final Random random;

  public BattleshipModelImpl(int maxGuesses) {
    this.maxGuesses = maxGuesses;
    this.grid = new CellState[GRID_SIZE][GRID_SIZE];
    // 初始化网格状态为 UNKNOWN
    for (int i = 0; i < GRID_SIZE; i++) {
      Arrays.fill(grid[i], CellState.UNKNOWN);
    }
    this.ships = new ArrayList<>();
    this.guessesMade = 0;
    this.random = new Random();
    placeAllShipsRandomly();
  }

  /**
   * 随机放置所有船只（按照 ShipType 枚举中定义的类型）。
   */
  private void placeAllShipsRandomly() {
    for (ShipType type : ShipType.values()) {
      boolean placed = false;
      while (!placed) {
        placed = tryPlaceShip(type);
      }
    }
  }

  private boolean tryPlaceShip(ShipType type) {
    int size = type.getSize();
    boolean horizontal = random.nextBoolean();
    int row = random.nextInt(GRID_SIZE);
    int col = random.nextInt(GRID_SIZE);

    List<Point> coords = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      int r = horizontal ? row : row + i;
      int c = horizontal ? col + i : col;
      // 检查是否越界或重叠
      if (r >= GRID_SIZE || c >= GRID_SIZE || isOccupied(r, c)) {
        return false;
      }
      coords.add(new Point(r, c));
    }

    ships.add(new Ship(type, coords));
    return true;
  }

  private boolean isOccupied(int row, int col) {
    Point p = new Point(row, col);
    for (Ship ship : ships) {
      if (ship.contains(p)) {
        return true;
      }
    }
    return false;
  }

  public String makeGuess(int row, int col) {
    if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE) {
      return "Invalid coordinates.";
    }
    if (grid[row][col] != CellState.UNKNOWN) {
      return "You already guessed that cell.";
    }

    guessesMade++;
    Point guess = new Point(row, col);
    for (Ship ship : ships) {
      if (ship.contains(guess)) {
        ship.registerHit(guess);
        grid[row][col] = CellState.HIT;
        if (ship.isSunk()) {
          return "Hit and sunk " + ship.getType();
        }
        return "Hit!";
      }
    }
    grid[row][col] = CellState.MISS;
    return "Miss!";
  }

  public CellState[][] getGrid() {
    CellState[][] gridCopy = new CellState[GRID_SIZE][GRID_SIZE];
    for (int i = 0; i < GRID_SIZE; i++) {
      // Copy each row. Since CellState is an enum (immutable), cloning the row is sufficient.
      gridCopy[i] = grid[i].clone();
    }
    return gridCopy;
  }

  public boolean isGameOver() {
    boolean allSunk = ships.stream().allMatch(ship -> ship.isSunk());
    return allSunk || (guessesMade >= maxGuesses);
  }

  public int getGuessesRemaining() {
    return maxGuesses - guessesMade;
  }
}
