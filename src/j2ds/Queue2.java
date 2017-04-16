/*
 * 实验三、链式队列的基本操作
 * 将从键盘输入的一系列字符存储到链式队列中，当输入的字符为’0’时，执行出队操作并将出队元素打印到屏幕上；
 * 当输入的字符为’@’时，队列中剩余所有元素依次出队并打印到屏幕上；当输入其他字符时，字符入队。
 * 
 * 作者：wchstrife
 * 日期：2017.4.16
 * */


package j2ds;

import java.util.Scanner;

import j2ds.OnelinkNode;
import j2ds.Onelink1;

//采用链表实现队列操作
public class Queue2 extends Onelink1{
	
	private OnelinkNode front ,rear;
	
	public Queue2(){
		front = rear =null;
	}
	
	public boolean isEmpty(){
		return (front == null) & (rear == null);
	}
	
	public boolean enqueue(char k){	//入队
		OnelinkNode q;
		q = new OnelinkNode(k);
		if(!isEmpty())
			rear.next = q;
		else
			front = q;
		rear = q;
		return true;
	}
	
	public char dequeue(){	//出队
		char k = 0;
		if(!isEmpty()){
			k = front.data;
			front = front.next;
			if(front == null)
				rear = null;
		}
		return k;
	}
	
	public static void main(String[] args){
		Queue2 test  = new Queue2();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入符号");
		char input = scanner.next().charAt(0);	//输入字符
		String con = "Yes";		//判断是否继续
		while("Yes".equalsIgnoreCase(con)){
			System.out.println("请输入符号");
			switch(input){
				case '0' : {//输入0出队一个
					if(test.isEmpty()){
						System.out.println("错误！队列为空！");break;
					}
					System.out.println( test.dequeue() );break;
				}
				case '@' :{//输入@输出全部，然后判断是否继续
					if(test.isEmpty()){
						System.out.println("错误！队列为空！");break;
					}
					while(!test.isEmpty()){
						System.out.print(test.dequeue() + "-");						
					}
					System.out.println();
					System.out.println("是否继续Yes or No");
					con = scanner.next();break;
					
				}
				default :{//其他的字符进队
					test.enqueue(input);
				}
			}						
			input = scanner.next().charAt(0);			
		}
	}
}
