package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10973 {

	private static int N;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int i = N-1;
		for (; i>0 ; i--) {
			if(arr[i] < arr[i-1]) {
				change(i-1);
				descArrange(i-1);
				break;
			}
		}
		
		if(i==0)
			System.out.println("-1");
		else {
			for (int num : arr) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
			
	}

	private static void descArrange(int start) {
		int[] subArr = new int[N-1-start];
		int subIdx = 0;
		for (int i = start+1; i <= N-1; i++) {
			subArr[subIdx++] = arr[i];
		}
		Arrays.sort(subArr);
		int arrIdx = N-1;
		for (int i : subArr) {
			arr[arrIdx--] = i;
		}
	}

	private static void change(int start) {
		for (int i = N-1; i > start ; i--) {
			if(arr[i] < arr[start]) {
				int temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
				return;
			}
		}
	}

}
