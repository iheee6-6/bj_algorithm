
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 int n = Integer.parseInt(st.nextToken());
		 ArrayList<Integer> arr = new ArrayList<>();
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<n;i++) {
			 String[] strarr = br.readLine().split(" ");
			 String str = strarr[0];
			 if(str.equals("add")) {
				 if(!arr.contains(Integer.valueOf(strarr[1])))
					 arr.add(Integer.valueOf(strarr[1]));
			 }
			 else if(str.equals("remove")) {
				 if(arr.contains(Integer.valueOf(strarr[1])))
					 arr.remove(Integer.valueOf(strarr[1]));
			 }
			 else if(str.equals("check")) {
				 if(arr.contains(Integer.valueOf(strarr[1]))) {
					 sb.append("1\n");
				 }
				 else 
					 sb.append("0\n");
					
			 }
			 else if(str.equals("toggle")) {
				 if(arr.contains(Integer.valueOf(strarr[1]))) {
					 arr.remove(Integer.valueOf(strarr[1]));
				 }
				 else 
					 arr.add(Integer.valueOf(strarr[1]));
			 }
			 else if(str.equals("all")) {
				 arr.clear();
				 for(int j=1;j<21;j++)
					 arr.add(new Integer(j));
			 }

			 else if(str.equals("empty")) {
				 arr.clear();
			 }
		 }
		System.out.println(sb);
	}

}
