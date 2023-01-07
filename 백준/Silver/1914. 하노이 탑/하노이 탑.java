import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BigInteger res = new BigInteger("1");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		BigInteger count = new BigInteger("2");
		System.out.println(count.pow(num).subtract(new BigInteger("1")));
		/*for (int i = 0; i < num; ++i) {
			res = res.multiply(new BigInteger("2")); // 2의 N 제곱
		}
		res = res.subtract(new BigInteger("1")); // 빼기 1
		System.out.println(res);
		*/
		if (num <= 20) {
			//System.out.println((int) Math.pow(2, num) - 1);
			Haoni(num, 1, 2, 3);
			System.out.println(sb);
		} 
	}

	static void Haoni(int num, int start, int middle, int end) {
		if (num == 1) {
			sb.append(start + " " + end + "\n");
		} else {
			Haoni(num - 1, start, end, middle);
			sb.append(start + " " + end + "\n");
			Haoni(num - 1, middle, start, end);
		}
	}
}