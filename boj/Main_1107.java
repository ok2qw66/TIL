import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int STARTCHANNEL = 100;
	private static int answer;
	private static boolean[] isBroken = new boolean[10];
	private static int TARGET;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TARGET = Integer.parseInt(br.readLine());
		answer = Math.abs(TARGET-STARTCHANNEL);
		int M = Integer.parseInt(br.readLine());
		if(M==0) {
			System.out.println(Math.min(String.valueOf(TARGET).length(), answer));
		}else if(M==10) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			System.out.println(answer);
		}else {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < M; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
			
			int length = findLength();
			
			findSmallNum(length,0,0);
			findBigNum(length,0,0);
			System.out.println(answer);
		}
		
	}
	private static int findLength() {
		int i = 0;
		if(i==TARGET) return 1;
		while(Math.pow(10,i) <= TARGET) {
			i++;
		}
		return i;
	}
	
	private static boolean findSmallNum(int length, int processNum, int isUp) {
		if(length==0) {
			checkAnswer(processNum);
			return true;
		}
		
		int current = (TARGET/(int)(Math.pow(10, length-1))) %10;
		
		if(isUp==0) {
			int tempCurrent = current+1;
			while(--tempCurrent>=0) {
				if(tempCurrent==0 && processNum==0 && length!=1) {
					return findSmallNum(length-1,processNum, 1);
				}else if(!isBroken[tempCurrent]) {
					if(findSmallNum(length-1, (int) (processNum + tempCurrent * Math.pow(10, length-1)), tempCurrent==current?0:1)) return true;
				}
			}
			
		}else {
			for (int i = 9; i >=0; i--) {
				if(!isBroken[i])
					if(findSmallNum(length-1, (int) (processNum + i * Math.pow(10, length-1)), 1)) return true;
			}
		}
		
		return false;
	}
	
	
	private static boolean findBigNum(int length, int processNum, int isUp) {
		if(length==0) {
			checkAnswer(processNum);
			return true;
		}
		
		int current = (TARGET/(int)(Math.pow(10, length-1))) %10;
		
		if(isUp==0) {
			int tempCurrent = current-1;
			while(++tempCurrent<=10) {
				if(tempCurrent==10 && processNum==0) {
					return findBigNum(length+1,processNum, -1);
				}if(tempCurrent!=10 && !isBroken[tempCurrent]) {
					if(findBigNum(length-1, (int) (processNum + tempCurrent * Math.pow(10, length-1)), tempCurrent==current?0:-1)) return true;
				}
			}
		}else {
			int i = 0;
			if(processNum==0) i++;
			for (; i<10; i++) {
				if(!isBroken[i])
					if(findBigNum(length-1, (int) (processNum + i * Math.pow(10, length-1)), 1)) return true;
			}
		}
		
		return false;
	}
	
	private static void checkAnswer(int processNum) {
		int compare = String.valueOf(processNum).length() + Math.abs(TARGET-processNum);
		answer = Math.min(compare, answer);
	}
}
