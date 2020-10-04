package equalStacks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
	public static int smallestOfThree(int a,int b,int c) {
		if(a<=b && a<=c) return a;
		if(b<=a && b<=c) return b;
		else return c;
	}
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    	Queue<Integer> s1 = new LinkedList<Integer>(h1);
    	Queue<Integer> s2 = new LinkedList<Integer>(h2);
    	Queue<Integer> s3 = new LinkedList<Integer>(h3);
    	int sum1,sum2,sum3;
    	sum1 = sum2 = sum3 = 0;
    	for(int i:s1) {
    		sum1+=i;
    	}
    	for(int i:s2) {
    		sum2+=i;
    	}
    	for(int i:s3) {
    		sum3+=i;
    	}
    	int min = smallestOfThree(sum1, sum2, sum3);
    	while(sum1 != sum2 || sum1 != sum3) {
    		if(sum1>min) {
    			sum1 -= s1.peek();
    			s1.remove();
    		}
    		if(sum2>min) {
    			sum2 -= s2.peek();
    			s2.remove();
    		}
    		if(sum3>min) {
    			sum3 -= s3.peek();
    			s3.remove();
    		}
    		min = smallestOfThree(sum1, sum2, sum3);
    	}
    	return min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
