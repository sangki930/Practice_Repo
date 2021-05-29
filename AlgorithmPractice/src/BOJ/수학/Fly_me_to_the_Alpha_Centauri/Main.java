package BOJ.¼öÇÐ.Fly_me_to_the_Alpha_Centauri;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int dis = y-x;
			
			int max = (int)Math.sqrt(dis);
			
			if (max==Math.sqrt(dis)) {
				System.out.println(max*2-1);
			}else if(dis<=max*(max+1)) {
				System.out.println(max*2);
			}else
				System.out.println(max*2+1);
		}
		
	}

}
