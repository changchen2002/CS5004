import hospital.Doctor;
import hospital.Pharmacist;

/**
 * create instances of Hospital.HospitalWorker, Hospital.Doctor and Hospital.Pharmacist
 */

public class Main {
  public static void main(String [] args) {
    // Create a Hospital.Doctor instance
    Doctor doctor = new Doctor("Dr. Smith", 101, "Surgery", "Surgeon", 10);
    System.out.println(doctor);

    // Create a Hospital.Pharmacist instance
    Pharmacist pharmacist = new Pharmacist("John Doe", 201, "Pharmacy", true);
    System.out.println(pharmacist);

    // Test prescribing medication
    try {
      String prescription = doctor.prescribeMedication("Paracetamol", "Alice");
      System.out.println(prescription);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    // Test dispensing medication
    boolean dispensed = pharmacist.dispenseMedication("Ibuprofen", "Bob");
    System.out.println("Medication dispensed: " + dispensed);
  }
}

