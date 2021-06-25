package BOJ.너비_우선_탐색.벽_부수고_이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class Point{
	int x;
	int y;
	int dis;
	boolean wall;
	public Point(int x,int y,int dis, boolean wall) {
		this.x=x;
		this.y=y;
		this.dis=dis;
		this.wall=wall;
	}
}

public class Main {

	static int[][] init;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[][] dis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
//		LinkedList<Point> list = new LinkedList<>();
		LinkedList<Point> queue = new LinkedList<>();
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		dis = new int[n][m];
		for(int i=0;i<n;i++) {
			char c[] = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(c[j]=='1') {
					dis[i][j]=-1;
				}else if(c[j]=='0')
					dis[i][j]=Integer.MAX_VALUE;
			}
		}
		System.out.println("반응하나?");
		queue.add(new Point(0,0,1,false));
		dis[0][0]=1;
		boolean v[][]=new boolean[n][m];
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			
		}
		
		br.close();
	}


}
