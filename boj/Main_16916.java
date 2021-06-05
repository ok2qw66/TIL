package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_16916 {

	private static char[] s;
	private static char[] p;
	private static int[] fail;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		p = br.readLine().toCharArray();
		
		createFail();
		System.out.println(isSubStr());

	}
	// 부분 문자열인지 확인 함수
	private static int isSubStr() {
		int j = 0;
		int len = 0;
		for (int i = 0; i < s.length;) {
			if(len == p.length) break;
			if(s[i]==p[j]) { // 일치한다면
				len++;
				i++;
				j++;
			}else if(j==0) { // 돌아갈 곳이 없다면
				i++;
				len = 0;
			}else{ // 돌아가기
				j = fail[j-1];
				len = j;
			}
		}
		return len==p.length? 1: 0;
	}
	
	// 실패 함수 만들기
	private static void createFail() {
		fail = new int[p.length];
		int j =  0;
		for (int i = 1; i < p.length;) {
			if(p[i]==p[j]) { //일치한다면
				fail[i++] = j+1;
				j++;
			}else if(j==0) { // 돌아갈 곳이 없다면
				fail[i++] = 0;
			}
			else { //돌아가기
				j = fail[j-1];
			}
		}
	}
	

}
