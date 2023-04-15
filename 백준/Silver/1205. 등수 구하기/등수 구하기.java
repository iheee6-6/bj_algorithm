import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int score = scanner.nextInt();
		int p = scanner.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(scanner.nextInt());
		}
		Collections.sort(list, Collections.reverseOrder());

		int result = 1;
		if (n == p && score <= list.get(n - 1))
			result = -1;
		else {
			for (int i = 0; i < n; i++) {
				if (list.get(i) > score)
					result++;
				else
					break;
			}
		}
		System.out.println(result);
	}

}
