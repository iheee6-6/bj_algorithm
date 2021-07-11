package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
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
		
		int[][] schedule = new int[n][n];
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Double,Integer> scheduleMap = new HashMap<>();
		int result=0;
		 for(int i =0;i<n;i++) {
				String input="";
				try {
					input = bw.readLine();
					String[] inputs=input.split(" ");
					if(Integer.parseInt(inputs[1])>n) continue;
					schedule[i][0]=Integer.parseInt(inputs[0]);
					schedule[i][1]= Integer.parseInt(inputs[1]);
					scheduleMap.put((double) (schedule[i][1]/schedule[i][0]),i+1);
				} catch (IOException e) {
					e.printStackTrace();
				}
		 }
		 
		int idx =0;
		int cntday=n;
		while(idx<n) {
		Double max= Collections.max(scheduleMap.keySet());
		if(schedule[scheduleMap.get(max)][0]+schedule[scheduleMap.get(max)][1]>cntday)
			scheduleMap.remove(max);
		else {
			result += schedule[scheduleMap.get(max)][1];
			cntday=schedule[scheduleMap.get(max)][0];
			scheduleMap.remove(max);
		}
		idx++;
		}
		 
		 
		System.out.println(result);
		 

	}
}
