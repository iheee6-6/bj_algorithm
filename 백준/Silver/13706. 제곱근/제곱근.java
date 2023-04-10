import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger n = new BigInteger(st.nextToken());

		BigInteger left = BigInteger.ONE;
		BigInteger right = n;
		BigInteger mid = null;
		while (true) {
			mid = left.add(right).divide(BigInteger.TWO);
			int result = mid.multiply(mid).compareTo(n);
			if (result == 0)
				break;
			else if (result == 1)
				right = mid.subtract(BigInteger.ONE);
			else
				left = mid.add(BigInteger.ONE);
		}
		System.out.println(mid);
	}

}
