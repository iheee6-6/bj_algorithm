import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long x, y, w, s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		long result = (x + y) * w;
		long b = Math.max(x, y);
		if ((x + y) % 2 == 0) {
			result = Math.min(b * s, result);
		} else {
			result = Math.min(result, (b - 1) * s + w);
		}
        
        result=Math.min((Math.min(x, y)*s+(Math.abs(x-y))*w),result);
		System.out.println(result);
	}

}
