import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[2];
        A[0] = Integer.parseInt(st.nextToken());
        A[1] = Integer.parseInt(st.nextToken());

        int[] B = new int[2];
        B[0] = Integer.parseInt(st.nextToken());
        B[1] = Integer.parseInt(st.nextToken());

        int[] C = new int[2];
        C[0] = Integer.parseInt(st.nextToken());
        C[1] = Integer.parseInt(st.nextToken());


        double a = Math.hypot(B[0] - C[0], B[1] - C[1]);
        double b = Math.hypot(C[0] - A[0], C[1] - A[1]);
        double c = Math.hypot(A[0] - B[0], A[1] - B[1]);

        double answer;

        if ((B[0] - A[0]) * (C[1] - A[1]) == (B[1] - A[1]) * (C[0] - A[0])) {
            answer = -1;
        } else {
            double ab = 2*a+2*b;
            double bc = 2*b+2*c;
            double ca = 2*c+2*a;
            answer = Math.max(Math.max(ab, bc), ca) - Math.min(Math.min(ab, bc), ca);
        }

        System.out.println(answer);
    }
}