public class game {
  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = s1; // s2 和 s1 都指向同一个 "Hello" 对象
    s1 = "World"; // s1 改为 "World"，s2 仍然是 "Hello"
    System.out.println(s1);
    System.out.println(s2);
  }
}
