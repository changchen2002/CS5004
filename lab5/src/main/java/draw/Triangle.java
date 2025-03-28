package draw;

public class Triangle extends Figure {

  private Integer side1;
  private Integer side2;
  private Integer side3;

  public Triangle(Integer x, Integer y, Integer side1, Integer side2, Integer side3) {
    super(x, y);
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  public Integer getSide1() {
    return side1;
  }

  public Integer getSide2() {
    return side2;
  }

  public Integer getSide3() {
    return side3;
  }

  @Override
  public void draw() {
    System.out.println("The Triangle is drawn at x: " + x + ", y: " + y);
  }

  @Override
  public void erase() {
    System.out.println("The Triangle is erased");
  }

  @Override
  public void resize(double factor) {
    side1 = (int) (side1 * factor);
    side2 = (int) (side2 * factor);
    side3 = (int) (side3 * factor);
    System.out.println("New side1: " + side1 + ", new side2: " + side2 + ", new side3: " + side3);
  }
}
