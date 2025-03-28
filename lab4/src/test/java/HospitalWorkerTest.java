import hospital.HospitalWorker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HospitalWorkerTest {

  @Test
  void testEquals_SameID_ShouldBeEqual() {
    HospitalWorker worker1 = new HospitalWorker("Alice", 1001, "ER");
    HospitalWorker worker2 = new HospitalWorker("Bob", 1001, "Surgery");

    assertTrue(worker1.equals(worker2));
  }

  @Test
  void testEquals_DifferentID_ShouldNotBeEqual() {
    HospitalWorker worker1 = new HospitalWorker("Alice", 1001, "ER");
    HospitalWorker worker2 = new HospitalWorker("Bob", 1002, "Surgery");

    assertFalse(worker1.equals(worker2));
  }

  @Test
  void testToString_FormatCorrect() {
    HospitalWorker worker = new HospitalWorker("Alice", 1001, "ER");
    assertEquals("[Role]: Alice, ID: 1001, Department: ER", worker.toString());
  }
}