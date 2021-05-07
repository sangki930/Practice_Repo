package Programmers.kakao2020Intern.경주로건설;

import java.util.*;
class Solution {
    class Point{
        int x,y,sum,dir;
        public Point(int x,int y,int sum,int dir){
            this.x=x;
            this.y=y;
            this.sum=sum;
            this.dir=dir;
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        int map[][]=board;
        int n = board.length;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,0,-1));
        map[0][0]=1;
        while(!queue.isEmpty()){
            
            Point p = queue.poll();
            if(p.x==n-1 && p.y==n-1){
                answer = Math.min(p.sum,answer);
                break;
            }
            
            
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<n && map[ny][nx]!=1){
                    int nx_sum=0;
                    
                    if(p.dir==-1 || p.dir==i)
                        nx_sum = p.sum+100;
                    else
                        nx_sum = p.sum+600;
                    
                    if(map[ny][nx]==0){
                        map[ny][nx] = nx_sum;
                        queue.add(new Point(nx,ny,nx_sum,i));
                    }else if(map[ny][nx]>=nx_sum){
                        map[ny][nx] = nx_sum;
                        queue.add(new Point(nx,ny,nx_sum,i));
                    }
                    
                }
                
            }
            
        }
        
        return answer;
    }
}
