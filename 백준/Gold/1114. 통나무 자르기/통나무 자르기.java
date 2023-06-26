import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

    private static int l;
    private static int k;
    private static int c;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        int[] answer = binarySearch();
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[k] = l;
        Arrays.sort(arr);
        br.close();
    }

    private static int[] binarySearch() {
        int[] ret = new int[2];
        int left = 1;
        int right = l;
        while (left <= right) {
            int mid = (left + right) / 2;
            int res = check(mid);
            if (res != -1) {
                ret[0] = mid;
                ret[1] = res;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }

    private static int check(int len) { // 3 5
        int left = k;
        int right = k;
        int ct = 0;
        while (true) {
            left--;
            if (arr[right] - arr[left] > len) {
                if (left + 1 == right) {
                    return -1;
                }
                right = left + 1;
                left = left + 1;
                ct++;
            }
            if (left == 0) {
                break;
            }
            if (ct == c) {
                break;
            }
        }
        if (arr[right] - arr[left] > len) {
            return -1;
        }
        if (arr[left] > len) {
            return -1;
        }
        return arr[left];
    }
}