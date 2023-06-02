import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, result = Integer.MAX_VALUE;
	static int emptySpace = 0;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Node> list;
	static Node[] activeVirusList;

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
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		list = new ArrayList<>();
		activeVirusList = new Node[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					list.add(new Node(i, j));
				else if (map[i][j] == 0)
					emptySpace++;
			}
		}

		if (emptySpace == 0) {
			System.out.println(0);
			return;
		}
		comb(0, 0);

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	static void comb(int idx, int count) {
		if (count == m) {
			spread(emptySpace);
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			activeVirusList[count] = list.get(i);
			comb(i + 1, count + 1);
		}
	}

	static void spread(int emptySpace) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			q.add(activeVirusList[i]);
			visited[activeVirusList[i].x][activeVirusList[i].y] = true;
		}
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				Node node = q.poll();
				for (int i = 0; i < 4; i++) {
					int xx = node.x + dx[i];
					int yy = node.y + dy[i];

					if (xx < 0 || yy < 0 || xx >= n || yy >= n || visited[xx][yy] || map[xx][yy] == 1)
						continue;

					if (map[xx][yy] == 0) {
						emptySpace--;
					}

					q.add(new Node(xx, yy));
					visited[xx][yy] = true;
				}
			}
			time++;
			if (time >= result)
				return;
			if (emptySpace == 0)
				result = time;
		}

	}

}
