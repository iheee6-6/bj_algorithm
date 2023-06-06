import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int answer;
	static int n;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		game(0);
		System.out.println(answer);

	}

	static void game(int count) {
		if (count == 5) {
			answer = Math.max(answer, checkMax());
			return;
		}

		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++)
			copy[i] = map[i].clone();

		for (int i = 0; i < 4; i++) {
			move(i);
			game(count + 1);

			for (int j = 0; j < n; j++)
				map[j] = copy[j].clone();
		}
	}

	static void move(int dir) {
		switch (dir) {
		case 0: // 위로
			for (int i = 0; i < n; i++) { // 열
				int value = 0; // 이전 값이라고 생각
				int idx = 0;
				for (int j = 0; j < n; j++) { // 행
					if (map[j][i] != 0) {
						if (value == map[j][i]) {
							map[idx - 1][i] = value * 2;
							map[j][i] = 0;
							value = 0;
						} else {
							value = map[j][i];
							map[j][i] = 0;
							map[idx][i] = value;
							idx++;
						}
					}
				}
			}
			break;

		case 1: // 아래로
			for (int i = 0; i < n; i++) { // 열
				int value = 0; // 이전 값이라고 생각
				int idx = n-1;
				for (int j = n - 1; j >= 0; j--) { // 행
					if (map[j][i] != 0) {
						if (value == map[j][i]) {
							map[idx + 1][i] = value * 2;
							map[j][i] = 0;
							value = 0;
						} else {
							value = map[j][i];
							map[j][i] = 0;
							map[idx][i] = value;
							idx--;
						}
					}
				}
			}
			break;
		case 2: // 왼쪽으로
			for (int i = 0; i < n; i++) { //행
				int value = 0;
				int idx = 0;
				for (int j = 0; j <n; j++) {// 열
					if (map[i][j] != 0) {
						if (map[i][j] == value) {
							map[i][idx-1] = value * 2;
							map[i][j] = 0;
							value = 0;
						} else {
							value = map[i][j];
							map[i][j]=0;
							map[i][idx]=value;
							idx++;
						}
					}
				}
			}
			break;
		case 3: //오른쪽으로
			for(int i=0;i<n;i++) { //행
				int value=0;
				int idx=n-1;
				
				for(int j=n-1;j>=0;j--) { //열 
					if(map[i][j]!=0) {
						if(value==map[i][j]) {
							map[i][idx+1]=value*2;
							value=0;
							map[i][j]=0;
						}else {
							value=map[i][j];
							map[i][j]=0;
							map[i][idx]=value;
							idx--;
						}
					}
				}
			}
			break;
			
		}
	}

	static int checkMax() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, map[i][j]);
			}
		}
		return max;
	}
}
