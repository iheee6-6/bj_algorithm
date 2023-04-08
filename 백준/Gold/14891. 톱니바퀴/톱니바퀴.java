import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr = new int[4][8];
	static int[][] nowArr = new int[4][2]; // 바라볼 arr열 양옆..
	static int[] zeroLocArr = new int[4]; // 정각 arr열
	static Map<Integer,Integer> map ;
	static boolean[] snCheck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			String[] strArr = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				arr[i][j] = Integer.parseInt(strArr[j]);
			}
		}

		// 처음에는 무조건 2가 접점, 0이 정각
		for(int i=0;i<4;i++) {
			nowArr[i][0]=2;
			nowArr[i][1]=6;
		}
		Arrays.fill(zeroLocArr, 0);

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int mNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			move(mNum-1, dir);
		}

		System.out.println(scoreCheck());

	}

	// 톱니바퀴 움직이기 (움직이는 바퀴번호, 방향: 시계1, 반시계-1)
	static void move(int mNum, int dir) {
		map= new HashMap<>();
		map.put(mNum, dir);
		for(int i=mNum+1;i<4;i++) {
			if (arr[i-1][nowArr[i-1][0]] != arr[i][nowArr[i][1]]) {
				map.put(i, -(map.get(i-1)));
			}else break;
		}
		for(int i=mNum-1;i>=0;i--) {
			if (arr[i+1][nowArr[i+1][1]] != arr[i][nowArr[i][0]]) {
				map.put(i, -(map.get(i+1)));
			}else break;
		}
		

		for(int key:map.keySet())
			go(key,map.get(key));
		
	}

	// ㄹㅇ 움직이기
	static void go(int mNum, int dir) {
		int nowIdx1;
		int nowIdx2;
		int zeroIdx;
		if (dir == -1) {
			nowIdx1 = nowArr[mNum][0] + 1;
			nowIdx2 = nowArr[mNum][1] + 1;
			zeroIdx = zeroLocArr[mNum] + 1;
			if (nowIdx1 > 7)
				nowIdx1 = 0;

			if (nowIdx2 > 7)
				nowIdx2 = 0;
			if (zeroIdx > 7)
				zeroIdx = 0;
		} else {
			nowIdx1 = nowArr[mNum][0] - 1;
			nowIdx2 = nowArr[mNum][1] - 1;
			zeroIdx = zeroLocArr[mNum] - 1;
			if (nowIdx1 < 0)
				nowIdx1 = 7;
			if (nowIdx2 < 0)
				nowIdx2 = 7;
			if (zeroIdx < 0)
				zeroIdx = 7;
		}

		nowArr[mNum][0] = nowIdx1;
		nowArr[mNum][1] = nowIdx2;
		zeroLocArr[mNum] = zeroIdx;

	}
	
	static int scoreCheck() {
		int score = 0;
		for (int i = 0; i < 4; i++) {
			int idx = zeroLocArr[i];
			if (arr[i][idx] == 1)
				score += Math.pow(2, i);
		}
		return score;
	}

}
