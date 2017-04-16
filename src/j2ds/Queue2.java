/*
 * ʵ��������ʽ���еĻ�������
 * ���Ӽ��������һϵ���ַ��洢����ʽ�����У���������ַ�Ϊ��0��ʱ��ִ�г��Ӳ�����������Ԫ�ش�ӡ����Ļ�ϣ�
 * ��������ַ�Ϊ��@��ʱ��������ʣ������Ԫ�����γ��Ӳ���ӡ����Ļ�ϣ������������ַ�ʱ���ַ���ӡ�
 * 
 * ���ߣ�wchstrife
 * ���ڣ�2017.4.16
 * */


package j2ds;

import java.util.Scanner;

import j2ds.OnelinkNode;
import j2ds.Onelink1;

//��������ʵ�ֶ��в���
public class Queue2 extends Onelink1{
	
	private OnelinkNode front ,rear;
	
	public Queue2(){
		front = rear =null;
	}
	
	public boolean isEmpty(){
		return (front == null) & (rear == null);
	}
	
	public boolean enqueue(char k){	//���
		OnelinkNode q;
		q = new OnelinkNode(k);
		if(!isEmpty())
			rear.next = q;
		else
			front = q;
		rear = q;
		return true;
	}
	
	public char dequeue(){	//����
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
		System.out.println("���������");
		char input = scanner.next().charAt(0);	//�����ַ�
		String con = "Yes";		//�ж��Ƿ����
		while("Yes".equalsIgnoreCase(con)){
			System.out.println("���������");
			switch(input){
				case '0' : {//����0����һ��
					if(test.isEmpty()){
						System.out.println("���󣡶���Ϊ�գ�");break;
					}
					System.out.println( test.dequeue() );break;
				}
				case '@' :{//����@���ȫ����Ȼ���ж��Ƿ����
					if(test.isEmpty()){
						System.out.println("���󣡶���Ϊ�գ�");break;
					}
					while(!test.isEmpty()){
						System.out.print(test.dequeue() + "-");						
					}
					System.out.println();
					System.out.println("�Ƿ����Yes or No");
					con = scanner.next();break;
					
				}
				default :{//�������ַ�����
					test.enqueue(input);
				}
			}						
			input = scanner.next().charAt(0);			
		}
	}
}
