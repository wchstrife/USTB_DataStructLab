package algorithm_design.lab4;

public class Maze {
	
	public int[][] map;
	
	public int m=5, n=5;
	
	int[][] dp = new int[n][m];
	
	public int upToDown(int n, int m) {
		
		//权值数组
		//int[][] dp = new int[n][m];
		
		if (n<=0||m<=0) {
			
			return 0;
		}
	
		dp[0][0] = map[0][0];
		//求第一行
		for(int i=1; i<m; i++) {
			dp[0][i] = map[0][i] + dp[0][i-1];
		}
		//求第一列
		for(int i=1; i<n; i++) {
			dp[i][0] = map[i][0] + dp[i-1][0];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				dp[i][j] = map[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);				
			}
		}
		
		
		
		/*输出权值数组*/
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		/*输出更改后的数组*/
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		return dp[n-1][m-1];
	}
	
	
	
	public static void main(String[] args) {
		Maze maze = new Maze();
		int[][] arr = new int[][] {{1,2,3,5,6},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
		maze.map = arr;
		
		int x = maze.upToDown(5, 5);
		
		System.out.println(x+" ");
	}
}
