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
		do{
			System.out.println("�������֣����¡�#������");
			list = CreatList();
			System.out.println("�Ƿ���� : Y or N?");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			go = (char) br.read();
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
	
	}
