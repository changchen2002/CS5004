package draw;

public class Rectangle extends Figure {

  private Integer width;
  private Integer height;

  public Rectangle(Integer x, Integer y, Integer width, Integer height) {
    super(x, y);
    this.width = width;
    this.height = height;
  }

  public Integer  getWidth() {
    return width;
  }

  public Integer getHeight() {
    return height;
  }

  @Override
  public void draw() {
    System.out.println("The Rectangle is drawn at x: " + x + ", y: " + y);
  }

  @Override
  public void erase() {
    System.out.println("The Rectangle is erased");
  }

  @Override
  public void resize(double factor) {
    width = (int) (width * factor);
    height = (int) (height * factor);
    System.out.println("New width: " + width + ", new height: " + height);
  }
}
