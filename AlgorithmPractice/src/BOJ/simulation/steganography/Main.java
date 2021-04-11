package BOJ.simulation.steganography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Deque<Integer> dq = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String temp = br.readLine();
			if(temp.length()==1 && temp.equals("#"))
				break;
			else if (temp.length() == 1 && temp.equals("*")) {
	            while (true) {
	                if (dq.size() % 5 == 0) {
	                    break;
	                }
	                dq.add(0);
	            }
	            while (true) {
	                if (dq.isEmpty()) {
	                    break;
	                }
	                int result = 0;
	                for (int i = 0; i < 5; i++) {
	                    result += dq.pollFirst() * Math.pow(2, 4 - i);
	                }
	                if (result<=0) {
	                    System.out.print(" ");
	                }
	                else if (1 <= result && result <= 26) {
	                    System.out.print((char)(result - 1 + 'A'));
	                }
	                else if (result == 27) {
	                    System.out.print("'");
	                }
	                else if (result == 28) {
	                    System.out.print(",");
	                }
	                else if (result == 29) {
	                    System.out.print("-");
	                }
	                else if (result == 30) {
	                    System.out.print(".");
	                }
	                else {
	                    System.out.print("?");
	                }
	            }
	            System.out.print("\n");
	            dq.clear();
	        }
	        else {
	            int consecutive = 0; 
	            
	            for (int i = 0; i < temp.length(); i++) {
	                if (temp.charAt(i) == ' ') {
	                    consecutive++;
	                }
	                else {
	                    if (consecutive>0 && consecutive % 2 != 0) {
	                        dq.add(0);
	                    }
	                    else if (consecutive>0 && consecutive % 2 == 0) {
	                        dq.add(1);
	                    }
	                    consecutive = 0;
	                }
	            }
	            if (consecutive>0) {
	                if (consecutive % 2!=0) {
	                    dq.add(0);
	                }
	                else {
	                    dq.add(1);
	                }
	                consecutive = 0;
	            }
	            
	        }
			
		}
		
		br.close();
	}

}
