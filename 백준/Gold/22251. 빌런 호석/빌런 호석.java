import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result = 0, n, p, k, x;
	static int[][] arr = { { 0, 4, 3, 3, 4, 3, 2, 3, 1, 2 }, { 4, 0, 5, 3, 2, 5, 6, 1, 5, 4 },
			{ 3, 5, 0, 2, 5, 4, 3, 4, 2, 3 }, { 3, 3, 2, 0, 3, 2, 3, 2, 2, 1 }, { 4, 2, 5, 3, 0, 3, 4, 3, 3, 2 },
			{ 3, 5, 4, 2, 3, 0, 1, 4, 2, 1 }, { 2, 6, 3, 3, 4, 1, 0, 5, 1, 2 }, { 3, 1, 4, 2, 3, 4, 5, 0, 4, 3 },
			{ 1, 5, 2, 2, 3, 2, 1, 4, 0, 1 }, { 2, 4, 3, 1, 2, 1, 2, 3, 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		find(0,1,0,0);
		System.out.println(result-1);
	}
	static void find(int idx,int temp,int su,int flipCnt) {
		if(flipCnt>p||su>n) return;
		if(idx==k) {
			if(su!=0) result++;
			return;
		}
		for(int i=0;i<=9;i++) {
			find(idx+1,temp*10,i*temp+su,flipCnt+arr[x/temp%10][i]);
		}
	}

}
