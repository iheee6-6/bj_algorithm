package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test3_1712 {
	public void solution() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNum = "";
		try {
			inputNum = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] numArr=inputNum.split(" ");
		int A=Integer.parseInt(numArr[0]);
		int B=Integer.parseInt(numArr[1]);
		int C=Integer.parseInt(numArr[2]);

		if(B>=C) System.out.println(-1);
		else System.out.println((A/(C-B))+1);
	}
}
