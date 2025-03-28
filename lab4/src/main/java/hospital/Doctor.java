package hospital;

/**
 *class Hospital.Doctor: subclass of Hospital.HospitalWorker
 */

public class Doctor extends HospitalWorker {

  public String speciality;
  public Integer prescriptionsPerDay;

  //Constructor of Hospital.Doctor
  public Doctor(String name, Integer ID, String department, String speciality,
      Integer prescriptionsPerDay) {
    super(name, ID, department);
    this.speciality = speciality;
    this.prescriptionsPerDay = prescriptionsPerDay;
  }

  public String prescribeMedication(String medication, String patientName) {
    for (String s : medications) {
      if (s.equals(medication)) {
        return "Hospital.Doctor " + name + " prescribed " + medication + " to " + patientName;
      }
    }
    throw new IllegalArgumentException(
        "Medication " + medication + " is not approved for prescription.");
  }

  public String performSurgery() {
    if (speciality.equals("Surgeon")) {
      return "Hospital.Doctor " + name + " is performing the surgery.";
    }
    return "This doctor is not qualified for surgery.";
  }

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    Doctor other = (Doctor) obj;
    return speciality.equals(other.speciality);
  }

  @Override
  public String toString() {
    return super.toString() + ", Speciality: " + speciality + ", Prescriptions per day: " +
        prescriptionsPerDay;
  }

  public String getSpeciality() {
    return speciality;
  }

  public Integer getPrescriptionsPerDay() {
    return prescriptionsPerDay;
  }

  public void setPrescriptionsPerDay(Integer prescriptionsPerDay) {
    this.prescriptionsPerDay = prescriptionsPerDay;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }
}
