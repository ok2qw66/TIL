package boj;

import java.util.Scanner;

public class Main_1747 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		boolean[] notPrime = new boolean[1120212];
		notPrime[1] = true;
		
		if(N<=2)
			System.out.println(2);
		else {
			for (int i = 3; i < 1120212; i+=2) {
				if(!notPrime[i]) {
					if(i>=N) {
						if(isPallendrom(i)) {
							System.out.println(i);
							break;
						}
					}
					
					int num = i+i;
					while(num<1120212) {
						notPrime[num] = true;
						num += i;
					}
				}
			}
		}
		
	}

	private static boolean isPallendrom(int target) {
		char[] verify = String.valueOf(target).toCharArray();
		int len = verify.length;
		for (int i = 0; i < len/2; i++) {
			if(verify[i]!=verify[len-i-1])
				return false;
		}
		return true;
	}

}
