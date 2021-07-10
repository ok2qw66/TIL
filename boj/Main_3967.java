package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3967 {
	private static boolean[] isUsed = new boolean[12];
	private static int[] arr = new int[12];
	private static int MAX = 12;
	private static char[][] star = new char[5][9];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			star[i] = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				if(star[i][j]!='.' && star[i][j]!='x') {
					int tt = star[i][j]-'A';
					isUsed[tt] = true;
					arr[idx++] = tt+1;
				}
			}
		}
		
		findAnswer(0);

	}
	private static boolean findAnswer(int i) {
		System.out.println(i);
		if(i==MAX-1) return check();
		
		if(arr[i]!=0) {
			return findAnswer(i+1);
		}
		
		for (int j = 0; j < 12; j++) {
			if(!isUsed[j]) {
				isUsed[j] = true;
				arr[i] = j+1;
				if(findAnswer(i+1))
					return true;
				isUsed[j] = false;
			}
		}
		
		return false;
			
	}
	private static boolean check() {
		int[] t = new int[6];
		t[0] = arr[1] + arr[2] + arr[3] + arr[4];
		t[1] = arr[0] + arr[2] + arr[5] + arr[7];
		t[2] = arr[0] + arr[3] + arr[6] + arr[10];
		t[3] = arr[7] + arr[8] + arr[9] + arr[10];
		t[4] = arr[11] + arr[8] + arr[5] + arr[1];
		t[5] = arr[11] + arr[9] + arr[6] + arr[4];
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(t));
		
		for (int i = 1; i < 6; i++) {
			if(t[0] != t[i])
				return false;
		}
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < 9; j++) {
				if(star[i][j]!='.') {
					star[i][j] =  (char) (arr[idx++]-1 + 'A');
				}
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		return true;
	}

}
