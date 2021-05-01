package BOJ.stack.��ū��;

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
		//���� ����
		int n = Integer.parseInt(br.readLine());
		// ������ �Է�
		int[] a= new int[n];
		// �迭 ����
		int[] ans = new int[n];
		int[] ai = new int[n];
		// ���� �迭, ���� �ε��� �迭 ����
		
		String[] tmp = br.readLine().split(" ");
		// �ӽ÷� �Է��� ����
		
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(tmp[i]);
		//int�� ��ȯ
		
		Stack<Integer> s = new Stack<>();
		//���� ����
		
		s.push(0);
		
		for(int i=1;i<n;i++) {
			if(s.isEmpty())
				s.push(i);
			//�ݺ����� ���� ��, ������ ��������� �ε��� ����
			
			while(!s.isEmpty() && a[s.peek()]<a[i]) {
				//������� �ʰ� ���ڰ� �ε��� ���� ���� ���ں��� ũ��
				ans[s.pop()]=a[i];
				//���� �迭 �� ������ ���� ���� ���ڿ� ���� �ε����� i��° ���ڸ� �ִ´�.
			}
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			//�ݺ����� �� ���� ���Դ� �� ������ ������� �ʴٸ� �� �� ����
			ans[s.pop()]=-1;
			//stack�� ���� index�� -1�� �ְ�
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
            // ����Ѵ�
        }
        bw.write("\n");
        bw.flush();
		
	}

}
