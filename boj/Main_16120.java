package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16120 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] verify = br.readLine().toCharArray();
		int pCnt = 0; //idx이전에 p의 개수
		int length = verify.length;
		boolean pause = false;
		
		for (int idx = 0; idx < length; idx++) {
			if(pause) { // A뒤에는 무조건P가 나와야한다
				if(verify[idx]=='A') {
					break;
				}else {
					pause = false;
				}
			}else if(verify[idx]=='A') {
				if(pCnt >= 2) { //앞에 최소P가2개있어야함
					pause = true;
					pCnt --; //PP(AP) --> P로 만들기
				}else {
					pause = true;
					break;
				}
			}else { //P의 개수증가
				pCnt++;
			}
		}

		if(pause || pCnt>1)	System.out.println("NP");
		else	System.out.println("PPAP");
	}

}
