package algorithm_design.lab3;

import java.util.Scanner;

public class DivideArray {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		
		System.out.println("请输入有多少个数");
		int N = scanner.nextInt();
		
		int[] arr = new int[N];
		int[] currentSum = new int[N*N];
		boolean[][] state = new boolean[100][100];
		
		/*输入数，并且同时求出和*/
		for(int i=0; i<arr.length; i++) {
			arr[i] = scanner.nextInt();
			sum += arr[i];
		}
		
		for(int i=0; i<N; i++) {
			for(int j = sum/2; j>= arr[i]; --j) {
				if (currentSum[j] < currentSum[j-arr[i]] + arr[i]) {
					currentSum[j] = currentSum[j-arr[i]] + arr[i];
					state[i][j] = true;
				}
			}
		}
		
		System.out.println("最小差：" + (int)(sum - currentSum[sum/2]*2));
		System.out.println("最优分组：");
		int i=N, j=sum/2;
		while(i-->0) {
			if (state[i][j]) {
				System.out.print(arr[i] + " ");
				j -= arr[i];
			}
		}
	}
}
