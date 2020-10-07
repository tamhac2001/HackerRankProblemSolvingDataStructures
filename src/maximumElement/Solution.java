package maximumElement;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack= new Stack<Integer>();
        String temp="";
        temp = sc.nextLine();
        int queryCount = Integer.parseInt(temp);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<queryCount;i++) {
        	if(sc.hasNextLine()) {
        		temp = sc.nextLine();
        	}
        	switch(temp.charAt(0)) {
        	case'1':{
        		int x = Integer.parseInt(temp.substring(2));
        		if(x>max) max=x;
        		stack.push(x);
        		break;
        	}
        	case'2':{
        		if(!stack.isEmpty()) {
        			if(stack.peek()==max) max=Integer.MIN_VALUE;
        			stack.pop();
        		}
        		break;
        	}
        	case'3':{
        		if(max==Integer.MIN_VALUE) {
        			for(int j:stack) {
        				if(j>max) max=j;
        			}
        		}
        		System.out.println(max);
        		break;
        	}
        	}//end of switch
        }
    }
}