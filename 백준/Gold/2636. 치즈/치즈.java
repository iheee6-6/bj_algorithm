import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int h, w, Hcount = 0, count = 0,cheese=0;
	static int cheeseTemp=0;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static Queue<Dot> q;
	
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
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					cheese+=1;
				}
			}
		}

		while(cheese>0) {
			check = new boolean[h][w];
			bfs(0,0);
			Hcount++;
			count= cheeseTemp;
			cheese-=cheeseTemp;
			cheeseTemp=0;
		}
		

		System.out.println(Math.abs(Hcount));
		System.out.println(count);
	}

	static void bfs(int x,int y) {
		q = new LinkedList<>();
		q.add(new Dot(x,y));
		while (!q.isEmpty()) {
			Dot d = q.poll();
			find(d.x, d.y);
		}
		setZero();
	}
	static void setZero() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]==2) arr[i][j]=0;
			}
		}
	}
	static void find(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < h && yy < w && xx >= 0 && yy >= 0&&!check[xx][yy]) {
				check[xx][yy]=true;
				if (arr[xx][yy]==0) {
					q.add(new Dot(xx, yy));
				}
				else if (arr[xx][yy] ==1) {
					arr[xx][yy] = 2;
					cheeseTemp++;
				}
			}
		}
	}

}
