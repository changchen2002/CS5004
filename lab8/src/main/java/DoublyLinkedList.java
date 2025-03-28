public class DoublyLinkedList<T>{
  public class Node<T>{
    private T data;
    private Node<T> next;
    private Node<T> prev;

    Node(T data, Node<T> next, Node<T> prev){
      this.data = data;
      this.next = next;
      this.prev = prev;
    }

    public T getData() {
      return this.data;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public DoublyLinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void addFirst(T data){
    Node<T> newNode = new Node<T>(data, head, null);
    if (head != null) {
      head.prev = newNode;
    }
    head = newNode;
    if (tail == null){
      tail = newNode;
    }
    size++;
  }

  public void addLast(T data){
    Node<T> newNode = new Node<T>(data, null, tail);
    if (tail != null) {
      tail.next = newNode;
    }
    tail = newNode;
    if (head == null){
      head = newNode;
    }
    size++;
  }

  public boolean delete(T data){
    if (head == null) return false;
    if (head.data.equals(data)){
      if (head.next != null) {
        head.next.prev = null;
      }
      else {
        tail = null;
      }
      head = head.next;
      size--;
      return true;
    }

    Node<T> curr = head;
    while (curr != null) {
      if (curr.data.equals(data)) {
        if (curr.next != null) {
          curr.next.prev = curr.prev;
        }
        else {
          tail = curr.prev;
        }
        curr.prev.next = curr.next;
        size--;
        return true;
      }
      curr = curr.next;
    }
    return false;
  }

  public void displayForward(){
    Node<T> curr = head;
    int i = 1;
    while(curr != null){
      System.out.println(i + ". " + curr.getData());
      curr = curr.next;
      i++;
    }
  }

  public void displayBackward(){
    Node<T> curr = tail;
    int i = size - 1;
    while(curr != null){
      System.out.println(i + ". " + curr.getData());
      curr = curr.prev;
      i--;
    }
  }

  public int size(){
    return size;
  }

  public String getDataAtIndex(int index){
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of range");
    }

    Node<T> curr = head;
    for (int i = 0; i < index; i++){
      curr = curr.next;
    }
    return curr.getData().toString();
  }
}
