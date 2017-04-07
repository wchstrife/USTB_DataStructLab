package ds_java;
import ds_java.OnelinkNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import ds_java.Onelink;

public class FirstLab {

	public static void main(String[] args) throws IOException {
		
		char go;
		Onelink list;
		int local;
		int result;
		Scanner br = new Scanner(System.in);
		do{
			System.out.println("输入数字，按下‘#’结束");
			list = CreatList();
			System.out.println("请输入相邻的位数");
			local = (int)br.nextInt();
			result = Adjmax(list, local);
			System.out.println("相邻最大的编号是"+result);
			System.out.println("是否继续 : Y or N?");			
			go = (char) br.nextInt();
		}while(go == 'Y' );
		
		}
	
	static Onelink CreatList(){
		Onelink list = new Onelink();
		int k;
		Scanner cin = new Scanner(System.in);				
		
		/*读取输入的链表*/
		while(cin.hasNext()){
			k = cin.nextInt();			
			if(k == 0){
			break;
			}
			list.insert(k);
		}
		list.output();
		return list;
	}
	
	static int Adjmax(Onelink L,int k ){
		return k;
	}
	
	}
