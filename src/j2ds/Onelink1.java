package j2ds;
import j2ds.OnelinkNode;

public class Onelink1 {
	
	protected OnelinkNode head;
	
	public Onelink1(){
		head = null;
	}
	
	public Onelink1(OnelinkNode h1){
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
}
