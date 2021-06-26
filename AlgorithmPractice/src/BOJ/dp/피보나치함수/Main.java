package BOJ.dp.피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][]=new int[41][2];
		arr[0][0] =1;//0의 개수 1
		arr[1][1] =1;//1의 개수 1
		for(int i=2;i<arr.length;i++) {
			for(int j=0;j<2;j++) {
				arr[i][j]=arr[i-1][j]+arr[i-2][j];
			}
		}
		
		while(n-->0) {
			
			int temp = Integer.parseInt(br.readLine());
			System.out.println(arr[temp][0]+" "+arr[temp][1]);
		}
		br.close();
		
	}

}
