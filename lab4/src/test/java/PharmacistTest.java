import hospital.Pharmacist;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PharmacistTest {

  @Test
  void testDispenseMedication_LicensedPharmacist_ShouldSucceed() {
    Pharmacist pharmacist = new Pharmacist("Emily", 4001, "Pharmacy", true);
    assertTrue(pharmacist.dispenseMedication("Paracetamol", "John Doe"));
  }

  @Test
  void testDispenseMedication_UnlicensedPharmacist_ShouldFail() {
    Pharmacist pharmacist = new Pharmacist("Emily", 4002, "Pharmacy", false);
    assertFalse(pharmacist.dispenseMedication("Ibuprofen", "John Doe"));
  }

  @Test
  void testDispenseMedication_InvalidMedication_ShouldFail() {
    Pharmacist pharmacist = new Pharmacist("Emily", 4001, "Pharmacy", true);
    assertFalse(pharmacist.dispenseMedication("Aspirin", "John Doe"));
  }

  @Test
  void testEquals_SameID_ShouldBeEqual() {
    Pharmacist p1 = new Pharmacist("Emily", 5001, "Pharmacy", true);
    Pharmacist p2 = new Pharmacist("Sophia", 5001, "Pharmacy", false);

    assertTrue(p1.equals(p2));
  }

  @Test
  void testEquals_DifferentID_ShouldNotBeEqual() {
    Pharmacist p1 = new Pharmacist("Emily", 5001, "Pharmacy", true);
    Pharmacist p2 = new Pharmacist("Sophia", 5002, "Pharmacy", false);

    assertFalse(p1.equals(p2));
  }

  @Test
  void testToString_FormatCorrect() {
    Pharmacist pharmacist = new Pharmacist("Emily", 4001, "Pharmacy", true);
    assertEquals("[Role]: Emily, ID: 4001, Department: Pharmacy, Licensed: true", pharmacist.toString());
  }
}