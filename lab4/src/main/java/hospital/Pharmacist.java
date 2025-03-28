package hospital;

/**
 *class Hospital.Pharmacist: subclass of Hospital.HospitalWorker
 */
public class Pharmacist extends HospitalWorker {

  public Boolean licensed;

  //Constructor of Hospital.Pharmacist
  public Pharmacist(String name, Integer ID, String department, Boolean licensed) {
    super(name, ID, department);
    this.licensed = licensed;
  }

  public boolean dispenseMedication(String medication, String patientName) {
    if (licensed) {
      for (String s : medications) {
        if (s.equals(medication)) {
          System.out.print("Medication dispense.");
          return true;
        }
      }
    }
    System.out.print("Fail to dispense medication");
    return false;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return super.toString() + ", Licensed: " + licensed;
  }

  public Boolean getLicensed() {
    return licensed;
  }

  public void setLicensed(Boolean licensed) {
    this.licensed = licensed;
  }
}

