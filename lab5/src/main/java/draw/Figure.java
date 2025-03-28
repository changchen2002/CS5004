package draw;

interface Drawable {
  public void draw();
  public void erase();
  public void resize(double factor);
}

public abstract class Figure implements Drawable {
  protected Integer x;
  protected Integer y;

  //A constructor that initializes x and y.
  public Figure(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  //An empty constructor
  public Figure() {
    this.x = null;
    this.y = null;
  }

  //A copy constructor
  public Figure(Figure that) {
    this.x = that.x;
    this.y = that.y;
  }

  @Override
  public void draw() {
    System.out.println("The figure is drawn");
  }

  @Override
  public void erase() {
    System.out.println("The figure is erased");
  }

  public abstract void resize(double factor);

  public void move(int dx, int dy) {
    x += dx;
    y += dy;
    System.out.println("New x: " + x + ", new y: " + y);
  }

}
