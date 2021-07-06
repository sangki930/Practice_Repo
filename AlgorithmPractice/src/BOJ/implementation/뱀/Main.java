package BOJ.implementation.��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

public class Main {
	
	//��,��,��,��
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int map[][]= new int[n][n];
		
		//��� ��ġ
		LinkedList<Point> apples = new LinkedList<>();
		String input[];
		
		for(int i=0;i<k;i++) {
			input=br.readLine().split(" ");
			int y = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			map[y-1][x-1] = -1;
			apples.add(new Point(y,x));
		}
		
		int l = Integer.parseInt(br.readLine());
		
//		LinkedList<Turn> turns = new LinkedList<>();
		LinkedHashMap<Integer,String> turns = new LinkedHashMap<>();
		for(int i=0;i<l;i++) {
			input = br.readLine().split(" ");
			int time = Integer.parseInt(input[0]);
			String dir = input[1]; // L : ����, D : ������
			turns.put(time,dir);
			
		}
		
		LinkedList<Point> queue = new LinkedList<>();
		int x=0,y=0;
		map[y][x]=1;
		int dir=2; //ó���� ���������� ����

		int elapsed_time = 0;//���� ���� �ð�
		queue.add(new Point(x,y));
		
		while(true) {
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			// ���� ���� : 1, ��� : -1
			if(nx>=0 && ny>=0 && nx<n && ny<n && map[ny][nx]!=1) {
				//����� ������
				if(map[ny][nx]==0) {
					map[ny][nx]=1;
					queue.add(new Point(nx,ny));
					Point p = queue.poll();
					map[p.y][p.x]=0;
				}
				//��� ����
				if(map[ny][nx]==-1) {
					map[ny][nx]=1;
					queue.add(new Point(nx,ny));
				}
			}else {
				elapsed_time++;
				break;
			}
			x=nx;
			y=ny;
			elapsed_time++;
			// ������ ��ȯ�ϴ� �ð��� �����ϸ�
			if(turns.containsKey(elapsed_time)) {
				String tmp_dir = turns.get(elapsed_time);
				if(tmp_dir.equals("L")) {
					//���Ͽ��
					dir = (dir+1)%4;
				}else if(tmp_dir.equals("D")) {
					dir = (dir==0)? 3:dir-1;
				}
			}
		}
		System.out.println(elapsed_time);
		br.close();

	}

}
