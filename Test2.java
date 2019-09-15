import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Scanner;

enum STATE {
    PERFECT,
    ABUNDANT,
    DEFICIENT;
}
public class Test2 {
    public static void main(String[] args) {
    	 System.out.println("START:");
    	 
    	Scanner sc = new Scanner (System.in);
    	
    	System.out.println("Please, enter the number");
    	
    	int number = sc.nextInt();
    	
        System.out.println(number + " is "+PerfectNumber.detect(number));
    }
}
class PerfectNumber {
    public static STATE detect(int k) {
        return process(k);
    }

    public static STATE process(int i) {
        int sum = IntStream
                .range(1, i)
                .filter(j -> i % j == 0)
                .sum();
        if(sum == i)
            return STATE.PERFECT;
        if (sum < i)
            return STATE.DEFICIENT;
        else
            return STATE.ABUNDANT;
    }

    public static Set<Integer> divisors(int k) {
        return IntStream
                .range(1, k + 1)
                .filter(i -> k % i == 0)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
    }
}