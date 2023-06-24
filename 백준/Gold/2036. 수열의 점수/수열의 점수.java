import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

	static int n;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		int minusCount = 0;
		int zeroCount = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] < 0)
				minusCount++;
			else if (arr[i] == 0)
				zeroCount++;
		}

		Arrays.sort(arr);

		BigInteger result = new BigInteger("0");
		long temp = 1;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				if (minusCount != 1) {
					if (temp == 1)
						temp = arr[i];
					else {
						result = result.add(BigInteger.valueOf(temp * arr[i]));
						temp = 1;
					}
				} else {
					if (temp == 1 && zeroCount > 0)
						temp = arr[i];
					else {
						result = result.add(BigInteger.valueOf(temp * arr[i]));
						temp = 1;
					}
					
				}
				minusCount--;
			} else if (arr[i] == 1) {
				result = result.add(BigInteger.valueOf(arr[i]));
			} else if (arr[i] == 0) {
				temp = 1;
				zeroCount--;
			} else {
				if (temp != 1) {
					result = result.add(BigInteger.valueOf(temp * arr[i]));
					temp = 1;
				} else {
					if ((n - i) % 2 != 0)
						result = result.add(BigInteger.valueOf(arr[i]));
					else
						temp = arr[i];
				}
			}
		}

		System.out.println(result);
	}

}
