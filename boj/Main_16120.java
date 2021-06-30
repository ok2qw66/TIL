package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16120 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] verify = br.readLine().toCharArray();
		int pCnt = 0; //idx������ p�� ����
		int length = verify.length;
		boolean pause = false;
		
		for (int idx = 0; idx < length; idx++) {
			if(pause) { // A�ڿ��� ������P�� ���;��Ѵ�
				if(verify[idx]=='A') {
					break;
				}else {
					pause = false;
				}
			}else if(verify[idx]=='A') {
				if(pCnt >= 2) { //�տ� �ּ�P��2���־����
					pause = true;
					pCnt --; //PP(AP) --> P�� �����
				}else {
					pause = true;
					break;
				}
			}else { //P�� ��������
				pCnt++;
			}
		}

		if(pause || pCnt>1)	System.out.println("NP");
		else	System.out.println("PPAP");
	}

}
