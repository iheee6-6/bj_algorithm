import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n, w, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find(0, 0, n);
		System.out.println(w+"\n"+b);
	}

	static void find(int x1,int y1,int size) {
		if(checkColor(x1,y1,size)) {
			if(arr[x1][y1]==0) {
				w++;
			}else b++;
			return;
		}
		if(size/2>0) {
			find(x1,y1,size/2);
			find(x1+size/2,y1,size/2);
			find(x1,y1+size/2,size/2);
			find(x1+size/2,y1+size/2,size/2);
		}
	}
	static boolean checkColor(int x1,int y1,int size) {
		int color = arr[x1][y1];
		for(int i=x1;i<x1+size;i++) {
			for(int j=y1;j<y1+size;j++) {
				if(color!=arr[i][j]) return false;
			}
		}
		return true;
	}
}