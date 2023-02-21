import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> deque = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			switch(str[0]) {
			case "push_back":
				deque.addLast(Integer.parseInt(str[1]));
				break;
			
			case "push_front":
				deque.addFirst(Integer.parseInt(str[1]));
				break;
				
			case "front":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekFirst());
				break;
				
			case "back":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekLast());
				break;
				
			case "size":
				System.out.println(deque.size());
				break;
				
			case "empty":
				if(deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
				
			case "pop_front":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollFirst());
				break;
				
			case "pop_back":
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollLast());
				break;
			}
		}
	}
}
