package BOJ.수학.약수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			long arr[]=new long[n];
			String input[]=br.readLine().split(" ");
			long min=Long.MAX_VALUE,max=-1L;
			for(int i=0;i<n;i++)
			{
				long m =Long.parseLong(input[i]);
				min=Math.min(min, m);
				max=Math.max(max, m);
			}
			System.out.println(min*max);
			br.close();
	}

}
