package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class test1_str {
	 public void solution() {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputNum = "";
			try {
				inputNum = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			HashMap<Integer,String[]> inputArrMap = new HashMap<>();
			//String[] inputArr=new String[Integer.parseInt(inputNum)+1];
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

			 HashMap<Integer,Integer> map = new HashMap<>();
			 HashSet<Integer> checklist = new HashSet<>();
			
			 int inputNumb=Integer.parseInt(inputNum);
			 
			 while(map.size()!=inputNumb) {
				 for(int i=1;i<inputNumb+1;i++) {
					//String[] str = inputArr[i].split(" ");
					String[] str = inputArrMap.get(i);
					Integer result=Integer.parseInt(str[0]);
					boolean check= true;
					if(str.length>2) {
						int max=0;
						for(int j=1;j<str.length-1;j++) {
							if(checklist.contains(Integer.parseInt(str[j]))) {
								if(max<map.get(Integer.parseInt(str[j])))
									max=map.get(Integer.parseInt(str[j]));
							}
							else {
							check=false;
								break;
							}
						}
						result+=max;
					}
					if(check) {
						checklist.add(i);
						map.put(i,result);
					}
					
				 }
			 }
			 
			 for(Integer m : map.keySet()) {
					System.out.println(map.get(m));
			 }
	 }
	 
}
