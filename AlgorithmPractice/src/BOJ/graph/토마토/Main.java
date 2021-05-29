package BOJ.graph.≈‰∏∂≈‰;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x;
	int y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {

	static int dx[]= {0,0,-1,1};
	static int dy[]= {-1,1,0,0};
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String input[]=sc.nextLine().split(" ");
    	int m=Integer.parseInt(input[0]);
    	int n=Integer.parseInt(input[1]);
    	int map[][]=new int[n][m];
    	List<Point> tomato=new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		input=sc.nextLine().split(" ");
    		for(int j=0;j<input.length;j++) {
    			map[i][j]=Integer.parseInt(input[j]);
    			if(input[j].equals("1")) {
    				tomato.add(new Point(j,i));
    			}
    		}
    	}
    	int answer=0;

    		int dp[][]=new int[n][m];
        	boolean visited[][]=new boolean[n][m];
    		Queue<Point> queue=new LinkedList<>();
    		
    		for(Point p : tomato)
    			queue.offer(p);
    		while(!queue.isEmpty()) {
    			Point point=queue.poll();
    			for(int i=0;i<4;i++) {
    				int nx=point.x+dx[i];
    				int ny=point.y+dy[i];
    				
    				if(nx>=0 && ny>=0 && nx<m && ny<n &&
    						map[ny][nx]==0 && !visited[ny][nx]) {
    					map[ny][nx]=1;
    					visited[ny][nx]=true;
    					queue.offer(new Point(nx,ny));
    					dp[ny][nx]=dp[point.y][point.x]+1;
    					answer=Math.max(answer,dp[ny][nx]);
    				}
    				
    			}
    		}

    	
    	loop : for(int i=0;i<n;i++)
    		for(int j=0;j<m;j++)
    			if(map[i][j]==0)
    			{
    				answer=-1;
    				break loop;
    			}
    	System.out.println(answer);
    }
}
