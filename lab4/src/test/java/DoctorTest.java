import hospital.Doctor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

  @Test
  void testPrescribeMedication_ValidMedication() {
    Doctor doctor = new Doctor("Dr. Smith", 2001, "Cardiology", "Cardiologist", 5);
    String result = doctor.prescribeMedication("Ibuprofen", "John Doe");

    assertEquals("Hospital.Doctor Dr. Smith prescribed Ibuprofen to John Doe", result);
  }

  @Test
  void testPrescribeMedication_InvalidMedication_ShouldThrowException() {
    Doctor doctor = new Doctor("Dr. Smith", 2001, "Cardiology", "Cardiologist", 5);

    Exception e = assertThrows(IllegalArgumentException.class, () ->
        doctor.prescribeMedication("Aspirin", "John Doe")
    );

    assertEquals("Medication Aspirin is not approved for prescription.", e.getMessage());
  }

  @Test
  void testPerformSurgery_Surgeon_ShouldPerformSurgery() {
    Doctor doctor = new Doctor("Dr. Grey", 2002, "Surgery", "Surgeon", 3);
    assertEquals("Hospital.Doctor Dr. Grey is performing the surgery.", doctor.performSurgery());
  }

  @Test
  void testPerformSurgery_NonSurgeon_ShouldNotPerformSurgery() {
    Doctor doctor = new Doctor("Dr. Brown", 2003, "Pediatrics", "Pediatrician", 7);
    assertEquals("This doctor is not qualified for surgery.", doctor.performSurgery());
  }

  @Test
  void testEquals_SameIDAndSpeciality_ShouldBeEqual() {
    Doctor doc1 = new Doctor("Dr. House", 3001, "General", "Internist", 10);
    Doctor doc2 = new Doctor("Dr. Strange", 3001, "General", "Internist", 8);

    assertTrue(doc1.equals(doc2));
  }

  @Test
  void testEquals_DifferentSpeciality_ShouldNotBeEqual() {
    Doctor doc1 = new Doctor("Dr. House", 3001, "General", "Internist", 10);
    Doctor doc2 = new Doctor("Dr. Wilson", 3001, "General", "Oncologist", 8);

    assertFalse(doc1.equals(doc2));
  }
}