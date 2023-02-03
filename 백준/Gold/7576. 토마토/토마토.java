import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, result;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class dot {
		int x;
		int y;

		dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(result==-1?result:result-1);
	}

	static void bfs() {
		Queue<dot> q = new LinkedList<dot>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					q.add(new dot(i, j));
				}
			}
		}
		while (!q.isEmpty()) {
			dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = d.x + dx[i];
				int yy = d.y + dy[i];
				if (xx < 0 || yy < 0 || xx >= n || yy >= m)
					continue;
				if (arr[xx][yy] != 0)
					continue;
				arr[xx][yy] = arr[d.x][d.y] + 1;
				q.add(new dot(xx, yy));
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j]==0) {
					result=-1;
					return;
				}
				result =Math.max(arr[i][j],result);
			}
		}
	}

}