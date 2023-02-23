
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (n % h == 0)
				System.out.println(100 * h + (n / h));
			else
				System.out.println(100 * (n % h) + (n / h) + 1);
		}

	}

}
