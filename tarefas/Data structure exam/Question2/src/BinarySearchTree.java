import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree <T extends Comparable<T>> implements BinarySearch<T>{
 
  Node<T> root;

  @Override
  public void add(T element) {
        if(isEmpty()) root = new Node<T>(element);
        else add(element, root);
  }

  private void add(T element, Node<T> current){

    if(element.compareTo(current.element) < 0){
      if(current.left == null) // is anyone in left ?
        current.left = new Node<>(element);
      else
        add(element, current.left);
    } else {
      if(current.right == null) // is anyone in right ?
        current.right = new Node<>(element);
      else 
        add(element, current.right);
    }

  }

  @Override
  public boolean isEmpty() {
    return (root == null) ? true : false;
  }

  @Override
  public int count() {
    return count(root);
  }

  public int count(Node<T> current){

    if(current == null)
      return 0;
    else 
      return 1 + count(current.left) + count(current.right);
    

  }

  @Override
  public T max() {
    if(isEmpty()) throw new TreeAcessException();
    else return max(root);
  }

  public T max(Node<T> current){
    if(current.right == null) return current.element;
    else return max(current.right);
  }

  @Override
  public T min() {
    if(isEmpty()) throw new TreeAcessException();
    else return min(root);
  }

  public T min(Node<T> current){
    if(current.left == null) return current.element;
    else return max(current.left);
  }

  @Override
  public String toString() {
    String aux = "BinarySearchTree [\n" ;
    Queue<Node<T>> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){

      aux += queue.element().toString();
      aux += "\n";
      
      if(queue.element().right != null) 
        queue.add(queue.element().right);
      
      if(queue.element().left != null) 
        queue.add(queue.element().left);
        
      queue.remove();

    }
    
    return aux + "\n]";
  }

}
