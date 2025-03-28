package hospital;

/**
 * superclass of Hospital.Doctor and Hospital.Pharmacist
 */

public class HospitalWorker {

  protected String name;
  protected Integer ID;
  protected String department;
  protected final String [] medications = {"Paracetamol", "Ibuprofen", "Amoxicillin"};

  //Constructor of Hospital.HospitalWorker
  public HospitalWorker(String name, Integer ID, String department) {
    this.name = name;
    this.ID = ID;
    this.department = department;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    HospitalWorker that = (HospitalWorker) obj;  //downcasting:前面的比后面小,需要转型
    return ID.equals(that.ID);
  }
  //Object obj = new HospitalWorker(); upcasting:前面的比后面大,无需转型
  //System.out.println(obj.getClass()); // 输出: class HospitalWorker
  //obj 的静态类型是 Object，因为它被声明为 Object 类型。
  //obj 的实际类（运行时类型）是 HospitalWorker，因为它指向了 HospitalWorker 实例。
  //HospitalWorker worker = new Doctor();
  //worker只能引用HospitalWorker的methods,但是由于方法被 override, worker.toString()会执行Doctor的toString()

  @Override
  public String toString() {
    return "[Role]: " + name + ", ID: " + ID + ", Department: " + department;
  }

  public String[] getMedications() {
    return medications;
  }

  public String getDepartment() {
    return department;
  }

  public Integer getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public void setName(String name) {
    this.name = name;
  }
}






