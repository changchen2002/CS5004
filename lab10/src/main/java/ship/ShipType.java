package ship;

public enum ShipType {
  PATROL_BOAT(2),
  SUBMARINE(3),
  DESTROYER(3),
  BATTLESHIP(4),
  AIRCRAFT_CARRIER(5);

  private final int size;

  ShipType(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }
}
