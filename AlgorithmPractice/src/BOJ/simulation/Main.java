package BOJ.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[]=br.readLine().split(" ");
		
		int[] king = new int[] {input[0].charAt(0)-'A',input[0].charAt(1)-'1'};// ��, ��
		int[] stone = new int[] {input[1].charAt(0)-'A',input[1].charAt(1)-'1'};// ��, ��
		
//		R : �� ĭ ����������
//		L : �� ĭ ��������
//		B : �� ĭ �Ʒ���
//		T : �� ĭ ����
//		RT : ������ �� �밢������
//		LT : ���� �� �밢������
//		RB : ������ �Ʒ� �밢������
//		LB : ���� �Ʒ� �밢������
		
		for(int i=0;i<Integer.parseInt(input[2]);i++) {
			String s = br.readLine();
			
			switch(s) {
			case "R"->{
				
				// �̵� ������ ��
				if(king[0]+1>=0 && king[0]+1<8) {
					king[1]++;
					if(king[0]+1==stone[0] && (stone[0]+1>=0 && stone[0]+1<8)) {
						stone[1]++;
					}
				}
				
			}
			case "L"->{
				// �̵� ������ ��
				if(king[0]-1>=0 && king[0]-1<8) {
					king[0]--;
					if(king[0]-1==stone[0] && (stone[0]-1>=0 && stone[0]-1<8)) {
						stone[0]--;
					}
				}
			}
			case "B"->{
				// �̵� ������ ��
				if(king[1]+1>=0 && king[1]+1<8) {
					king[1]++;
					if(king[1]-1==stone[1] && (stone[1]-1>=0 && stone[1]-1<8)) {
						stone[1]++;
					}
				}
			}
			case "T"->{
				// �̵� ������ ��
				if(king[1]-1>=0 && king[1]-1<8) {
					king[1]--;
					if(king[1]-1==stone[1] && (stone[1]-1>=0 && stone[1]-1<8)) {
						stone[1]--;
					}
				}
			}
			case "RT"->{
				// �̵� ������ ��
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
				// �̵� ������ ��
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
				// �̵� ������ ��
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
				// �̵� ������ ��
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
