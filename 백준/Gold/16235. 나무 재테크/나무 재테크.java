import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[][] A;
	static Deque<Tree> q;
	static Queue<Tree> deadQ;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class Tree {
		int x;
		int y;
		int old;

		Tree(int x, int y, int old) {
			this.x = x;
			this.y = y;
			this.old = old;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		A = new int[N + 1][N + 1];
		q = new LinkedList<>();
		deadQ = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int old = Integer.parseInt(st.nextToken());
			q.add(new Tree(r, c, old));
		}

		int count = M;
		while (K-- > 0) {
			// 봄
			int tempC = count;
			while (tempC-- > 0) {
				Tree t = q.poll();
				if (arr[t.x][t.y] >= t.old) {
					arr[t.x][t.y] -= t.old;
					t.old += 1;
					q.add(t);
				} else {
					deadQ.add(t);
					count--;
				}
			}

			// 여름
			while (!deadQ.isEmpty()) {
				Tree t = deadQ.poll();
				arr[t.x][t.y] += t.old / 2;
			}

			// 가을
			tempC = count;
			Queue<Tree> tempQ = new LinkedList<>();
			for (Tree t : q) {
				if (t.old % 5 == 0) {
					tempQ.add(t);
				}
			}
			
			while (!tempQ.isEmpty()) {
				Tree t = tempQ.poll();
				for (int i = 0; i < 8; i++) {
					int xx = t.x + dx[i];
					int yy = t.y + dy[i];
					if (xx > 0 && yy > 0 && xx < N + 1 && yy < N + 1) {
						q.addFirst(new Tree(xx, yy, 1));
						count++;

					}
				}

			}

			// 겨울
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					arr[i][j] += A[i][j];
				}
			}
		}

		System.out.println(count);
	}

}
