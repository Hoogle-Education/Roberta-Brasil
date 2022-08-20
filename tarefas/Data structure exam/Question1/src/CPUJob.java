public class CPUJob {
  
  private String name;
  private int arrivalTime;
  private int burstTime;
  
  public CPUJob(String name, int arrivalTime, int burstTime) {
    this.name = name;
    this.arrivalTime = arrivalTime;
    this.burstTime = burstTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public int getBurstTime() {
    return burstTime;
  }

  public void setBurstTime(int burstTime) {
    this.burstTime = burstTime;
  }

  @Override
  public String toString() {
    return "CPU Job"
            + "\n| Name: " + name
            + "\n| Arrival Time: " + arrivalTime 
            + "\n| CPU Burst Time: " + burstTime;
  }

    

}
