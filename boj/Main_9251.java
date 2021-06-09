package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*CAPCK
AA
2
확인하기!*/

public class Main_9251 {
	private static int answer = 0;
	private static ArrayList[] alphaIndex = new ArrayList[26];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		for (int i = 0; i < 26; i++) {
			alphaIndex[i] = new ArrayList<Integer>();
		}

		if(str1.length > str2.length) {
			makeAlphaIndex(str2);
			searchAnswer(str1);
		}else {
			makeAlphaIndex(str1);
			searchAnswer(str2);			
		}
		
		System.out.println(answer);
		
	}
	private static void searchAnswer(char[] big) {
		int[][] prevIndexInfo = new int[2][big.length];
		
		for (int i = 0; i < big.length; i++) {
			ArrayList<Integer> temp = alphaIndex[big[i]-'A'];
			int tempLen = temp.size();
			int tempIdx = 0; // temp index
			int prevIndex = 0; // 기존 dp index
		
			
			while(tempIdx<tempLen) {
				//System.out.println(prevIndex+" "+tempIdx+" "+temp.get(tempIdx));
				if(prevIndex < temp.get(tempIdx)) {
					if(prevIndexInfo[0][prevIndex]+1 > prevIndexInfo[1][temp.get(tempIdx)]) {
						prevIndexInfo[1][temp.get(tempIdx)] = prevIndexInfo[0][prevIndex]+1;
					}
					prevIndex++;
				}else if(prevIndex >= temp.get(tempIdx)) {
					if(prevIndexInfo[1][temp.get(tempIdx)]==0)
						prevIndexInfo[1][temp.get(tempIdx)] = 1;
					tempIdx++;
				}
			}
			
			for (int j = 0; j < big.length; j++) {
				int cur = prevIndexInfo[1][j];
				if(cur!=0)
					prevIndexInfo[0][j] = cur;
				answer = Math.max(answer, cur);
			}
			//System.out.println(Arrays.toString(prevIndexInfo[0]));
			
		}
	}
	// index : 0(A) ~ 25(Z) & value: 해당 알파벳이 나온 index리스트
	private static void makeAlphaIndex(char[] small) {
		for (int i = 0; i < small.length; i++) {
			alphaIndex[small[i]-'A'].add(i);
		}
	}

}
