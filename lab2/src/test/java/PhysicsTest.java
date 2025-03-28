import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhysicsTest {
  private Point3D pointA;
  private Point3D pointB;
  @BeforeEach
  void setUp() {
    pointA = new Point3D(0, 0, 0);
    pointB = new Point3D(3, 4, 0);
  }

  @Test
  void testVelocity() {
    Assertions.assertEquals(2.5, Physics.velocity(pointA, pointB, 2.0));
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
                            Physics.velocity(pointA, pointB, -2.0);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Physics.velocity(pointA, pointB, 0.0);
    });
  }
}