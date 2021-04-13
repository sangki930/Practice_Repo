package BOJ.graph.네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Pair{
	int s;
	int e;
	int v;
	public Pair(int s,int e,int v) {
		this.s=s;
		this.e=e;
		this.v=v;
	}
}

public class Main {

	
	static int[] parents;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		parents=new int[n+1];
		
		for(int i=1;i<=n;i++)
			parents[i]=i;
		
		PriorityQueue<Pair> pq=new PriorityQueue<>(
				(a,b)->Integer.compare(a.v, b.v)
				);
		
		for(int i=0;i<m;i++) {
			String[] input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			int v = Integer.parseInt(input[2]);
			
			pq.offer(new Pair(s,e,v));
		}
		int ans=0,Ecnt=0;
		
		while(!pq.isEmpty()) {
			if(Ecnt==n-1)
				break;
			Pair cur = pq.poll();
			if(cur.s==cur.e)
				continue;
			if(find(cur.s)!=find(cur.e)) {
				Ecnt++;
				union(cur.s,cur.e);
				ans+=cur.v;
			}
		}
		System.out.println(ans);
		
		br.close();
		
	}
	

		static int find(int a) {
			if(parents[a] == a) return a;
			return find(parents[a]);
		}
	
		static void union(int a, int b) {	
			parents[find(a)] = find(b);
		}

}
