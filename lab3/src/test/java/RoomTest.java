import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class RoomTest {

  private Room room1;
  private Room room2;
  private Room room3;
  private Room room4;

  @BeforeEach
  void setUp() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      this.room1 = new Room(Room.RoomType.SINGLE, -300.0);
    });
    this.room2 = new Room(Room.RoomType.SINGLE, 300.0);
    this.room3 = new Room(Room.RoomType.DOUBLE, 500.0);
    this.room4 = new Room(Room.RoomType.FAMILY, 700.0);
  }

  @Test
  void testBooking() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      room2.bookRoom(2); //book a single room for 2 people, expect to fail
    });
    assertEquals(0, room2.getNumberOfGuests());
    assertTrue(room2.isAvailable());

    assertEquals(0, room3.getNumberOfGuests());  //double room is not booked
    assertTrue(room3.isAvailable());

    room4.bookRoom(3);  //book a family room for 3 people
    assertEquals(3, room4.getNumberOfGuests());  //check if successful
    assertFalse(room4.isAvailable());
  }
}