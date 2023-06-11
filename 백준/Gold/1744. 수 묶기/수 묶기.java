import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        Queue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i<N; i++)
            q.offer(Integer.parseInt(br.readLine()));

        //음수들, 0처리
        while(!q.isEmpty()){
            int first = q.poll();

            if(first>0){
                q.offer(first);
                break;
            }
            if(q.isEmpty()){
                sum += first;
                break;
            }

            int second = q.poll();
            if(second>0){
                sum += first;
                q.offer(second);
                break;
            }

            sum += first * second;
        }

        //내림차순으로 큐를 정렬
        Queue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        while(!q.isEmpty())
            q2.offer(q.poll());

        //양수인 노드들을 처리
        while(!q2.isEmpty()){
            int first = q2.poll();

            if(q2.isEmpty()){
                sum += first;
                break;
            }

            int second = q2.poll();

            if(second == 1)
                sum += first + second;
            else
                sum += first*second;
        }

        System.out.println(sum);
	}

}
