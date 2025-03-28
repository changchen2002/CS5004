public class Student {
  private String firstName;
  private String lastName;
  private String ID;
  private String email;

  public Student(String firstName, String lastName, String ID, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.ID = ID;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getID() {
    return ID;
  }

  public String getEmail() {
    return email;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
