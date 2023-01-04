import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] cost;
	static Integer[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		cost = new int[3][cnt];
		dp = new Integer[3][cnt];
		for (int i = 0; i < cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[0][i] = Integer.parseInt(st.nextToken());
			cost[1][i] = Integer.parseInt(st.nextToken());
			cost[2][i] = Integer.parseInt(st.nextToken());
		}

		dp[0][0]=cost[0][0];
		dp[1][0]=cost[1][0];
		dp[2][0]=cost[2][0];

		int red = find(cnt - 1, "red");
		int green = find(cnt - 1, "green");
		int blue = find(cnt - 1, "blue");
		System.out.println(Math.min(Math.min(red, green), blue));
	}

	static int find(int n, String color) {
		int colornum = 0;
		if (color.equals("red")) {
			colornum = 0;
		} else if (color.equals("green")) {
			colornum = 1;
		} else if (color.equals("blue")) {
			colornum = 2;
		}
		if (dp[colornum][n] == null) {
			if (color.equals("red"))
				dp[0][n] = Math.min(find(n - 1, "green"), find(n - 1, "blue")) + cost[0][n];
			else if (color.equals("green"))
				dp[1][n] = Math.min(find(n - 1, "red"), find(n - 1, "blue")) + cost[1][n];
			else if (color.equals("blue"))
				dp[2][n] = Math.min(find(n - 1, "green"), find(n - 1, "red")) + cost[2][n];
		}

		return dp[colornum][n];
	}
}
