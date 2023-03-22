import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int m, n, k,count;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			for (int j = ly; j <ry; j++) {
				for (int z = lx; z <rx; z++) {
					arr[j][z] = 1;
				}
			}
		}
		
		ArrayList<Integer> arrlist = new ArrayList<>();
		for (int j = 0; j < m; j++) {
			for (int z = 0; z < n; z++) {
				if(arr[j][z]==0) {
					count=0;
					find(j,z);
					arrlist.add(count);
				}
			}
		}
		
		Collections.sort(arrlist);
		StringBuilder sb = new StringBuilder();
		sb.append(arrlist.size()).append("\n");
		for(int i:arrlist) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
	static void find(int x, int y) {
		arr[x][y]=1;
		count++;
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy=y+dy[i];
			
			if(xx>=0&&yy>=0&&xx<m&&yy<n) {
				if(arr[xx][yy]==0) {
					find(xx,yy);
				}
			}
		}
	}

}
