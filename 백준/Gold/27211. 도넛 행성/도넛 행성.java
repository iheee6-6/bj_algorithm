import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] check;
	static int N, M, result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0 && !check[i][j]) {
					result++;
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] { i, j });
					check[i][j] = true;
					while (!q.isEmpty()) {
						int xx = q.peek()[0];
						int yy = q.poll()[1];
						for (int d = 0; d < 4; d++) {
							int xx2 = xx + dx[d];
							int yy2 = yy + dy[d];
							if (xx2 == -1)
								xx2 = N - 1;
							else if (xx2 == N)
								xx2 = 0;
							if (yy2 == -1)
								yy2 = M - 1;
							else if (yy2 == M)
								yy2 = 0;
							if (arr[xx2][yy2] == 0 && !check[xx2][yy2]) {
								q.add(new int[] { xx2, yy2 });
								check[xx2][yy2] = true;
							}
						}
					}
				}
			}
		}

		// dfs 시간초과
		/*
		 * for (int i = 0; i < N; i++) { for (int j = 0; j < M; j++) { if (arr[i][j] ==
		 * 0 && !check[i][j]) { dfs(i, j); result++; } } }
		 */
		System.out.println(result);
	}

	static void dfs(int x, int y) {
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx == -1)
				xx = N - 1;
			else if (xx == N)
				xx = 0;
			if (yy == -1)
				yy = M - 1;
			else if (yy == M)
				yy = 0;
			if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
				if (arr[xx][yy] == 0 && !check[xx][yy]) {
					dfs(xx, yy);
				}
			}
		}
	}

}