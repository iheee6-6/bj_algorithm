import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			int[] alpha = new int[26];// 알파벳 별 개수를 저장한다.
			for (int j = 0; j < str.length(); j++) {
				alpha[str.charAt(j) - 'a']++;
			}

			int k = Integer.parseInt(br.readLine());
            if(k == 1) {
                System.out.println("1 1");
                continue;
            }
            
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < str.length(); j++) {
				if (alpha[str.charAt(j) - 'a'] < k)
					continue;

				int count = 1;
				for (int z = j + 1; z < str.length(); z++) {
					if (str.charAt(z) == str.charAt(j))
						count++;
					if (count == k) {
						min = Math.min(min, z - j + 1);
						max = Math.max(max, z - j + 1);
						break;
					}
				}

			}

			if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(min + " " + max);
			}
		}

	}

}
