package BOJ.string.단어정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String arr[]=new String[n];
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine();
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr,(a,b)->{
			if(a.length()==b.length())
				return a.compareTo(b);
			return Integer.compare(a.length(), b.length());
		});
		for(String str : arr)
			if(!sb.toString().contains(str))
				sb.append(str+"\n");
		
		System.out.println(sb.toString());
		
		br.close();
	}

}
