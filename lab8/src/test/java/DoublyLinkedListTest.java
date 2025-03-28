import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {
  private DoublyLinkedList<Integer> int_list;
  private DoublyLinkedList<String> str_list;

  @BeforeEach
  void setUp() {
    int_list = new DoublyLinkedList<>();
    str_list = new DoublyLinkedList<>();
  }

  @Test
  void addFirst() {
    int_list.addFirst(10);
    int_list.addFirst(20);
    assertEquals(2, int_list.size());
    assertEquals("20", int_list.getDataAtIndex(0));
    assertEquals("10", int_list.getDataAtIndex(1));
    int_list.displayForward();
    int_list.displayBackward();

    str_list.addFirst("node 1");
    str_list.addFirst("node 2");
    assertEquals(2, str_list.size());
    assertEquals("node 2", str_list.getDataAtIndex(0));
    assertEquals("node 1", str_list.getDataAtIndex(1));
    str_list.displayForward();
    str_list.displayBackward();
  }

  @Test
  void addLast() {
    int_list.addLast(30);
    int_list.addLast(40);
    assertEquals(2, int_list.size());
    assertEquals("30", int_list.getDataAtIndex(0));
    assertEquals("40", int_list.getDataAtIndex(1));
    int_list.displayForward();
    int_list.displayBackward();

    str_list.addLast("node 3");
    str_list.addLast("node 4");
    assertEquals(2, str_list.size());
    assertEquals("node 3", str_list.getDataAtIndex(0));
    assertEquals("node 4", str_list.getDataAtIndex(1));
    str_list.displayForward();
    str_list.displayBackward();
  }

  @Test
  void delete() {
    int_list.addLast(50);
    int_list.addLast(60);
    int_list.addLast(70);
    int_list.addLast(80);
    assertFalse(int_list.delete(90));
    assertTrue(int_list.delete(50));
    assertTrue(int_list.delete(70));
    assertTrue(int_list.delete(80));
    assertTrue(int_list.delete(60));
    assertEquals(0, int_list.size());

    str_list.addLast("node 5");
    str_list.addLast("node 6");
    str_list.addLast("node 7");
    str_list.addLast("node 8");
    assertFalse(str_list.delete("node 9"));
    assertTrue(str_list.delete("node 5"));
    assertTrue(str_list.delete("node 7"));
    assertTrue(str_list.delete("node 8"));
    assertTrue(str_list.delete("node 6"));
    assertEquals(0, str_list.size());
  }
}