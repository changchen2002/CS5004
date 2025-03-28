import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElectricVehicleTest {

  private ElectricVehicle ev1;
  private ElectricVehicle ev2;
  private ElectricVehicle ev3;

  @BeforeEach
  void setUp() {
    this.ev1 = new ElectricVehicle("", 9.0, 0.14, 0.4); //test clamping lower limits
    this.ev2 = new ElectricVehicle(null, 151.0, 1.1, 4.6); //test clamping upper limits
    this.ev3 = new ElectricVehicle("MyElectricVehicle", 10.1, 0.16, 0.6); //test inbound values
  }

  @Test
  void range() {
    assertEquals(0.75, ev1.range(), 0.01);
    assertEquals(675.0, ev2.range(), 0.1);
    assertEquals(0.9696, ev3.range(), 0.01);
  }

  @Test
  void updateEfficiency() {
    ev3.updateEfficiency(70);  //test inbound limits
    assertEquals(1.00, ev3.getCurrentEfficiency());

    ev3.updateEfficiency(80);  //test clamping upper limits
    assertEquals(0.85, ev3.getCurrentEfficiency());

    ev3.updateEfficiency(64.1);  //test clamping lower limits
    assertEquals(0.991, ev3.getCurrentEfficiency());
  }

  @Test
  void getCurrentEfficiency() {
    assertEquals(0.5, ev1.getCurrentEfficiency());
    assertEquals(4.5, ev2.getCurrentEfficiency());
    assertEquals(0.6, ev3.getCurrentEfficiency());
  }

  @Test
  void getBatterySize() {
    assertEquals(10.0, ev1.getBatterySize());
    assertEquals(150.0, ev2.getBatterySize());
    assertEquals(10.1, ev3.getBatterySize());
  }

  @Test
  void getStateOfCharge() {
    assertEquals(0.15, ev1.getStateOfCharge());
    assertEquals(1.0, ev2.getStateOfCharge());
    assertEquals(0.16, ev3.getStateOfCharge());
  }

  @Test
  void getName() {
    assertEquals("unknown EV", ev1.getName());
    assertEquals("unknown EV", ev2.getName());
    assertEquals("MyElectricVehicle", ev3.getName());
  }

  @Test
  void setStateOfCharge() {
    ev1.setStateOfCharge(0.6); // Set a new SOC
    assertEquals(0.6, ev1.getStateOfCharge());

    ev2.setStateOfCharge(1.3); // Test upper limit
    assertEquals(1.0, ev2.getStateOfCharge());

    ev3.setStateOfCharge(0.0); // Test lower limit
    assertEquals(0.15, ev3.getStateOfCharge());
  }

  @Test
  void testToString() {
    String expected1 = "unknown EV SOC: 15.0% Range (miles): 0.8";
    String expected3 = "MyElectricVehicle SOC: 16.0% Range (miles): 1.0";

    assertEquals(expected1, ev1.toString());
    assertEquals(expected3, ev3.toString());
  }
}