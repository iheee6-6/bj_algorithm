import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		Node[] arr = new Node[N];
		long sum=0;
		long cnt=0;
		for(int i=0;i<N;i++) {
			long x=scann.nextLong();
			long a=scann.nextLong();
			arr[i]=new Node(x,a);
			cnt+=arr[i].a;
		}
		Arrays.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.x==n2.x) return (int)(n1.a-n2.a);
				return (int)(n1.x-n2.x);
			}
		});
		for(int i=0;i<N;i++) {
			sum+=arr[i].a;
			if(sum>=(cnt+1)/2) {
				System.out.println(arr[i].x);
				break;
			}
		}
	}
	public static class Node{
		long x;
		long a;
		public Node(long x2, long a2) {
			super();
			this.x = x2;
			this.a = a2;
		}
	}
}