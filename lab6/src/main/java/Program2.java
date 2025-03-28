public class Program2 {
  public static void printArray(Integer[] arr) {
    for (Integer num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void printArray(Double[] arr) {
    for (Double num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void printArray(Character[] arr) {
    for (Character ch : arr) {
      System.out.print(ch + " ");
    }
    System.out.println();
  }

  public static void printArray(String[] arr) {
    for (String str : arr) {
      System.out.print(str + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] intArray = {1, 2, 3, 4, 5};
    Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
    Character[] charArray = {'A', 'B', 'C', 'D'};
    String[] stringArray = {"Hello", "World", "Java"};

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
