package twoDArrayDS;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
    	int maxSum = Integer.MIN_VALUE;
    	for(int rowPlus = 0;rowPlus<4;rowPlus++) {
    		for(int colPlus = 0;colPlus<4;colPlus++) {
    			int sum = 0;
    			for(int row=0;row<3;row++) {
    				for(int col=0;col<3;col++) {
    					if(row==1 && (col==0||col==2)) continue;
    					sum+=arr[row+rowPlus][col+colPlus];
    				}
    			}
    			maxSum = (sum>maxSum)? sum:maxSum;
    		}//end 2ndFor
    	}
    	return maxSum;

    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
