import java.math.BigInteger;
import java.util.Arrays;

public class Question1A {

    public static void main(String[] args) throws Exception {

        BigInteger[] results = new BigInteger[45];
        Arrays.fill(results, new BigInteger("-1"));

        System.out.println("Printing iterative results:");
        iterativeClifford(results);

        int pos = 0;
        for(BigInteger value : results ) {
            if(value.equals(new BigInteger("-1"))) break;
            System.out.println("[" + (pos++) + "] = " + value);
        }

    }

    public static void iterativeClifford(BigInteger[] cliffordResults){
        // O(n) complexity

        // initial cases
        cliffordResults[0] = new BigInteger("0");
        cliffordResults[1] = new BigInteger("1");

        for(int i=2; ; i++){
            BigInteger operation;
            
            if(i%2 == 0)
                operation = cliffordResults[i-1].add(
                                    cliffordResults[i-2].multiply(new BigInteger("2")));
            else 
                operation = cliffordResults[i-1].multiply(cliffordResults[i-2]);
            
            if( operation.compareTo(new BigInteger("1000")) > 0 ) {
                cliffordResults[i] = new BigInteger("-1");
                break;
            } else cliffordResults[i] = operation;

        }
    }

}

// n
// n-1 n-2
// n-2 n-3 n-3 n -4
// 