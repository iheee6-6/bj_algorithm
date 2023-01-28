import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> s = new Stack<>();
		int idx = 0;
		int i = 1;
		boolean stop = false;
		StringBuilder sb = new StringBuilder();
		while (idx < n) {
			int num = arr[idx];
			if (s.contains(num)) {
				if (num != s.pop()) {
					System.out.println("NO");
					stop = true;
					break;
				}
				sb.append("-\n");
				idx++;
			} else {
				s.add(i++);
				sb.append("+\n");
				if (num == i-1) {
					s.pop();
					sb.append("-\n");
					idx++;
				}
			}
		}
		if (!stop) {
			System.out.println(sb);
		}
	}

}