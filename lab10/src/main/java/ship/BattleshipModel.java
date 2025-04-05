package ship;

public interface BattleshipModel {
    String makeGuess(int row, int col);

    CellState[][] getGrid();

    boolean isGameOver();

    int getGuessesRemaining();
}
