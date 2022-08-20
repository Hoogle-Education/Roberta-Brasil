package entities;

public class Node {
  
  int value;
  Node next;
  Node prev;

  public Node(int value){
    this.value = value;
    next = null;
    prev = null;
  }

  public Node(Node prev, int value){
    this.prev = prev;
    this.value = value;
    next = null;
  }

}
