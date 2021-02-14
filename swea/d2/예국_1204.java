import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int test = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			
			HashMap<String,Integer> count = new HashMap<>();
			
			while(st.hasMoreTokens()) {
				String score = st.nextToken();
				if(count.containsKey(score)) {
					count.put(score, count.get(score)+1);
				}else {
					count.put(score, 1);
				}
			}
			
			List<String> keySetList = new ArrayList<>(count.keySet());
			
			Collections.sort(keySetList, (o1, o2) -> (count.get(o2).compareTo(count.get(o1))));
			
			int answer = Integer.parseInt(keySetList.get(0)), repeat = count.get(keySetList.get(0)); 
			
			for (String key : keySetList) {
				if(count.get(key) < repeat) break;
				if(answer < Integer.parseInt(key)) {
					answer = Integer.parseInt(key);
				}
			}
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
