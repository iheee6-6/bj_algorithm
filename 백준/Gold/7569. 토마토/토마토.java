import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n, h, yet = 0, count = 0;
	static int[][][] arr;
	static boolean[][][] check;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<Dot> q;

	static class Dot {
		int x, y, z;

		Dot(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[n][m][h];
		q = new LinkedList<>();
		check = new boolean[n][m][h];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int z = 0; z < m; z++) {
					arr[j][z][i] = Integer.parseInt(st.nextToken());
					if (arr[j][z][i] == 0)
						yet++;
					else if (arr[j][z][i] == 1)
						q.add(new Dot(j, z, i));
				}
			}
		}

		check = new boolean[n][m][h];
		while (!q.isEmpty()) {
			find(q.poll());
		}
		System.out.println(yet==0?(count==0?0:count-1):-1);

	}

	static void find(Dot d) {
		for (int i = 0; i < 6; i++) {
			int xx = d.x + dx[i];
			int yy = d.y + dy[i];
			int zz = d.z + dz[i];
			if (xx >= 0 && yy >= 0 && zz >= 0 && xx < n && yy < m && zz < h && !check[xx][yy][zz]) {
				check[xx][yy][zz] = true;
				if (arr[xx][yy][zz] == 0) {
					yet--;
					arr[xx][yy][zz] = arr[d.x][d.y][d.z]+1;
					count=Math.max(count, arr[xx][yy][zz]);
					q.add(new Dot(xx, yy, zz));
				} else if (arr[xx][yy][zz] == 1) {
					q.add(new Dot(xx, yy, zz));
				}
			}
		}
	}

}
