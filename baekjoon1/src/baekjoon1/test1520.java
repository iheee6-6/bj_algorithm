package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class test1520 {

	public void solution() {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputNum = "";
			try {
				inputNum = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] input2 =inputNum.split(" ");
			int a=Integer.parseInt(input2[0]);
			int b=Integer.parseInt(input2[1]);
			int[][] arr= new int[a][b];
			
			HashMap<Integer,String[]> inputArrMap = new HashMap<>();
			
			 for(int i =1;i<Integer.parseInt(inputNum)+1;i++) {
					String input="";
					try {
						input = br.readLine();
						inputArrMap.put(i, input.split(" "));
						//inputArr[i]=input;
					} catch (IOException e) {
						e.printStackTrace();
					}
			 }


	}
}
