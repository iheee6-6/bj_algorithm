import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double h = Integer.parseInt(st.nextToken());
		double w = Integer.parseInt(st.nextToken());
		double n = Integer.parseInt(st.nextToken());
		double m = Integer.parseInt(st.nextToken());
		int x = (int) Math.ceil(h/(n+1));
		int y = (int) Math.ceil(w/(m+1));
		System.out.println(x*y);
	}

}