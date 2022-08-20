public class Person implements Comparable<Person> {
  
  private String name;
  private String secondName;
  private int age;
  private String document;
  
  public Person(String name, String secondName, int age, String document) {
    this.name = name;
    this.secondName = secondName;
    this.age = age;
    this.document = document;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  @Override
  public int compareTo(Person other) {
    int calc = Integer.compare(this.age, other.age);

    if(calc == 0) return 0;
    else if(calc > 0) return 1;
    else return -1;
    
  }

  @Override
  public String toString() {
    return "Person [age=" + age + ", document=" + document + ", name=" + name + ", secondName=" + secondName + "]";
  }  

}
