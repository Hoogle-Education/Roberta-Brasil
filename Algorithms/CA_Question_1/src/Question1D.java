import java.math.BigInteger;
import java.util.Arrays;

public class Question1D {

    public static void main(String[] args) throws Exception {

        // clifford calculation
        BigInteger[] cliffordResults = new BigInteger[40];
        Arrays.fill(cliffordResults, new BigInteger("-1"));
        iterativeClifford(cliffordResults);
        
        // fibonacci calculation
        BigInteger[] fibonacciResults = new BigInteger[45];
        Arrays.fill(fibonacciResults, new BigInteger("-1"));
        nextFibonacci(40, fibonacciResults);

        int i=0, j=0;
        BigInteger none = new BigInteger("-1");

        while( !cliffordResults[i].equals(none) && !fibonacciResults[j].equals(none) ){
          if( cliffordResults[i].equals(fibonacciResults[j]) ){
            System.out.println("An equal value in both sequences!");
            System.out.println("Clifford[" + i + "] = " + cliffordResults[i++]);
            System.out.println("Fibonacci[" + j + "] = " + fibonacciResults[j++]);
          } else if( cliffordResults[i].compareTo(fibonacciResults[j]) > 0 ) j++;
          else i++;
        }

    }

    public static void iterativeClifford(BigInteger[] cliffordResults){
        cliffordResults[0] = new BigInteger("0");
        cliffordResults[1] = new BigInteger("1");

        for(int i=2; i<40; i++){            
            if(i%2 == 0)
                cliffordResults[i] = cliffordResults[i-1].add(
                                cliffordResults[i-2].multiply(new BigInteger("2")));
            else 
                cliffordResults[i] = cliffordResults[i-1].add(cliffordResults[i-2]);
        }
    }

    public static BigInteger nextFibonacci(int position, BigInteger[] fibonacciResults){

      // base case      
      fibonacciResults[0] = new BigInteger("0");
      fibonacciResults[1] = new BigInteger("1");

      // dinamic programming case
      // if its already setted
      if(!fibonacciResults[position].equals(new BigInteger("-1"))) 
        return fibonacciResults[position];

      // iterative case
      for(int i=2; i<=position; i++){
        fibonacciResults[i] = fibonacciResults[i-1].add(fibonacciResults[i-2]);
      }

      // result
      return fibonacciResults[position];
    }

}

// n
// n-1 n-2
// n-2 n-3 n-3 n -4
// 