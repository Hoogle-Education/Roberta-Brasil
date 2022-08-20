import utilities.MyList;

public class App {
    public static void main(String[] args) throws Exception {
    
        MyList list = new MyList(2);

        list.add_back(3);
        list.add_back(7);

        System.out.println(list);

    }
}
