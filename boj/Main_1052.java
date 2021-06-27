package boj;

import java.util.Scanner;

public class Main_1052 {
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int K = sc.nextInt();
	    sc.close();
	    
	    int count = Integer.bitCount(N);
        int bottles_merged = (int) Math.pow(2, Integer.toBinaryString(N).length() - 1);
        int bottles_left = N - bottles_merged;
        int new_bottle = 0;

        while (count > K && bottles_merged > bottles_left) {
            bottles_left += 1;
            new_bottle += 1;
            count = Integer.bitCount(bottles_left) + 1;
        }

        System.out.println(new_bottle);
	}

}
