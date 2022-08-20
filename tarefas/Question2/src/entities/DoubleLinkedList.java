package entities;

public class DoubleLinkedList {
  
  Node first;
  Node last;

  public DoubleLinkedList() {
  }

  public DoubleLinkedList(int value){
    first = new Node(value);
    last = first;
  }

  public void append(int value){

    if(first == null){
      first = new Node(value);
      last = first;
    } else if(first == last){
      first.next = new Node(first, value);
      last = first.next;
      last.prev = first.next;
    } else {
      
    }

  }

}
