package algorithm_design.lab2;

/**
 * 0 1 背包问题
 * http://blog.csdn.net/xp731574722/article/details/70766804
 * @author Administrator
 *
 */
public class PackageItem {

	public static void main(String[] args){
		
		int itemNumber = 6;
		int packageWeight = 12;
		
		int arr[][] = new int[itemNumber + 1][packageWeight + 1];//动态规划的数组
		int weight[] = {4, 6, 2, 2, 5, 1};//放置物品的重量
		int value[] = {8, 10, 6, 3, 7, 2};//放置物品的价值
		
		
		/**
		 * 数组清零
		 */
		for(int i=0; i<itemNumber + 1; i++)
			for(int j=0; j<packageWeight+1; j++){
				arr[i][j] = 0;
			}
		
		/**
		 * 画动态规划的二维数组的图
		 * 下标从1开始时为了防止坐标越界
		 */
		for(int i=1; i<itemNumber + 1; i++)
			for(int j=1; j<packageWeight+1; j++){
				if(j < weight[i-1]){	//当前重量不足
					arr[i][j] = arr[i-1][j];
				}else{
					arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-weight[i-1]] + value[i-1]);
				}
			}
			
		for(int i=1; i<itemNumber + 1; i++){
			for(int j=1; j<packageWeight+1; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("背包重量为：" + packageWeight + " 时，最优解为:" + arr[itemNumber][packageWeight]);
		
	}
	
	
}
