import java.math.BigInteger;
import java.util.Arrays;

public class Question1B {

    public static void main(String[] args) throws Exception {

        BigInteger[] results = new BigInteger[45];
        Arrays.fill(results, new BigInteger("-1"));

        System.out.println("Recursive results:");
        
        for(int i=0; ;i++){
            BigInteger value = recursiveClifford(i);
            if(value.compareTo(new BigInteger("1000")) > 0) break;
            System.out.println( "[" + i + "] = " + value );
        }

    }

    public static BigInteger recursiveClifford(int n){
      // O(2^n) complexity

      // base cases
      if(n == 0) return new BigInteger("0");
      else if(n == 1) return new BigInteger("1");

      // recursive cases
      BigInteger value;
      if(n%2 == 0) 
          value = recursiveClifford(n-1).add(
                            recursiveClifford(n-2).multiply(new BigInteger("2")));
      else 
          value = recursiveClifford(n-1).multiply(recursiveClifford(n-2));

      return value;
  }

}

// n
// n-1 n-2
// n-2 n-3 n-3 n -4
// 