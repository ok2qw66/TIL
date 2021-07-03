package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9081 {

	private static char[] inputStr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			inputStr = br.readLine().toCharArray();
			nextPerm();
			print();
		}

	}

	private static void print() {
		for (char c : inputStr) {
			System.out.print(c);
		}
		System.out.println();
	}

	private static void nextPerm() {
		int len = inputStr.length;
		for (int i = len-1; i>0; i--) {
			if(inputStr[i] > inputStr[i-1]) {
				swipe(i-1);
				AscSort(i-1);
				return;
			}
		}
	}

	private static void AscSort(int base) {
		char[] temp = new char[inputStr.length - base-1];
		int idx = 0;
		for (int i = base+1; i < inputStr.length; i++) {
			temp[idx++] = inputStr[i];
		}
		Arrays.sort(temp);
		idx = base+1;
		for (char c : temp) {
			inputStr[idx++] = c;
		}
	}

	private static void swipe(int base) {
		int len = inputStr.length;
		for (int i = len-1; i>0; i--) {
			if(inputStr[i] > inputStr[base]) {
				char temp = inputStr[base];
				inputStr[base] = inputStr[i];
				inputStr[i] = temp;
				return;
			}
		}
	}

}
