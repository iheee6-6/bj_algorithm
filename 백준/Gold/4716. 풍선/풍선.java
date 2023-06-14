import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && n == 0)
                break;
            ArrayList<Team> teamList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                teamList.add(new Team(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(teamList);

            int sum = 0;
            for (int i = 0; i < n; i++) {
                Team t = teamList.get(i);
                if (t.aDist < t.bDist) {//a가 더 가까움
                    if (a - t.balloon < 0) { //a를 먼저 사용하고 b사용
                        sum += a * t.aDist;
                        t.balloon -= a;
                        a = 0;
                        sum += t.balloon * t.bDist;
                        b -= t.balloon;
                    } else { //a를 완전히 사용
                        a -= t.balloon;
                        sum += t.balloon * t.aDist;
                    }
                } else { //b가 더 가까움
                    if (b - t.balloon < 0) { //b를 먼저 사용하고 a사용
                        sum += b * t.bDist;
                        t.balloon -= b;
                        b = 0;
                        sum += t.balloon * t.aDist;
                        a -= t.balloon;
                    } else { //b를 완전히 사용
                        b -= t.balloon;
                        sum += t.balloon * t.bDist;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}

class Team implements Comparable<Team> {
    int aDist;
    int bDist;
    int balloon;

    public Team(int balloon, int aDist, int bDist) {
        this.aDist = aDist;
        this.bDist = bDist;
        this.balloon = balloon;
    }

    //a와 b의 차이로 내림차순 정렬
    @Override
    public int compareTo(Team o) {
        return Math.abs(o.aDist - o.bDist) - Math.abs(this.aDist - this.bDist);
    }
}