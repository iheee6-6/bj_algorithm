import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;					// n 개 장소
	static int[] honeys;			// 각 장소의 꿀 양
	static long maxCount;			// 출력: 최대 꿀 양

	static long total;				// 모든 장소들의 꿀 양 합
	static long[] toRightTotal;		// [0 ~ 벌 2 위치] 누적합
	static long[] toLeftTotal;		// [끝 ~ 벌 2 위치] 누적합

	/* 벌통: 맨 오른쪽 고정, 벌 1: 맨 왼쪽 고정 => 벌 2의 위치 선택 */
	static void case1() {
		long bee1, bee2;			// 벌 1, 벌 2의 꿀 채집량

		for (int i = 1; i <= n - 2; i++) {
			bee1 = total - honeys[0] - honeys[i];
			bee2 = total - toRightTotal[i];
			maxCount = Math.max(maxCount, bee1 + bee2);
		}
	}

	/* 벌통: 맨 왼쪽 고정, 벌 1: 맨 오른쪽 고정 => 벌 2의 위치 선택 */
	static void case2() {
		long bee1, bee2;

		for (int i = n - 2; i >= 1; i--) {
			bee1 = total - honeys[n - 1] - honeys[i];
			bee2 = total - toLeftTotal[i];
			maxCount = Math.max(maxCount, bee1 + bee2);
		}
	}

	/* 벌 1: 맨 왼쪽 고정, 벌 2: 맨 오른쪽 고정 => 벌통: 벌 사이에서 선택 */
	static void case3() {
		long bee1, bee2;

		for (int i = 1; i <= n - 2; i++) {
			bee1 = toRightTotal[i] - honeys[0];
			bee2 = toLeftTotal[i] - honeys[n - 1];
			maxCount = Math.max(maxCount, bee1 + bee2);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		honeys = new int[n];
		toRightTotal = new long[n];			// 왼쪽 -> 오른쪽으로 꿀 양 누적합
		toLeftTotal = new long[n];			// 오른쪽 -> 왼쪽으로 꿀 양 누적합
		long temp = 0;
		for (int i = 0; i < n; i++) {
			honeys[i] = Integer.parseInt(st.nextToken());

			temp += honeys[i];
			toRightTotal[i] = temp;
		}

		temp = 0;
		for (int i = n - 1; i >= 0; i--) {
			temp += honeys[i];
			toLeftTotal[i] = temp;
		}

		total = toRightTotal[n - 1];

		case1();
		case2();
		case3();

		System.out.println(maxCount);
	}
}