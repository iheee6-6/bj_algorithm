import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Node> arr = new ArrayList<>();

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int total = 0;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Node(x, y));
			if (i >= 1) {
				total += Math.abs(arr.get(i - 1).x - arr.get(i).x) + Math.abs(arr.get(i - 1).y - arr.get(i).y);
			}
		}

		int min = total;
		for (int i = 1; i < n - 1; i++) {
			Node node = arr.get(i);
			int original = Math.abs(arr.get(i - 1).x - node.x) + Math.abs(arr.get(i - 1).y - node.y)
					+ Math.abs(node.x - arr.get(i + 1).x) + Math.abs(node.y - arr.get(i + 1).y);
			int jump = Math.abs(arr.get(i - 1).x - arr.get(i + 1).x) + Math.abs(arr.get(i - 1).y - arr.get(i + 1).y);
			min = Math.min(min, total - original + jump);
		}
		System.out.println(min);

	}

}
