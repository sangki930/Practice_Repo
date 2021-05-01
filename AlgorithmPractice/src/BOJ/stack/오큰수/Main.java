package BOJ.stack.오큰수;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//리더 생성
		int n = Integer.parseInt(br.readLine());
		// 사이즈 입력
		int[] a= new int[n];
		// 배열 생성
		int[] ans = new int[n];
		int[] ai = new int[n];
		// 정답 배열, 정답 인덱스 배열 생성
		
		String[] tmp = br.readLine().split(" ");
		// 임시로 입력을 받음
		
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(tmp[i]);
		//int로 변환
		
		Stack<Integer> s = new Stack<>();
		//스택 생성
		
		s.push(0);
		
		for(int i=1;i<n;i++) {
			if(s.isEmpty())
				s.push(i);
			//반복문에 들어올 때, 스택이 비어있으면 인덱스 저장
			
			while(!s.isEmpty() && a[s.peek()]<a[i]) {
				//비어있지 않고 숫자가 인덱스 가장 위쪽 숫자보다 크면
				ans[s.pop()]=a[i];
				//정답 배열 중 스택의 가장 위쪽 숫자와 같은 인덱스에 i번째 숫자를 넣는다.
			}
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			//반복문을 다 돌고 나왔는 데 스택이 비어있지 않다면 빌 때 까지
			ans[s.pop()]=-1;
			//stack에 쌓인 index에 -1을 넣고
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
            // 출력한다
        }
        bw.write("\n");
        bw.flush();
		
	}

}
