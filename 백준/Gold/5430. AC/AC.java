import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			Deque<Integer> deq = new LinkedList<Integer>();
			String cmd = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
			for (int i = 0; i < n; i++) deq.add(Integer.parseInt(arr[i]));
			boolean dir = true;
			boolean errYN = false;
			
			int k = 0;
			while(k < cmd.length()) {
				char ch = cmd.charAt(k);
				switch (ch) {
				case 'R':
					dir = !dir;
					break;
				case 'D':
					if(deq.isEmpty()) {
						errYN = true;
					} else {
						if(dir) deq.pollFirst();
						else deq.pollLast();
					}
					break;
				}
				if(errYN) break;
				k++;
			}
			
			if(errYN) {
				bw.write("error\n");
			} else {
				String str = "";
				
				if(dir) str = deq.toString().replaceAll(" ", "");
				else {
					Collections.reverse((List<?>)deq);
					str = deq.toString().replaceAll(" ", "");
				}
				
				bw.write(str + "\n");
			}
		}
		
		bw.flush();
	}
}