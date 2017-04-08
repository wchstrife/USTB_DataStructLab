package ds_java;
import ds_java.OnelinkNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import ds_java.Onelink;

public class FirstLab {
	

	public static void main(String[] args) throws IOException {
		
		String go;
		Onelink list;
		int local;
		int result;
		Scanner br = new Scanner(System.in);
		do{
			System.out.println("输入数字，按下‘#’结束");
			FirstLab mylab = new FirstLab();
			list = mylab.CreatList();
			System.out.println("请输入相邻的位数");
			local = (int)br.nextInt();
			mylab.Adjmax(list, local);
			System.out.println("是否继续 : Yes or No?");			
			go =  br.next();
		}while(go.equals("Yes") );
		
		}
	
	 Onelink CreatList(){
		Onelink list = new Onelink();
		int k;
	
		Scanner cin = new Scanner(System.in);				
		
		/*读取输入的链表*/
		while(cin.hasNext()){
			k = cin.nextInt();
			if(k==0){
				break;
			}
			list.insert(k);			
		}
		list.output();
		return list;
	}
	
	 void Adjmax(Onelink L,int k ){
		OnelinkNode p1,p2;
		int k1;
		int sum=0,max=0;
		int location=0;
		int val=0;
		p1 = L.head;
		if(p1 == null || (L.length())-1 < k ){
			 System.out.println("输入有误");
		}
		while(p1 != null){
			k1 = k;
			p2 = p1;
			while((k1--!=0) && (p2!=null)){
				sum += p2.data;
				p2 = p2.next;
			}
			if(sum > max){
				location = p1.id;
				val = p1.data;
				max = sum;
			}
			p1 = p1.next;
			sum = 0;
		}
		System.out.println("  序号: "+location +"  data值: "+ val + "  最大值: "+ max);
	}
	
	}
