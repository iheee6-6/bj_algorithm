import java.io.*;
import java.util.*;

public class Main {

	static int a, b, result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		dfs(0);

		System.out.println(result);
	}

	public static void dfs(long num) {
		// dfs가 0으로 시작하므로 숫자 범위가 맞는지 계산을 해줘야한다
		// 재귀이므로 종료조건 중요
		if (num > b)
			return;
		if (num >= a && num <= b)
			result++;

		// 이 부분이 중요 , 4와 7만 들어가게 dfs를 만든다
		dfs(num * 10 + 4);
		dfs(num * 10 + 7);
	}
}