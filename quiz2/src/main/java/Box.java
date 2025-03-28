public class Box<T, U> {
  private T one;
  private U two;

  public Box(){
    this.one = null;
    this.two = null;
  }

  public Box(T one, U two){
    this.one = one;
    this.two = two;
  }

  public T getOne() {
    return one;
  }

  public U getTwo() {
    return two;
  }

  public boolean isEqual(Box<T, U> other){
    return one.equals(other.one) && two.equals(other.two);
  }

  public static <T, U> void swap(Box<T, U> first, Box<T, U> second){
    T temp1 = first.one;
    U temp2 = first.two;
    first.one = second.one;
    first.two = second.two;
    second.one = temp1;
    second.two = temp2;
  }

  public static void main(String[] args){
    Box<Integer, String> box1 = new Box<>(123, "Hello");
    Box<Double, Character> box2 = new Box<>(45.67, 'A');
    System.out.println("Box 1 object one: " + box1.getOne() + ", Box 1 object two: " + box1.getTwo());
    System.out.println("Box 2 object one: " + box2.getOne() + ", Box 2 object two: " + box2.getTwo());

    Box<Integer, String> box3 = new Box<>(123, "Hello");
    Box<Integer, String> box4 = new Box<>(456, "World");
    System.out.println("box1 is equal to box3: " + box1.isEqual(box3)); // true
    System.out.println("box1 is equal to box4: " + box1.isEqual(box4)); // true

    swap(box1, box4);
    System.out.println("After swap:");
    System.out.println("Box 1 object one: " + box1.getOne() + ", Box 1 object two: " + box1.getTwo());
    System.out.println("Box 4 object one: " + box4.getOne() + ", Box 4 object two: " + box4.getTwo());
  }

}
