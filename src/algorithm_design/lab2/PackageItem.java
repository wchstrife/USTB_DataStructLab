package algorithm_design.lab2;

/**
 * 0 1 ��������
 * http://blog.csdn.net/xp731574722/article/details/70766804
 * @author Administrator
 *
 */
public class PackageItem {

	public static void main(String[] args){
		
		int itemNumber = 6;
		int packageWeight = 12;
		
		int arr[][] = new int[itemNumber + 1][packageWeight + 1];//��̬�滮������
		int weight[] = {4, 6, 2, 2, 5, 1};//������Ʒ������
		int value[] = {8, 10, 6, 3, 7, 2};//������Ʒ�ļ�ֵ
		
		
		/**
		 * ��������
		 */
		for(int i=0; i<itemNumber + 1; i++)
			for(int j=0; j<packageWeight+1; j++){
				arr[i][j] = 0;
			}
		
		/**
		 * ����̬�滮�Ķ�ά�����ͼ
		 * �±��1��ʼʱΪ�˷�ֹ����Խ��
		 */
		for(int i=1; i<itemNumber + 1; i++)
			for(int j=1; j<packageWeight+1; j++){
				if(j < weight[i-1]){	//��ǰ��������
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
		
		System.out.println("��������Ϊ��" + packageWeight + " ʱ�����Ž�Ϊ:" + arr[itemNumber][packageWeight]);
		
	}
	
	
}
