import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<FireBall>[][] map;
	static ArrayList<FireBall> list = new ArrayList<>();
	static int N, M, K, count;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int result = 0;

	static class FireBall {
		int r;
		int c;
		int m;
		int s;
		int d;

		FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = new ArrayList<FireBall>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new FireBall(x, y, m, s, d));
		}

		while (K-- > 0) {
			move();
			checkFireBall();
		}

		for(FireBall fb:list) {
			result+=fb.m;
		}
		System.out.println(result);
	}

	static void move() {
		for (FireBall fb : list) {
			int tx = fb.r + dx[fb.d] * (fb.s % N);
			int ty = fb.c + dy[fb.d] * (fb.s % N);
			if (tx < 1) {
				tx = N + tx;
			} else if (tx > N) {
				tx = tx - N;
			}

			if (ty < 1) {
				ty = N + ty;
			} else if (ty > N) {
				ty = ty - N;
			}
			
			fb.r = tx;
			fb.c = ty;
			map[tx][ty].add(fb);
		}
	}

	static void checkFireBall() {
		for (int i = 1; i < N + 1; i++) {
			for (int z = 1; z < N + 1; z++) {
				if (map[i][z].size() == 1) {
					map[i][z].clear();
				} else if (map[i][z].size() > 1) {
					int mSum = 0;
					int sSum = 0;
					boolean even = map[i][z].get(0).d % 2 == 0 ? true : false;
					boolean odd = map[i][z].get(0).d % 2 == 1 ? true : false;
					for (FireBall fb : map[i][z]) {
						mSum += fb.m;
						sSum += fb.s;
						even = even & fb.d % 2 == 0 ? true : false;
						odd = odd & fb.d % 2 == 1 ? true : false;
						list.remove(fb);
					}
					int newM = mSum / 5;
					int size = map[i][z].size();
					map[i][z].clear();

					if (newM != 0) {
						int newS = sSum / size;
						if (even | odd) {
							for (int a = 0; a < 8; a += 2) {
								list.add(new FireBall(i, z, newM, newS, a));
							}
						} else {
							for (int a = 1; a < 8; a += 2) {
								list.add(new FireBall(i, z, newM, newS, a));
							}
						}
					}
				}
			}
		}
	}

}
