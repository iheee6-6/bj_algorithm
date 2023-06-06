import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map; // 사과 있는 곳은 1
	static int[] dirTime; // -1이 왼, +1이 오
	static Queue<Integer> prevDir; // -1이 왼, +1이 오
	static int answer = 1;
	static int n, k;
	static int nowDir = 0;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int nowX = 1, nowY = 1, nowSize = 1, endX = 1, endY = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		dirTime = new int[10001];
		prevDir= new LinkedList<>();
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			dirTime[x] = dir == 'L' ? -1 : 1;
		}

		map[1][1] = 2;
		move();
		System.out.println(answer);
	}

	static void move() {
		while (true) {
			prevDir.add(nowDir);
			nowX += dx[nowDir];
			nowY += dy[nowDir];

			if (nowX <= 0||nowY<=0||nowX>n||nowY>n || map[nowX][nowY] == 2)
				return;
			if (map[nowX][nowY] == 1) {
				nowSize++;
			} else {
				map[endX][endY] = 0;

				int prev= prevDir.poll();
				endX += dx[prev];
				endY += dy[prev];
			}
			map[nowX][nowY] = 2;

			if (dirTime[answer] == -1 || dirTime[answer] == 1) {
				nowDir += dirTime[answer];
				if(nowDir==-1) nowDir=3;
				else if(nowDir==4) nowDir=0;
			}

			answer++;
		}
	}

}
