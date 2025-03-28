import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagerTest {
  private TaskManager taskManager;

  @BeforeEach
  void setUp() {
    taskManager = new TaskManager();
  }

  @Test
  void testAddTask() {
    taskManager.addTask("Task 1");
    assertEquals("Task 1", taskManager.getCurrentTask());

    taskManager.addTask("Task 2");
    assertEquals("Task 2", taskManager.getCurrentTask());
  }

  @Test
  void testRemoveTask() {
    taskManager.addTask("Task 1");
    taskManager.addTask("Task 2");
    taskManager.addTask("Task 3");

    assertTrue(taskManager.removeTask("Task 2"));
    assertEquals("Task 3", taskManager.getCurrentTask());

    assertFalse(taskManager.removeTask("Task 4"));
  }

  @Test
  void testGetCurrentTask() {
    taskManager.addTask("Task A");
    taskManager.addTask("Task B");
    assertEquals("Task B", taskManager.getCurrentTask());
  }

  @Test
  void testMoveTask() {
    taskManager.addTask("Task 1");
    taskManager.addTask("Task 2");
    taskManager.addTask("Task 3");

    assertFalse(taskManager.moveNext());
    assertEquals("Task 3", taskManager.getCurrentTask());

    assertTrue(taskManager.movePrev());
    assertEquals("Task 2", taskManager.getCurrentTask());

    assertTrue(taskManager.moveNext());
    assertEquals("Task 3", taskManager.getCurrentTask());
  }
}