import java.io.*;
import java.util.*;

public class Main {

    static class LowHigh{
        int low;
        int high;

        public LowHigh(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<LowHigh> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new LowHigh(l, h));
        }

        Collections.sort(list, (o1, o2) -> o1.low - o2.low); //x축 기준 정렬

        int sum = 0;
        int maxHeightPoint = 0;

        LowHigh highCol = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            LowHigh currentCol = list.get(i);

            if (highCol.high <= currentCol.high) {
                sum += (currentCol.low - highCol.low) * highCol.high;
                highCol = currentCol;
                maxHeightPoint = i;
            }
        }


        highCol = list.get(list.size() - 1);
        for (int i = 1; i < list.size() - maxHeightPoint; i++) {
            LowHigh currentCol = list.get(list.size() - 1 - i);

            if (highCol.high <= currentCol.high) {
                sum += (highCol.low - currentCol.low) * highCol.high;
                highCol = currentCol;
            }
        }

        sum += list.get(maxHeightPoint).high;

        System.out.println(sum);
    }
}