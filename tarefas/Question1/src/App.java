import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        int[] results = new int[20];
        Arrays.fill(results, -1);

        System.out.println("Printing iterative results:");
        iterativeClifford(results);
        for(int value : results ) {
            if(value == -1) break;
            System.out.println(value);
        }

        System.out.println("Recursive results:");
        for(int i=0; ;i++){
            int value = recursiveClifford(i);
            if(value > 1000) break;
            System.out.println( value );
        }

    }

    public static void iterativeClifford(int[] cliffordResults){
        // O(n) complexity

        // initial cases
        cliffordResults[0] = 0;
        cliffordResults[1] = 1;

        for(int i=2; ; i++){
            int operation;
            
            if(i%2 == 0)
                operation = cliffordResults[i-1] + 2*cliffordResults[i-2];
            else 
                operation = cliffordResults[i-1] * cliffordResults[i-2];
            
            if(operation > 1000) {
                cliffordResults[i] = -1;
                break;
            } else cliffordResults[i] = operation;

        }
    }

    public static int recursiveClifford(int n){
        // O(2^n) complexity

        // base cases
        if(n == 0) return 0;
        else if(n == 1) return 1;

        // recursive cases
        int value;
        if(n%2 == 0) 
            value = recursiveClifford(n-1) + 2*recursiveClifford(n-2);
        else 
            value = recursiveClifford(n-1) * recursiveClifford(n-2);

        return value;
    }

}

// n
// n-1 n-2
// n-2 n-3 n-3 n -4
// 