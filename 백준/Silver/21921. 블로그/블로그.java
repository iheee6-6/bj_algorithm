import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int sum = 0;
        int max = 0;
        int cnt = 1;

        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            sum += arr[i];

            if (i == X - 1)
                max = sum;

            if (i > X - 1) {
                sum -= arr[i - X];

                if (max < sum) {
                    max = sum;
                    cnt = 1;
                }
                else if (max == sum) {
                    cnt++;
                }
    
            }
        
        }

        if (max == 0)
            bw.write("SAD\n");
        else {
            bw.write(Integer.toString(max) + "\n");
            bw.write(Integer.toString(cnt) + "\n");
            
        }

        bw.flush();
        bw.close();

    }
}
