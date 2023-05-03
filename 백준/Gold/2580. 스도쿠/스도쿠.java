import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr = new int[9][9];
	static ArrayList<Node> list = new ArrayList<>();

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					list.add(new Node(i, j));
			}
		}

		check(0,list.get(0).x,list.get(0).y);
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		System.exit(0);
	}
	static void check(int idx,int x, int y) {
		for (int i = 1; i <= 9; i++) {
			if (possible(x, y, i)) {
				arr[x][y] = i;
				if(idx==list.size()-1) {
					print();
				}
				else check(idx+1,list.get(idx+1).x,list.get(idx+1).y);
			}
			arr[x][y]=0;
		}
	}

	static boolean possible(int x, int y, int value) {

		// 행
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == value)
				return false;
		}
		// 열
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] == value)
				return false;
		}
		// 9칸
		int row = x/3*3;
		int col = y/3*3;
		for (int i = row; i < row+3; i++) {
			for (int j = col; j < col+3; j++) {
				if (arr[i][j] == value)
					return false;
			}
		}
		return true;
	}
}
