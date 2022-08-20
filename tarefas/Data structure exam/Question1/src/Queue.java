public class Queue {
 
  Node first;
  Node last;

  public void add(CPUJob job){
    
    if(first == null){
      first = new Node(job);
      last = first;
    } else {
      // add at the end
      Node aux = new Node(job);
      last.next = aux;
      last = aux;
    }

  }

  public boolean isEmpty(){
    if(first == null) return true;
    else return false;
  }

  public int readySize(){
    Node current = first;
    int size = 0;

    while(current != null){
      size++;
      current = current.next;
    }

    return size;
  }

  public double get_average(){

    Node current = first;
    int timeRunning = 0;

    double sum = 0.0;

    while(current != null){
      sum += timeRunning - current.job.getArrivalTime();
      timeRunning += current.job.getBurstTime();
      current = current.next;
    }

    return sum/(double)readySize();
  }

  public double get_averageTurnroundTime(){
    Node current = first;
    int timeRunning = 0;

    double sum = 0.0;
    while(current != null){
      timeRunning += current.job.getBurstTime();
      int turnroundTime = timeRunning - current.job.getArrivalTime();
      sum += (double)turnroundTime;
      current = current.next;
    }

    return sum/(double)readySize();
  }

  public void remove(){
    
    if(first == null) return;

    first = first.next;
  }

  public void print() throws InterruptedException {
    Node current = first;
    int timeRunning = 0;

    while (current != null){
      
      System.out.println("Time " + timeRunning + ": The process " + current.job.getName() + " has arrived into pool!");
      System.out.println("Time " + timeRunning + ":Process " + current.job.getName() + "has been sent to CPU and is executed for " + current.job.getBurstTime() + " time intervals");
      Thread.sleep((long)(current.job.getBurstTime()*1000));

      timeRunning += current.job.getBurstTime();
      current = current.next;
    }
  }

}
