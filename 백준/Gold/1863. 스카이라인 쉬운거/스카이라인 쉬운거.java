import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int[] arr = new int[50002];
		Stack<Integer> s = new Stack<>();
		int count=0;
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int idx=Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[i]=h;
		}
		for(int i=0;i<=n;i++) {
			while(!s.isEmpty()&&s.peek()>arr[i]) {
				count++;
				s.pop();
			}
			if(!s.isEmpty()&&s.peek()==arr[i]) {
				continue;
			}
			s.push(arr[i]);
		}
		
		System.out.println(count);
	}
}
