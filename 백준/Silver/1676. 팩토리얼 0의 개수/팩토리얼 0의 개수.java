import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger result = new BigInteger("1");
		for (int i = n; i > 0; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		String str = String.valueOf(result);
		char[] carr = str.toCharArray();
		int count = 0;
		for (int i = carr.length - 1; i >= 0; i--) {
			if (carr[i] == '0')
				count++;
			else
				break;

		}
		System.out.println(count);
	}

}
