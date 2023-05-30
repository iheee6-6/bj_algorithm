import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr;
	static int[][] marr;

	static ArrayList<Cloud> cloudTemp;
	static ArrayList<Cloud> cloud;
	static boolean[][] visited;

	static class Cloud {
		int x, y;

		Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		marr = new int[m][2];
		cloudTemp = new ArrayList<>();
		cloud = new ArrayList<>();
		cloud.add(new Cloud(n - 1, 0)); // n-1,0 n-1 1, n-2 0, n-2 1
		cloud.add(new Cloud(n - 1, 1));
		cloud.add(new Cloud(n - 2, 0));
		cloud.add(new Cloud(n - 2, 1));
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			marr[i][0] = Integer.parseInt(st.nextToken()); // 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
			marr[i][1] = Integer.parseInt(st.nextToken());
		}

		solution();

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > 0)
					result += arr[i][j];
			}
		}

		System.out.println(result);
	}

	static void solution() {
		for (int i = 0; i < m; i++) {
			cloudMove(i);
			magic();
			cloud = new ArrayList<>();
			minus();
		}
	}

	static void minus() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] >= 2&&!visited[i][j]) {
					arr[i][j] -= 2;
					if (arr[i][j] < 0)
						arr[i][j] = 0;
						cloud.add(new Cloud(i, j));
				}else visited[i][j]=false;
			}
		}
	}

	static void magic() {
		for (Cloud c : cloud) {
			int count = 0;
			if (c.x - 1 >= 0 && c.x - 1 < n && c.y - 1 >= 0 && c.y - 1 < n && arr[c.x - 1][c.y - 1] > 0)
				count++;
			if (c.x + 1 >= 0 && c.x + 1 < n && c.y - 1 >= 0 && c.y - 1 < n && arr[c.x + 1][c.y - 1] > 0)
				count++;
			if (c.x + 1 >= 0 && c.x + 1 < n && c.y + 1 >= 0 && c.y + 1 < n && arr[c.x + 1][c.y + 1] > 0)
				count++;
			if (c.x - 1 >= 0 && c.x - 1 < n && c.y + 1 >= 0 && c.y + 1 < n && arr[c.x - 1][c.y + 1] > 0)
				count++;
			arr[c.x][c.y] += count;
		}
	}

	static void cloudMove(int idx) {
		for (Cloud c : cloud) {
			int dir = marr[idx][0];
			int len = marr[idx][1];

			int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
			int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

			c.x = (n + c.x + dx[dir-1] * (len % n)) % n;
			c.y = (n + c.y + dy[dir-1] * (len % n)) % n;
			arr[c.x][c.y]++;
			visited[c.x][c.y] = true;
		}
	}
}
