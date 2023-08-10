import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
	static int[][] dist;
	static int testCount = 0;

	static class Node implements Comparable<Node>{
		int x, y;
		int score;

		Node(int x, int y, int score) {
			this.x = x;
			this.y = y;
			this.score = score;
		}

		@Override
		public int compareTo(Node n1) {
			return this.score-n1.score;
		}
	}

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			map = new int[n][n];
			dist = new int[n][n];
			testCount++;

			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			System.out.println("Problem " + testCount + ": " + dij());
		}

	}

	static int dij() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		pq.offer(new Node(0, 0, map[0][0]));
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			for (int i = 0; i < 4; i++) {
				int xx = node.x + dx[i];
				int yy = node.y + dy[i];

				if (xx < 0 || yy < 0 || xx >= n || yy >= n)
					continue;
				if (dist[node.x][node.y] + map[xx][yy] < dist[xx][yy]) {
					dist[xx][yy] = Math.min(dist[node.x][node.y] + map[xx][yy], dist[xx][yy]);
					pq.add(new Node(xx, yy, dist[xx][yy]));
				}
			}
		}
		return dist[n - 1][n - 1];

	}

}
