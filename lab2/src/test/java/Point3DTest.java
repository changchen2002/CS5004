import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Point3DTest {
  private Point3D point;
  private Point3D other;

  @BeforeEach
  void setUp() {
    this.point = new Point3D(1, 2, 3);
    this.other = new Point3D(0, 0, 0);
  }

  @Test
  void copyPoint() {
    Point3D copy = this.point.copyPoint(this.point);
    Assertions.assertEquals(this.point.getX(), copy.getX());
    Assertions.assertEquals(this.point.getY(), copy.getY());
    Assertions.assertEquals(this.point.getZ(), copy.getZ());
    Assertions.assertNotSame(this.point, copy);
  }

  @Test
  void getX() {
    Assertions.assertEquals(1, this.point.getX());
  }

  @Test
  void getY() {
    Assertions.assertEquals(2, this.point.getY());
  }

  @Test
  void getZ() {
    Assertions.assertEquals(3, this.point.getZ());
  }

  @Test
  void distanceTo() {
    Assertions.assertEquals(Math.sqrt(14), this.point.distanceTo(other));
  }

  @Test
  void testEquals() {
    Assertions.assertFalse(this.point.equals(other));
  }

  @Test
  void testToString() {
    Assertions.assertEquals("Point3D{x=1, y=2, z=3}",
        this.point.toString());
  }
}