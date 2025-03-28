import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
  private Book Java;
  private Book C;
  @BeforeEach
  void setUp() {
    this.Java = new Book("Java", 300, 5.0);
    this.C = new Book("C", 450, 4.9);
  }

  @Test
  void getName() {
    Assertions.assertEquals("Java", this.Java.getName());
    Assertions.assertEquals("C", this.C.getName());
  }

  @Test
  void getPages() {
    Assertions.assertEquals(300, this.Java.getPages());
    Assertions.assertEquals(450, this.C.getPages());
  }

  @Test
  void getRate() {
    Assertions.assertEquals(5.0, this.Java.getRate());
    Assertions.assertEquals(4.9, this.C.getRate());
  }
}