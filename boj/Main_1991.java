package boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1991 {
	
	static class Node{
		String current;
		String leftChild;
		String rightChild;
		
		public Node(String current, String leftChild, String rightChild) {
			super();
			this.current = current;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		@Override
		public String toString() {
			return "Node [current=" + current + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
		}
		
		
	}

	private static Node[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			tree[root.charAt(0)-'A'] = new Node(root, left, right);
		}

		preTraversal(0);
		System.out.println();
		inTraversal(0);
		System.out.println();
		postTraversal(0);
	}

	private static void postTraversal(int current) {
		if(!tree[current].leftChild.equals("."))
			postTraversal(tree[current].leftChild.charAt(0)-'A');
		if(!tree[current].rightChild.equals("."))
			postTraversal(tree[current].rightChild.charAt(0)-'A');
		System.out.print(tree[current].current);
	}

	private static void inTraversal(int current) {
		if(!tree[current].leftChild.equals("."))
			inTraversal(tree[current].leftChild.charAt(0)-'A');
		System.out.print(tree[current].current);
		if(!tree[current].rightChild.equals("."))
			inTraversal(tree[current].rightChild.charAt(0)-'A');
	}

	private static void preTraversal(int current) {
		System.out.print(tree[current].current);
		if(!tree[current].leftChild.equals("."))
			preTraversal(tree[current].leftChild.charAt(0)-'A');
		if(!tree[current].rightChild.equals("."))
			preTraversal(tree[current].rightChild.charAt(0)-'A');
	}

}
