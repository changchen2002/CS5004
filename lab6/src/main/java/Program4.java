public class Program4 {
  public static <T extends Comparable<T>> T getMax(T[] anArray) {
    T max = anArray[0]; // Assume first element is max
    for (T element : anArray) {
      if (element.compareTo(max) > 0) { // Compare elements
        max = element;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    // Test arrays
    Integer[] intArry = {10, 20, 5, 40, 30};
    Double[] doubArry = {3.5, 7.2, 1.8, 9.4};
    Character[] charArry = {'A', 'Z', 'M', 'K'};
    String[] strArry = {"Apple", "Orange", "Banana", "Peach"};

    // Testing getMax() method
    System.out.println("Max Integer is: " + getMax(intArry));
    System.out.println("Max Double is: " + getMax(doubArry));
    System.out.println("Max Character is: " + getMax(charArry));
    System.out.println("Max String is: " + getMax(strArry));
  }
}
