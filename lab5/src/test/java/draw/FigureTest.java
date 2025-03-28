package draw;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FigureTest {
  private Circle circle;
  private Rectangle rectangle;
  private Triangle triangle;

  @BeforeEach
  void setUp() {
    this.circle = new Circle(-5, 5, 10);
    this.rectangle = new Rectangle(1, 3, 5, 7);
    this.triangle = new Triangle(-2, 4, 6, 8, 10);
  }

  @Test
  void resize() {
    circle.resize(0.1);
    rectangle.resize(10.0);
    triangle.resize(2);
    assertEquals(1, circle.getRadius());
    assertEquals(50, rectangle.getWidth());
    assertEquals(70, rectangle.getHeight());
    assertEquals(12, triangle.getSide1());
    assertEquals(16, triangle.getSide2());
    assertEquals(20, triangle.getSide3());
  }

  @Test
  void move() {
    circle.move(1, 1);
    rectangle.move(-1, -1);
    triangle.move(5, -5);
    assertEquals(-4, circle.x);
    assertEquals(6, circle.y);
    assertEquals(0, rectangle.x);
    assertEquals(2, rectangle.y);
    assertEquals(3, triangle.x);
    assertEquals(-1, triangle.y);
  }
}