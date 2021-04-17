import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2239 {

	private static int[][] sudoku;
	private static ArrayList<int[]> empty;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9]; //행, 렬
		empty = new ArrayList<int[]>();
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				int number = line.charAt(j) - '0';
				if(number==0)	empty.add(new int[] {i,j});
				sudoku[i][j] = number;
			}
		}
		
		puzzle(0);
		
	}

	private static boolean puzzle(int eptIdx) {
		if(eptIdx==empty.size()) {
			print();
			return true;
		}
		int[] current = empty.get(eptIdx);
		if(!check(eptIdx, current)) return false;
		return true;
	}

	private static boolean check(int eptIdx, int[] current) {
		int i = current[0];
		int j = current[1];
		for (int n = 1; n <= 9; n++) {
			if(isPossible(i,j,n)) {
				sudoku[i][j] = n;
				if(puzzle(eptIdx+1)) return true;
				sudoku[i][j] = 0;
			}
		}
		return false;
	}

	private static boolean isPossible(int i, int j, int n) {
		if(!rowColCheck(i,j,n)) return false;
		if(!subSquareCheck(i,j,n)) return false;
		return true;
	}
	
	private static boolean subSquareCheck(int i, int j, int n) {
		for (int row=i/3*3,r=0; r<3 ; r++,row++) {
			for (int col=j/3*3,c=0; c<3; c++,col++) {
				if(sudoku[row][col]==n) return false;
			}
		}
		return true;
	}

	private static boolean rowColCheck(int row, int col, int target) {
		for (int j = 0; j < 9; j++) {
			if(sudoku[row][j]==target) return false;
			if(sudoku[j][col]==target) return false;
		}
		return true;
	}

	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

}
