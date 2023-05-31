import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Class implements Comparable<Class>{
		int start,end;
		Class(int start,int end){
			this.start=start;
			this.end=end;
		}
		
		@Override
		public int compareTo(Class c) {
			if(this.start==c.start)
				return this.end-c.end;
			return this.start-c.start;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		Class[] arr = new Class[n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i]=new Class(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr);
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		pq.add(arr[0].end);
		
		for (int i = 1; i < n; i++) {
			Class c = arr[i];
			boolean add = false;

			if (pq.peek() <= c.start) {
				pq.poll();
				pq.add(c.end);
				add = true;
			}

			if (!add) {
				pq.add(c.end);
			}
		}

		System.out.println(pq.size());
	}

}
