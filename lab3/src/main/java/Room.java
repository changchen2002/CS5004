/**
 *
 */
public class Room {
  public Integer occupancy;
  public double price;
  public Integer guestNumber;
  public RoomType roomtype;

  public enum RoomType{
    SINGLE,
    DOUBLE,
    FAMILY
  }

  //Room constructor that set the room type and price
  public Room(RoomType roomType, double price){
    //check if the price is negative
    if (price < 0){
      throw new IllegalArgumentException("Invalid price");
    }

    //set occupancy based on room type
    switch (roomType) {
      case SINGLE:
        this.occupancy = 1;
        break;
      case DOUBLE:
        this.occupancy = 2;
        break;
      case FAMILY:
        this.occupancy = 4;
        break;
      default:
        this.occupancy = 0;
    }

    this.guestNumber = 0;
    this.roomtype = roomType;
    this.price = price;
  }

  public boolean isAvailable(){
    return this.guestNumber == 0;
  }

  public void bookRoom(Integer guests){
    if (this.isAvailable() && guests <= this.occupancy && guests > 0){
      this.guestNumber = guests;
    } else {
      throw new IllegalArgumentException("Invalid booking");
    }
  }

  public Integer getNumberOfGuests(){
    return this.guestNumber;
  }
}
