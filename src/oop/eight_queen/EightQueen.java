package oop.eight_queen;

import java.util.Date;

/**
 * �˻ʺ�����
 * ��N*N����������N�������������������Խ��߲�һ��
 * @author ASUS
 *
 */
public class EightQueen {
	
	private static final int N = 8;	//N�ʺ�ʺ�ĸ���
	
	private static int count = 0;	//��¼��ĸ���
	
	public static void main(String[] args) {
		Date begin =new Date();
		int chess[][] = init();
		putAtRow(chess, 0);
		Date end =new Date();
		System.out.println("��� " +N+ " �ʺ����⣬��ʱ��" +String.valueOf(end.getTime()-begin.getTime())+ "���룬��������"+count);
	}
	
	/**
	 * �ݹ���ֹ������row == N ����N���Ѿ���ȫ����
	 * @param chess
	 * @param row
	 */
	private static void putAtRow(int[][] chess, int row) {	
		//�ݹ���ֹ����
		if (row == N) {
			count++;
			System.out.println("�� " + count + " �ֽⷨ");
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(chess[i][j] + " ");
				}
				System.out.println();
			}	
			//ע��Ҫ����
			return;
		}
		
		int [][] chessTemp = chess.clone();
		
		for(int i=0; i<N; i++) {
			/*������е���������*/
			for(int j=0; j<N; j++) {
				chessTemp[row][j] = 0;
			}
			
			//���Է���ĳһ��
			chessTemp[row][i] = 1;
			//���û�г�ͻ�ͷ�����һ��
			if (isSafe(chessTemp, row, i)) {
				putAtRow(chessTemp, row+1);
			}
		}
		
	}

	/**
	 * �жϷ�����֮���Ƿ����һ�в����˳�ͻ
	 * @param chess
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isSafe(int[][] chess, int row, int col) {
		int step=1;
        while(row-step>=0){
            if(chess[row-step][col]==1)                //����
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //����
                return false;
            if(col+step<N && chess[row-step][col+step]==1)        //����
                return false;
            
            step++;
        }
        return true;
    }
	
	/**
	 * ��ʼ������
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
