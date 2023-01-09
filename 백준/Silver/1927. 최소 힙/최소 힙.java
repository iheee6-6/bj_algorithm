import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		int num = Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			long a = Long.parseLong(br.readLine());
			if(a==0) {
				if(priorityQueue.isEmpty()) System.out.println("0");
				else System.out.println(priorityQueue.poll());
			}
			else {
				priorityQueue.add(a);
			}
		}
	}
}