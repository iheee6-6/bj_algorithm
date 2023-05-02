import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int height,index;
		Node(int height,int index){
			this.height=height;
			this.index=index;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Node> s = new Stack<>();

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int h = Integer.parseInt(st.nextToken());
			int result = 0;
			while (!s.isEmpty()) {
				Node temp2 = s.peek();
				if (h < temp2.height) {
					result=temp2.index;
					break;
				}else  s.pop();
			}
			sb.append(result).append(" ");
			s.add(new Node(h,i));
		}

		System.out.println(sb);
	}

}
