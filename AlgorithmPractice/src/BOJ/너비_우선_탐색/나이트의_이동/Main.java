package BOJ.너비_우선_탐색.나이트의_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x;
	int y;
	int level;
	public Point(int x,int y,int level) {
		this.x=x;
		this.y=y;
		this.level=level;
	}
}

public class Main {

	static int dir[][]= {
			{1,2},
			{2,1},
			{2,-1},
			{-1,2},
			{1,-2},
			{-2,1},
			{-1,-2},
			{-2,-1}
	};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		
		for(int i=0;i<c;i++) {
			int n = Integer.parseInt(br.readLine());
			String input[]=br.readLine().split(" ");
			int s_x = Integer.parseInt(input[0]);
			int s_y = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			int e_x = Integer.parseInt(input[0]);
			int e_y = Integer.parseInt(input[1]);
			
			if(s_x == e_x && s_y == e_y) {
				System.out.println(0);
				continue;
			}
			
			Queue<Point> queue = new LinkedList<>();
			queue.offer(new Point(s_x,s_y,0));
			boolean v[][]=new boolean[n][n];
			int cnt=0;
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				
				if(p.x==e_x && p.y==e_y)
				{
					System.out.println(p.level);
					break;
				}
				if(v[p.x][p.y]) {
					
					continue;
				}
				v[p.x][p.y]=true;
				for(int j=0;j<dir.length;j++) {
					int nx = p.x+dir[j][0];
					int ny = p.y+dir[j][1];
					int level = p.level;
					if(nx>=0 && nx<n && ny>=0 && ny<n)
						queue.offer(new Point(nx,ny,level+1));
				}
				
			}
			
		}
		
		br.close();
	}

}
