public class TaskManager {
  private DoublyLinkedList<String> tasks;
  private int currentIndex;

  public TaskManager(){
    this.tasks = new DoublyLinkedList<>();
    this.currentIndex = 0;
  }

  public void addTask(String task){
    tasks.addLast(task);
    if (tasks.size() == 1){
      currentIndex = 0;
    }
    else {
      currentIndex++;
    }
  }

  public boolean removeTask(String task){
    if (tasks.size() == 0) return false;
    boolean isRemoved = tasks.delete(task);
    if (isRemoved){
      if (currentIndex >= tasks.size()){
        currentIndex = tasks.size() - 1;
      }
    }
    return isRemoved;
  }

  public String getCurrentTask(){
    return tasks.getDataAtIndex(currentIndex);
  }

  public boolean moveNext(){
    if (currentIndex + 1 < tasks.size()) {
      currentIndex++;
      return true;
    }
    return false;
  }

  public boolean movePrev(){
    if (currentIndex - 1 >= 0) {
      currentIndex--;
      return true;
    }
    return false;
  }

  public void displayTasks(){
    tasks.displayForward();
  }

  public static void main(String[] args) {
    TaskManager taskManager = new TaskManager();

    // Adding tasks
    taskManager.addTask("Task 1");
    taskManager.addTask("Task 2");
    taskManager.addTask("Task 3");
    taskManager.addTask("Task 4");

    System.out.println("Tasks after adding: ");
    taskManager.displayTasks();
    System.out.println("Current Task: " + taskManager.getCurrentTask());

    // Moving next and displaying current task
    boolean movedNext = taskManager.moveNext();
    System.out.println("Moved next: " + movedNext);

    // Removing task
    boolean removed = taskManager.removeTask("Task 2");
    System.out.println("Removed 'Task 2': " + removed);
    taskManager.displayTasks();
    System.out.println("Current Task: " + taskManager.getCurrentTask());

    // Moving previous
    boolean movedPrev = taskManager.movePrev();
    System.out.println("Moved previous: " + movedPrev);
  }
}
