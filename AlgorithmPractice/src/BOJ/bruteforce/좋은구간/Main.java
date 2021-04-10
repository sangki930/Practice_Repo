package BOJ.bruteforce.좋은구간;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		
		List<Integer> list = Arrays.stream(br.readLine().split(" "))
				.map(a->Integer.parseInt(a))
				.collect(Collectors.toList());
		Collections.sort(list,(a,b)->a-b);
		list.add(0, 0);
		int n = Integer.parseInt(br.readLine());
		
		if (list.contains(n)) {
			System.out.println(0);
			return;
		}
		int left=0,right=0;
		for(int x : list) {
			if(n>x)
				left=x+1;
			else
			{
				right = x-1;
				break;
			}
		}
		
		System.out.print(right-left+(right-n)*(n-left));
		
		br.close();
		
	}
}
