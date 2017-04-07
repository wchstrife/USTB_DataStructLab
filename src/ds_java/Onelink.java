package ds_java;
import ds_java.OnelinkNode;

public class Onelink {
	
	protected OnelinkNode head;//ͷ���
	
	public Onelink(){
		head = null;
	}
	
	public Onelink(OnelinkNode h1){//����ָ��h1�Ľڵ�

		head = h1;
	}
	
	/*����n�����ֵ������*/
	public Onelink(int n){ 
		OnelinkNode rear;//βָ��
		OnelinkNode q;
		if(n>0){
			int k = (int) (Math.random()*100);
			head = new OnelinkNode(k);
			rear = head;
			for(int i=1; i<n; i++){
				k = (int) (Math.random()*100);
				q = new OnelinkNode(k);
				rear.next = q;
				rear = q;
			}
		}
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public int length(){

		int n = 0;
		OnelinkNode p = head;
		while( p!=null ){
			n++;
			p = p.next;
		}
		return n;
	}
	
	public void output(){
		this.output(head);
	}
	
	public void output(OnelinkNode p){
		System.out.print(this.getClass().getName()+":  ");
		
		while(p!=null){
			System.out.print(p.data);
			p = p.next;
			if(p != null){
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}
	
	public void reverse(){
		OnelinkNode p=this.head,q=null,front=null;
		while(p!=null){
			q=p.next;
			p.next = front;
			front = p;
			p =q;
		}
		this.head = front;
	}
	
	public void insert(int k){
		OnelinkNode p=null,q=null,t;
		t = new OnelinkNode(k);
		if(head == null)//�ձ����
			head = t;
		else{	
			if(k<head.data){
				t.next = head;
				head = t;
			}
			else{
				q = head;
				while(q!=null && k>q.data){
					p = q;//ǰ��
					q = q.next;
				}
				t.next = p.next;
				p.next = t;
			}
		}
	}
}

