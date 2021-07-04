package BOJ.queue.프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Doc {
	int id; // 문서번호
	int p; // 우선순위

	public Doc(int id, int p) {
		this.id = id;
		this.p = p;
	}

	@Override
	public String toString() {
		return "Doc [id=" + id + ", p=" + p + "]";
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int n,m,cnt;
		for(int i=0;i<t;i++) {
			cnt=0;
			LinkedList<Doc> queue = new LinkedList<>();
			String input[]=br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				queue.offer(new Doc(j,Integer.parseInt(input[j])));
			}
			
			while(!queue.isEmpty()) {
				Doc now = queue.poll();
				boolean able = true;
				for(Doc d : queue) {
					if(d.p>now.p)
						able=false;
				}
				
				if(able) {
					cnt++;
					if(now.id==m)break;
				}else
					queue.offer(now);
			}
			System.out.println(cnt);
		}
		
		br.close();
	}

}