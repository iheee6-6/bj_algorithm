import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int dfs_horse[] = new int[11];
    static Node map[];
    static Horse horse[];
    static int dice[] = new int[11];
    static int ans = 0;
    static int tmp_ans = 0;
    static boolean visited[] = new boolean [32];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new Node[32];
        init();
        
        String [] t = br.readLine().split(" ");
        
        for(int i=1; i<=10; i++) {
            dice[i] = Integer.parseInt(t[i-1]);
        }

        dfs(1);

        System.out.println(ans);
    }
    public static boolean go(int dice, int horse_num) {
        
        Horse a = horse[horse_num];
        int now_pos = a.idx;    // 현재 말이 있는 위치
        boolean flag = a.flag;      
        
        if(now_pos==100) {  // 밖으로 나간 말
            return true;            
        }
        
        
        for(int i=0; i<dice; i++) {     // 주사위의 칸 만큼 이동
            
            if(now_pos ==100) {
                horse[horse_num] = new Horse(now_pos,flag);
                visited[a.idx] = false;
                return true;
            }
            
            
            if(now_pos ==5 || now_pos ==10 || now_pos ==15) {
                if(flag) {
                    now_pos = map[now_pos].blue_next;
                }
                else {
                    now_pos = map[now_pos].red_next;
                }
            }
            else {
                now_pos = map[now_pos].red_next;
            }
        }
        
        if(now_pos ==100) {
            horse[horse_num] = new Horse(now_pos,flag);
            visited[a.idx] = false;
            return true;
        }
        
        
        // 말이 주사위 칸 만큼 다 이동했고 갈림길에 있는 경우
        if(now_pos ==5 || now_pos ==10 || now_pos ==15) {
            flag = true;
        }
        
        if(visited[now_pos]) {

            return false;
        }
        tmp_ans +=map[now_pos].now_num;
        horse[horse_num] = new Horse(now_pos,flag); // 말의 위치 바꿔줌
        visited[a.idx] = false;
        visited[now_pos] = true;
        
        return true;
    }
    public static void dfs(int level) {
        if(level==11) {
            tmp_ans = 0;
            for(int i=1; i<=10; i++) {
                if(!go(dice[i],dfs_horse[i])) {
                    clear();
                    return ;
                }

            }
            ans = Math.max(ans, tmp_ans);
            clear();
            return ;
        }
        
        for(int i=1; i<=4; i++) {
            dfs_horse[level] = i;
            dfs(level+1);
        }
    }
    public static void clear() {
        // 말의 위치정보 초기화
        for(int i=1; i<=4; i++) {
            horse[i] = new Horse(0,false);
        }
        
        // 중복을 위한 방문정보 초기화
        visited = new boolean [32];
    }
    public static void init() {
        
        map[0] = new Node(1,0,0);
        
        int map_num = 2;
        for(int i=1; i<=19; i++) {
            map[i] = new Node(i+1,0,map_num);
            map_num+=2;
        }
        map[20] = new Node(100,0,40);       // 100은 끝이라 가정
        
        
        map[5].blue_next = 21;
        map[10].blue_next = 29;
        map[15].blue_next = 27;
        
        map[21] = new Node(22,0,13);
        map[22] = new Node(23,0,16);
        map[23] = new Node(24,0,19);
        map[24] = new Node(30,0,25);
        map[25] = new Node(24,0,26);
        map[26] = new Node(25,0,27);
        map[27] = new Node(26,0,28);
        map[28] = new Node(24,0,24);
        map[29] = new Node(28,0,22);
        map[30] = new Node(31,0,30);
        map[31] = new Node(20,0,35);
        
        horse = new Horse[5];
        
        for(int i=1; i<=4; i++) {
            horse[i] = new Horse(0,false);
        }   
    }
}

class Node{
    int red_next, blue_next,now_num;
    
    Node(int red_next, int blue_next, int now_num){
        this.red_next = red_next;
        this.blue_next = blue_next;
        this.now_num = now_num;
    }
}
class Horse{
    int idx;
    boolean flag;
    Horse(int idx, boolean flag){
        this.idx= idx;
        this.flag=  flag;
    }
}
