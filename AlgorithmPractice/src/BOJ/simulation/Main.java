package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		int[] king = new int[] {input[0].charAt(0)-'A',input[0].charAt(1)-'1'};// 열, 행
		int[] stone = new int[] {input[1].charAt(0)-'A',input[1].charAt(1)-'1'};// 열, 행
		
//		R : 한 칸 오른쪽으로
//		L : 한 칸 왼쪽으로
//		B : 한 칸 아래로
//		T : 한 칸 위로
//		RT : 오른쪽 위 대각선으로
//		LT : 왼쪽 위 대각선으로
//		RB : 오른쪽 아래 대각선으로
//		LB : 왼쪽 아래 대각선으로
		
		for(int i=0;i<Integer.parseInt(input[2]);i++) {
			String s = br.readLine();
			
			switch(s) {
			case "R"->{
				
				// 이동 가능할 때
				if(king[0]+1>=0 && king[0]+1<8) {
					king[1]++;
					if(king[0]+1==stone[0] && (stone[0]+1>=0 && stone[0]+1<8)) {
						stone[1]++;
					}
				}
				
			}
			case "L"->{
				// 이동 가능할 때
				if(king[0]-1>=0 && king[0]-1<8) {
					king[0]--;
					if(king[0]-1==stone[0] && (stone[0]-1>=0 && stone[0]-1<8)) {
						stone[0]--;
					}
				}
			}
			case "B"->{
				// 이동 가능할 때
				if(king[1]+1>=0 && king[1]+1<8) {
					king[1]++;
					if(king[1]-1==stone[1] && (stone[1]-1>=0 && stone[1]-1<8)) {
						stone[1]++;
					}
				}
			}
			case "T"->{
				// 이동 가능할 때
				if(king[1]-1>=0 && king[1]-1<8) {
					king[1]--;
					if(king[1]-1==stone[1] && (stone[1]-1>=0 && stone[1]-1<8)) {
						stone[1]--;
					}
				}
			}
			case "RT"->{
				// 이동 가능할 때
				if(king[0]+1>=0 && king[0]+1<8 && king[1]-1>=0 && king[1]-1<8) {
					king[1]--;
					king[0]++;
					if(king[0]+1==stone[0] && (stone[0]-1>=0 && stone[0]-1<8) &&
							king[1]-1==stone[1] && (stone[1]-1>=0 && stone[1]+1<8)) {
						stone[1]++;
						stone[0]--;
					}
				}
			}
			case "LT"->{
				// 이동 가능할 때
				if(king[0]-1>=0 && king[0]-1<8 && king[1]-1>=0 && king[1]-1<8) {
					king[1]--;
					king[0]--;
					if(king[0]-1==stone[0] && (stone[0]-1>=0 && stone[0]-1<8) &&
							king[1]-1==stone[1] && (stone[1]-1>=0 && stone[1]-1<8)) {
						stone[1]--;
						stone[0]--;
					}
				}
			}
			case "RB"->{
				// 이동 가능할 때
				if(king[0]+1>=0 && king[0]+1<8 && king[1]+1>=0 && king[1]+1<8) {
					king[1]++;
					king[0]++;
					if(king[0]+1==stone[0] && (stone[0]+1>=0 && stone[0]+1<8) &&
							king[1]+1==stone[1] && (stone[1]+1>=0 && stone[1]+1<8)) {
						stone[1]++;
						stone[0]++;
					}
				}
			}
			case "LB"->{
				// 이동 가능할 때
				if(king[0]-1>=0 && king[0]-1<8 && king[1]+1>=0 && king[1]+1<8) {
					king[1]++;
					king[0]--;
					if(king[0]-1==stone[0] && (stone[0]-1>=0 && stone[0]-1<8) &&
							king[1]+1==stone[1] && (stone[1]+1>=0 && stone[1]+1<8)) {
						stone[1]++;
						stone[0]--;
					}
				}
			}
			
			}
			
		}
		System.out.print((char)(king[0]+'A')+""+(king[1]+1)+"\n"+(char)(stone[0]+'A')+""+(stone[1]+1));
		br.close();
	}

}
