import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] info = br.readLine().split(" ");

    int N = Integer.valueOf(info[0]);
    int M = Integer.valueOf(info[1]);
    int[][] price = new int[N][2];

    for (int i = 0; i < price.length; i++) {
      info = br.readLine().split(" ");
      price[i] = new int[] { Integer.valueOf(info[0]), Integer.valueOf(info[1]) };
    }

    Arrays.sort(price, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (Integer.compare(o1[1], o2[1]) == 0) {
          return Integer.compare(o2[0], o1[0]);
        }

        return Integer.compare(o1[1], o2[1]);
      }
    });

    int totalPrice = -1;
    int totalGram = 0;
    int answer = Integer.MAX_VALUE;
    boolean isPossible = false;

    for (int i = 0; i < N; i++) {
      totalGram += price[i][0];

      if (i > 0 && price[i - 1][1] == price[i][1]) {
        totalPrice += price[i][1];
      } else {
        totalPrice = price[i][1];
      }

      if (totalGram >= M) {
        isPossible = true;
        answer = Math.min(answer, totalPrice);
      }
    }

    bw.write(isPossible ? answer + "\n" : -1 + "\n");
    bw.flush();
    bw.close();
  }

}