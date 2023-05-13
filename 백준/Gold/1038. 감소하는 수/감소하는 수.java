import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static List<Long> arr;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new ArrayList<>();

		// 0~9까지의 수로 감소하는 값을 만드는 방법은
		// 자리마다 선택할지 말지로 2^10이다.
		// 그러나 공집합은 제외해야 하므로 2^10-1 = 1023 이다.
		if (n <= 1022) {
			for (int i = 0; i < 10; i++) {
				check(i, 1);
			}
			Collections.sort(arr);
			System.out.println(arr.get(n));
		} else {
			System.out.println(-1);
		}
	}

	static void check(long num, int len) {
		if (len >10) {
			return;
		}

		arr.add(num);

		for (int i = 0; i < 10; i++) {
			if (num % 10 > i) {
				check(num * 10 + i, len + 1);
			} 
		}
	}
}
