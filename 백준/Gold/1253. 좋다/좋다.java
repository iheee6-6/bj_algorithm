import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<N;i++){
            int start_index = 0;
            int end_index = N-1;
            int key = arr[i];
            while(end_index > start_index){
                if(arr[start_index]+arr[end_index]>key){
                    end_index--;
                }else if(arr[start_index]+arr[end_index]<key){
                    start_index++;
                }else{
                    if(start_index != i && end_index != i){
                        count++;
                        break;
                    }else if(start_index == i){
                        start_index++;
                    }else if(end_index == i){
                        end_index--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}