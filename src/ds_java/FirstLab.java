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
			System.out.println("�������֣����¡�#������");
			list = CreatList();
			System.out.println("���������ڵ�λ��");
			local = (int)br.nextInt();
			result = Adjmax(list, local);
			System.out.println("�������ı����"+result);
			System.out.println("�Ƿ���� : Y or N?");			
			go = (char) br.nextInt();
		}while(go == 'Y' );
		
		}
	
	static Onelink CreatList(){
		Onelink list = new Onelink();
		int k;
		Scanner cin = new Scanner(System.in);				
		
		/*��ȡ���������*/
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
