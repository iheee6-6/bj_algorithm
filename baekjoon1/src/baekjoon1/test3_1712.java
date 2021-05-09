package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test3_1712 {
	public int solution() {
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

		if(B>C) return -1;
		int num=1;
		while(true) {
			if((A+B*num)-C*num<0) {
				return num;
			}
			num++;
		}
	}
}
