package oop.eight_queen;

import java.util.Date;

/**
 * 八皇后问题
 * 在N*N的棋盘上让N的棋子上下左右正反对角线不一起
 * @author ASUS
 *
 */
public class EightQueen {
	
	private static final int N = 8;	//N皇后皇后的个数
	
	private static int count = 0;	//记录解的个数
	
	public static void main(String[] args) {
		Date begin =new Date();
		int chess[][] = init();
		putAtRow(chess, 0);
		Date end =new Date();
		System.out.println("解决 " +N+ " 皇后问题，用时：" +String.valueOf(end.getTime()-begin.getTime())+ "毫秒，计算结果："+count);
	}
	
	/**
	 * 递归终止条件：row == N 代表N行已经完全放完
	 * @param chess
	 * @param row
	 */
	private static void putAtRow(int[][] chess, int row) {	
		//递归终止条件
		if (row == N) {
			count++;
			System.out.println("第 " + count + " 种解法");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(chess[i][j] + " ");
				}
				System.out.println();
			}	
			//注意要返回
			return;
		}
		
		int [][] chessTemp = chess.clone();
		
		for(int i=0; i<N; i++) {
			/*清除该行的所有数据*/
			for(int j=0; j<N; j++) {
				chessTemp[row][j] = 0;
			}
			
			//尝试放在某一列
			chessTemp[row][i] = 1;
			//如果没有冲突就放置下一行
			if (isSafe(chessTemp, row, i)) {
				putAtRow(chessTemp, row+1);
			}
		}
		
	}

	/**
	 * 判断放置了之后是否和上一行产生了冲突
	 * @param chess
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isSafe(int[][] chess, int row, int col) {
		int step=1;
        while(row-step>=0){
            if(chess[row-step][col]==1)                //中上
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //左上
                return false;
            if(col+step<N && chess[row-step][col+step]==1)        //右上
                return false;
            
            step++;
        }
        return true;
    }
	
	/**
	 * 初始化棋盘
	 * @return
	 */
	private static int[][] init() {
		
		int[][] chess = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				chess[i][j] = 0;
			}
		}
		
		return chess;
	}
	
}
