import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			arr = br.readLine().toCharArray();

			int left = 0;
			int right = arr.length - 1;
			if (check(left, right)) {
				System.out.println(0);
				continue;
			}

			if (check2(left, right)) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}

	static boolean check(int left, int right) {
		while (left <= right) {
			if (arr[left] != arr[right]) {
				return false;
			}
			left += 1;
			right -= 1;
		}
		return true;
	}

	private static boolean check2(int left, int right) {
		while (left <= right) {
			if (arr[left] != arr[right]) {
				boolean c1 = check(left + 1, right);
				boolean c2 = check(left, right - 1);
				if (c1 || c2) {
					return true;
				} else
					return false;
			}
			left += 1;
			right -= 1;
		}
		return true;
	}
}
