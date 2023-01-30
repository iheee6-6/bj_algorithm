
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		double z = (y * 100 / x);
		int result = (int) z;
		long high = x;
		long low = 0;
		if (z >= 99)
			System.out.println(-1);
		else {
			for (int i = 0; i < 100000; i++) {
				long mid = (high + low) / 2;
				result = (int) ((y + mid) * 100 / (x + mid));
				if (result > z) {
					high = mid;
				} else {
					low = mid;
				}
			}
			System.out.println(low + 1);
		}
	}

}