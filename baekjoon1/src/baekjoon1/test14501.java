package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class test14501 {

	public void solution() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNum = "";
		try {
			inputNum = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = Integer.parseInt(inputNum);
		
		
		HashMap<Integer,Integer> inputArrMap = new HashMap<>();
		
		 for(int i =1;i<Integer.parseInt(inputNum)+1;i++) {
				String input="";
				try {
					input = br.readLine();
					String[] inputs=input.split(" ");
					inputArrMap.put(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		 }
		 
		 

	}
}
