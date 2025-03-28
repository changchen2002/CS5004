public class Program3 {
  public static <T> void printArray(T[] arr) {
    //The <T> syntax defines a generic type.
    for (T element : arr) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] intArray = {10, 20, 30, 40};
    Double[] doubleArray = {5.5, 10.1, 15.2};
    Character[] charArray = {'X', 'Y', 'Z'};
    String[] stringArray = {"Java", "is", "fun"};

    System.out.println("Integer Array:");
    printArray(intArray);

    System.out.println("Double Array:");
    printArray(doubleArray);

    System.out.println("Character Array:");
    printArray(charArray);

    System.out.println("String Array:");
    printArray(stringArray);
  }
}
