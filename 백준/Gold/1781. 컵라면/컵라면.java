import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Problem> arr = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int cupRamen = Integer.parseInt(st.nextToken());
			arr.add(new Problem(deadLine, cupRamen));
		}
		// 데드라인이 작고, 라면이 큰순으로 정렬하기 
		Collections.sort(arr);
		
		for(Problem problem : arr) {
			// 사이즈는 일(day)  수를 뜻함 
			int size = queue.size();
			// 데드라인이 작다면 무조건 삽입 가능 
			if(size < problem.deadLine) {
				queue.offer(problem.cupRamen);
			}
			// 같은 날짜라면, 큐에 담겨진 가장 작은 라면수와 현재 라면수랑 비교하기 
			else if(size == problem.deadLine) {
				int peek = queue.peek();
				// 현재 라면이 크다면 큐에 있던것을 빼주고 현재 값으로 넣어주기 
				if(problem.cupRamen > peek) {
					queue.poll();
					queue.add(problem.cupRamen);
				}
			}
		}
		while(!queue.isEmpty()) {
			max += queue.poll();
		}
		System.out.println(max);
	}
	
	private static class Problem implements Comparable<Problem>{
		int deadLine, cupRamen;
		
		public Problem(int deadLine, int cupRamen) {
			this.deadLine = deadLine;
			this.cupRamen = cupRamen;
		}
		
		// deadline이 작은 순, 컵라면이 큰 순 
		public int compareTo(Problem o) {
			if(o.deadLine == this.deadLine) {
				return o.cupRamen - this.cupRamen;
			}
			return this.deadLine - o.deadLine;
		}
	}
}