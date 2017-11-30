package algorithm_design.lab4;

import java.nio.file.Path;

/**
 * https://wenku.baidu.com/view/106ae65184868762caaed5e8.html
 * @author ASUS
 *
 */
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
		
		/**
		 * 记录解的路径
		 */
		int[][] path = new int[n][m];
		int tempX=n-1,tempY=m-1;
		while (tempX>=0 && tempY>=0) {
			if (tempX == 0 && tempY == 0) {
				path[tempX][tempY] = 1;
				break;
			}else if (tempX == 0) {
				tempY = tempY - 1;
				path[tempX][tempY] = 1;
			}else if (tempY == 0) {
				tempX = tempX - 1;
				path[tempX][tempY] = 1;
			}else if (dp[tempX-1][tempY] == dp[tempX][tempY] - map[tempX][tempY]){
				tempX = tempX - 1;
				path[tempX][tempY] = 1;
			}else if (dp[tempX][tempY-1] == dp[tempX][tempY] - map[tempX][tempY]) {
				tempY = tempY - 1;
				path[tempX][tempY] = 1;
			}else {
				System.out.println("error:" + tempX + tempY);
			}
			
		}
		
		path[n-1][m-1] = 1;
		
		/**
		 * 输出第一次的路径
		 */
		System.out.println("遍历路径");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if (path[i][j] == 1) {
					map[i][j] = 0;
					System.out.print(i + "," + j + " ");
				}			
			}
		}
		System.out.println();
		
		
		/*输出权值数组*/
		System.out.println("动态规划的数组：");
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
		
		/*输出路径数组*/
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(path[i][j] + " ");
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
		System.out.println("++++++++++++第二次++++++++++++++++");
		int y = maze.upToDown(5, 5);
		
		System.out.println("最终往返的最大权值："+ (x + y));
	}
}
