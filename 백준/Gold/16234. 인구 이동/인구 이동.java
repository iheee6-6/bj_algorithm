import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, l, r, result = 0;
	static int[][] arr;
	static boolean check = false;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static ArrayList<Node> list;
	static boolean[][] visited;

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simul();

		System.out.println(result);
	}

	static void simul() {
		while (true) {
			check = false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						int sum = bfs(i, j);
						if (list.size() > 1) {
							change(sum);
							check = true;
						}
					}

				}
			}

			if (!check)
				break;
			result++;
		}
	}

	static void change(int sum) {
		int value = sum / list.size();
		for (Node node : list) {
			arr[node.x][node.y] = value;
		}
	}

	static int bfs(int x, int y) {
		list = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));

		int sum = arr[x][y];
		list.add(new Node(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];

				if (xx < 0 || yy < 0 || xx >= n || yy >= n || visited[xx][yy])
					continue;
				int dist = Math.abs(arr[node.x][node.y] - arr[xx][yy]);
				if (dist >= l && dist <= r) {
					sum += arr[xx][yy];
					q.add(new Node(xx, yy));
					list.add(new Node(xx, yy));
					visited[xx][yy]=true;
				}
			}
		}

		return sum;
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 2; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];

			if (xx < 0 || yy < 0 || xx >= n || yy >= n)
				continue;
			int dist = Math.abs(arr[x][y] - arr[xx][yy]);
			if (dist >= l && dist <= r) {
				// comb[x][y] = true;
				// comb[xx][yy] = true;
			}
		}

	}
}
