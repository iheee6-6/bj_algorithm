import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n1 = Integer.parseInt(st.nextToken());
		long n2 = Integer.parseInt(st.nextToken());
		
		long gcd = getGCD(Math.max(n1, n2),Math.min(n1, n2));
		long lcm = n1*n2/gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}
	static long getGCD(long x,long y) {
		while(y>0) {
			long temp =x;
			x=y;
			y=temp%y;
		}
		return x;
	}

}
