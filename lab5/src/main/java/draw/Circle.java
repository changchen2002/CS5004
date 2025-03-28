package draw;

public class Circle extends Figure {

  private Integer radius;

  public Circle(Integer x, Integer y, Integer radius) {
    super(x, y);
    this.radius = radius;
  }

  public Integer getRadius() {
    return radius;
  }

  @Override
  public void draw() {
    System.out.println("The Circle is drawn at x: " + x + ", y: " + y);
  }

  @Override
  public void erase() {
    System.out.println("The Circle is erased");
  }

  @Override
  public void resize(double factor) {
    radius = (int) (radius * factor);
    System.out.println("New radius: " + radius);
  }
}
