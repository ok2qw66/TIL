import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 1. 좋아하는 학생이 많이 인접해 있는칸
 * 2. 1번중에서도 비어있는 칸이 가장 많은 칸
 * 3. 2번중에서도 행 작은순 > 열 작은순
 * */
public class Main {

	private static int N;
	private static ArrayList<int[]> preferList = new ArrayList<int[]>();
	private static int[][] board;
	private static ArrayList<Info> candidateList;
	private static int[][] d = {
			{0,1},{0,-1},{1,0},{-1,0}
	};
	
	static class Info{
		private int row;
		private int col;
		private int emptyCnt;
		
		public Info(int row, int col, int emptyCnt) {
			this.row = row;
			this.col = col;
			this.emptyCnt = emptyCnt;
		}

		@Override
		public String toString() {
			return "Info [row=" + row + ", col=" + col + ", emptyCnt=" + emptyCnt + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i <= N*N; i++) {
			preferList.add(i, new int[4]);
		}
		
		for (int i = 1; i <= N*N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int student = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 4; j++) {
				preferList.get(student)[j] = Integer.parseInt(st.nextToken());
			}
			
			firstStep(student);
		}
		System.out.println(calculScore());
	}
    
    private static int calculScore() {
		int totalSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tempScore = 0;
				for (int k = 0; k < 4; k++) {
					int ni = i + d[k][0];
					int nj = j + d[k][1];
					
					if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
					if(isFavorite(board[i][j], board[ni][nj])) tempScore++;
				}
				
				switch (tempScore) {
				case 0:
					totalSum += 0;
					break;
				case 1:
					totalSum += 1;
					break;
				case 2:
					totalSum += 10;
					break;
				case 3:
					totalSum += 100;
					break;
				case 4:
					totalSum += 1000;
					break;

				}
			}
		}
		return totalSum;
	}

	private static void firstStep(int student) {
		candidateList = new ArrayList<Info>();
		int favoriteMax = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int favoriteCnt=0;
				int emptyCnt = 0;
				for (int k = 0; k < 4; k++) {
					int ni = i + d[k][0];
					int nj = j + d[k][1];
					
					if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
					if(board[ni][nj]==0) emptyCnt++;
					else {
						if(isFavorite(student, board[ni][nj])) favoriteCnt++;
					}
				}
				
				if(board[i][j]==0) {
					if(favoriteCnt > favoriteMax) {
						favoriteMax = favoriteCnt;
						candidateList.clear();
						candidateList.add(new Info(i,j,emptyCnt));
					}else if(favoriteCnt == favoriteMax) {
						candidateList.add(new Info(i,j,emptyCnt));					
					}
				}
			}
		}
		
		secondStep(student);
	}

	private static boolean isFavorite(int student, int compare) {
		for (int fs : preferList.get(student)) {
			if(fs==compare) {
				return true;
			}
		}
		return false;
	}

	private static void secondStep(int student) {
		candidateList.sort(new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				if(o1.emptyCnt== o2.emptyCnt) {
					if(o1.row==o2.row)
						return o1.col - o2.col;
					return o1.row - o2.row;
				}
				return o2.emptyCnt - o1.emptyCnt;
			}
		});
		
		Info selected = candidateList.get(0);
		board[selected.row][selected.col] = student;
	}

}
