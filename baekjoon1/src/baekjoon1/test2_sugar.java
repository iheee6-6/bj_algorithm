package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2_sugar {
	 public void solution() {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputNum = "";
			try {
				inputNum = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			int n = Integer.parseInt(inputNum);

			int bagNum=0;
			
			if (n == 4 || n == 7) {
				bagNum= -1;
			}
			else if (n % 5 == 0) {
				bagNum= (n / 5);
			}
			else if (n % 5 == 1 || n % 5 == 3) {
				bagNum= (n / 5) + 1;
			}
			else if (n % 5 == 2 || n % 5 == 4) {
				bagNum= (n / 5) + 2;
			}
			System.out.println(bagNum);
			
}
}
