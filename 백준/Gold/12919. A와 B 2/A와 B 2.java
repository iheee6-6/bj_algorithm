import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		String t = br.readLine();
		
		
		Queue<String> q = new LinkedList<>();
		q.add(t);
		boolean result=false;
		while(!q.isEmpty()) {
			String temp = q.poll();
			if(s.equals(temp)) {
				result=true;
				break;
			}
			if(temp.endsWith("A")) {
				q.add(temp.substring(0,temp.length()-1));
			}
			
			if(temp.startsWith("B")) {
				StringBuilder sb= new StringBuilder();
				temp=sb.append(temp).reverse().toString();
				q.add(temp.substring(0,temp.length()-1));
			}
		}
		
		if(result) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
