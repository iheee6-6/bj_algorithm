import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10001];
        dp[1] = arr[1];
        dp[2] = arr[2] + arr[1];

        for(int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}