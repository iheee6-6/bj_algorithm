import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		belt = new int[2 * n];
		robot = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		while (true) {

			result++;
			// 1. 회전
			rotate();

			// 2. 로봇 이동(먼저 올린 거 부터, 칸의 내구도 1이상인 곳)
			rMove();

			// 3. 로봇 올리기 belt0
			if (belt[0] > 0&&!robot[0]) {
				robot[0]=true;
				belt[0] -= 1;
			}

			if (checkZero() >= k)
				break;
		}

		System.out.println(result);
	}

	static void rMove() {
		for (int i=n-2;i>=0;i--) {
			int idx = i + 1;
			if (belt[i + 1] > 0&&robot[i]&&!robot[idx]) {
				robot[i]=false;
				belt[idx] -= 1;
				if(idx==n-1) continue;
				robot[idx]=true;
			}
		}
	}

	static void rotate() {
		int[] temp = belt.clone();
		temp[0]=belt[2*n-1];
		for (int i = 2*n-2; i >=0; i--) {
			int idx = i + 1;
			temp[idx] = belt[i];
		}
		belt = temp.clone();

		for (int i=n-2;i>=0;i--) {
			int idx = i +1;
			robot[idx]=robot[i];
		}
		robot[0]=false;
		robot[n-1]=false;
	}

	static int checkZero() {
		int count = 0;
		for (int i = 0; i < 2 * n; i++) {
			if (belt[i] == 0)
				count++;
		}
		return count;
	}
}
