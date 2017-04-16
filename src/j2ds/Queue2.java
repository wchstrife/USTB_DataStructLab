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
		char input = scanner.next().charAt(0);
		while(input != '#'){
			System.out.println("1");
			input = scanner.next().charAt(0);
		}
	}
}
