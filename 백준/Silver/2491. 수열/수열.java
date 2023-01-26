import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
			
		}
		int cnt=1;
		int max=1;
		for (int i = 1; i < N; i++) {
			if(arr[i-1]>=arr[i]) {
				cnt++;
			}else {
				cnt=1;
			}
			if(max<cnt) {
				max=cnt;
			}
		}
		cnt=1;
		for (int i = 1; i < N; i++) {
			if(arr[i-1]<=arr[i]) {
				cnt++;
			}else {
				cnt=1;
			}
			if(max<cnt) {
				max=cnt;
			}
		}
		System.out.println(max);
		
	}
}