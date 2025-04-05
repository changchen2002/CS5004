package ship;

import java.awt.Point;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Ship {
  private ShipType type;
  private List<Point> coordinates;  // 船占据的格子
  private Set<Point> hits;          // 已命中的格子

  public Ship(ShipType type, List<Point> coordinates) {
    this.type = type;
    this.coordinates = coordinates;
    this.hits = new HashSet<>();
  }

  public boolean contains(Point p) {
    return coordinates.contains(p);
  }

  public void registerHit(Point p) {
    if (contains(p)) {
      hits.add(p);
    }
  }

  public boolean isSunk() {
    return hits.containsAll(coordinates);
  }

  public ShipType getType() {
    return type;
  }
}