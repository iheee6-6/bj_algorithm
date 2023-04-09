import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, max = 0;
	static int[][] arr;
	static ArrayList<Dot> virusList;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Dot {
		int x, y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		virusList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					virusList.add(new Dot(i, j));
			}
		}

		dfs(0);
		

		System.out.println(max);
	}

	static void dfs(int tempcnt) {
		if(tempcnt==3) {
			bfs();
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					arr[i][j]=1;
					dfs(tempcnt+1);
					arr[i][j]=0;
				}
			}
		}
	}
	static void bfs() {
		int[][] temparr = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				temparr[i][j]=arr[i][j];
		}
		Queue<Dot> q = new LinkedList<>();
		for(Dot d:virusList)
			q.add(d);
		while (!q.isEmpty()) {
			Dot d= q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = d.x + dx[i];
				int yy = d.y + dy[i];
				if (xx < 0 || yy < 0 || xx >= n || yy >= m)
					continue;
				if (temparr[xx][yy] == 0) {
					temparr[xx][yy]=2;
					q.add(new Dot(xx,yy));
				}
			}
		}
		check(temparr);
	}

	static void check(int[][] tempArr) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tempArr[i][j] == 0)
					count++;
			}
		}
		max = Math.max(max, count);
	}
}
