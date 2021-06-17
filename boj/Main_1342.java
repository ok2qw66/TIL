package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1342 {
	private static int[] arr = new int[26];
	private static int[] makeStr;
	private static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		makeStr = new int[input.length];
		for (char c : input) {
			arr[c-'a']++;
		}
		
		make(-1, 0);
		System.out.println(count);
	}
	private static void make(int prev, int current) {
		if(current==makeStr.length) {
			count++;
			return;
		}
		
		for (int i = 0; i < 26; i++) {
			if(i!=prev && arr[i]!=0) {
				makeStr[current] = i;
				arr[i]--;
				make(i, current+1);
				arr[i]++;
			}
		}
		
	}

}
