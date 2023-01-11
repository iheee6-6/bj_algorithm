import java.util.*;
class Pair {
    int number;
    int price;
    Pair(int number, int price) {
        this.number = number;
        this.price = price;
    }
}
public class Main {
    static boolean[] check;
    static int[] order;
    static int[] c;
    static Pair[][] d;
    static int go(int index) {
        int n = c.length;
        if (index == n) {
            int[] price = c.clone();
            int sum = 0;
            for (int x : order) {
                sum += price[x];
                for (Pair p : d[x]) {
                    int y = p.number;
                    int z = p.price;
                    price[y] -= z;
                    if (price[y] <= 0) price[y] = 1;
                }
            }
            return sum;
        }
        int ans = -1;
        for (int i=0; i<n; i++) {
            if (check[i]) continue;
            check[i] = true;
            order[index] = i;
            int cur = go(index+1);
            if (ans == -1 || ans > cur) ans = cur;
            order[index] = 0;
            check[i] = false;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        check = new boolean[n];
        order = new int[n];
        c = new int[n];
        for (int i=0; i<n; i++) {
            c[i] = sc.nextInt();
        }
        d = new Pair[n][];
        for (int i=0; i<n; i++) {
            int cnt = sc.nextInt();
            d[i] = new Pair[cnt];
            for (int j=0; j<cnt; j++) {
                int number = sc.nextInt()-1;
                int price = sc.nextInt();
                d[i][j] = new Pair(number, price);
            }
        }
        int ans = go(0);
        System.out.println(ans);
    }
}