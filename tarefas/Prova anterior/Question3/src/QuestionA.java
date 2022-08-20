public class QuestionA {
  
  public static void main(String[] args) {
    
    Person[] array = new Person[5];

    array[0] = new Person("Jhon", "Silva", 23, "12907120-1");
    array[1] = new Person("Maria", "Silva", 27, "12907120-1");
    array[2] = new Person("Pedro", "Silva", 53, "12907120-1");
    array[3] = new Person("Matheus", "Silva", 22, "12907120-1");
    array[4] = new Person("Marta", "Silva", 32, "12907120-1");

    bubbleSort(array);

    for (Person person : array) {
      System.out.println(person);
    }

  }

  public static void bubbleSort(Person[] array){
    
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        if(array[i].compareTo(array[j]) < 0){
          Person temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }

  }

}
