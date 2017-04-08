package ds_java;
import ds_java.OnelinkNode;

public class Onelink {
	
	public  int count = 1;
	
	protected OnelinkNode head,tail;//ͷ���
	
	public Onelink(){
		head = null;
	}
	
	public Onelink(OnelinkNode h1){//����ָ��h1�Ľڵ�

		head = h1;
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
	
	
	public void insert(int k){
		OnelinkNode p=null,q=null,t;
		t = new OnelinkNode(k);
		t.id = count;
		if(head == null){//�ձ����
			head = t;
			tail = head;
		}
		else{	
			tail.next = t;
			tail =t;
		}
		count++;
		tail.next = null;
	}
}

