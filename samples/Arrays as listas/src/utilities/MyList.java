package utilities;

public class MyList {
  
  private int[] array;

  public MyList(int element){
    array = new int[1];
    array[0] = element;
  }

  public int size(){
    return array.length;
  }

  public void add_back(int newValue){

      int[] copy = array;
      int len = size();
      array = new int[ len + 1 ];

      for(int i=0; i<len; i++){
        array[i] = (int)copy[i];
      }
      
      array[len-1] = newValue;
  }

  @Override
  public String toString(){
    String aux = "[ ";

    for(int x : array){
      aux += x + " ";
    }

    aux += "]";

    return aux;
  }

}
