public class Program1 {
  public static void printArray(Object[] objects) {
    for (Object object : objects) {
      System.out.print(object + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] intArry = {1, 2, 3, 4, 5};
    Double[] doubArry = {1.1, 2.2, 3.3, 4.4};
    Character[] charArry = {'H', 'E', 'L', 'L', 'O'};
    String[] strArry = {"once", "upon", "a", "time"};
    Program1.printArray(intArry);
    Program1.printArray(doubArry);
    Program1.printArray(charArry);
    Program1.printArray(strArry);
  }
}
