import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Deque<String> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			switch (str[0]) {
			case "push":
				q.add(str[1]);
				break;
				
			case "back":
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.peekLast()).append("\n");
				break;

			case "front":
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.peek()).append("\n");
				break;

			case "size":
				sb.append(q.size()).append("\n");
				break;


			case "empty":
				if (q.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
				

			case "pop":
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else {
					String v=q.pop();
					sb.append(v).append("\n");
				}
				break;
			}
		}
		
		System.out.println(sb);
	}

}
