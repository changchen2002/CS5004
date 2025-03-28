public class Physics {
  public static double velocity(Point3D one, Point3D two, double elapsedTime){
    if (elapsedTime <= 0){
      throw new IllegalArgumentException("Invalid elapsedTime");
    }
    return one.distanceTo(two) / elapsedTime;
  }

  public static void main(String[] args) {
    Point3D pointA = new Point3D(0, 0, 0);
    Point3D pointB = new Point3D(1, 1, 1);

    try {
      double distance = pointA.distanceTo(pointB);
      System.out.println("The distance is " + distance);

      double average_v = Physics.velocity(pointA, pointB, 5.0);
      System.out.println("The average velocity is " + average_v);
    } catch (IllegalArgumentException e) {
      // 处理 IllegalArgumentException 异常
      System.out.println("Error: " + e.getMessage());
    }
  }
}
