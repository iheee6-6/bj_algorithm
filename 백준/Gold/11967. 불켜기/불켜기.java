import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static ArrayList<Point>[][] switchs;
	static boolean[][] visited;
	static boolean[][] isLight;
	static boolean[][] isMove;
	static int cnt = 1;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();

		visited = new boolean[N][N];
		isLight = new boolean[N][N];
		isMove = new boolean[N][N];

		switchs = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				switchs[i][j] = new ArrayList<>();
			}
		}

		for(int i = 0; i < M; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;

			switchs[x][y].add(new Point(a, b));
		}

		bfs();

		System.out.println(cnt);
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visited[0][0] = isLight[0][0] = true;

		while(!queue.isEmpty()) {
			int cx = queue.peek().x;
			int cy = queue.poll().y;

			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

				isMove[nx][ny] = true;
			}

			for(int i = 0; i < switchs[cx][cy].size(); i++) {
				Point p = switchs[cx][cy].get(i);

				if(!isLight[p.x][p.y]) {
					isLight[p.x][p.y] = true;
					cnt++;
				}

				if(isMove[p.x][p.y] && !visited[p.x][p.y]) {
					visited[p.x][p.y] = true;
					queue.add(new Point(p.x, p.y));
				}
			}

			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; 
				if(visited[nx][ny] || !isMove[nx][ny] || !isLight[nx][ny]) continue; 
				
				visited[nx][ny] = true;
				queue.add(new Point(nx, ny));
			}
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}