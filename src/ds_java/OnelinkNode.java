package ds_java;

public class OnelinkNode {
	
	public int data;
	
	public OnelinkNode next;
	
	public OnelinkNode(int k){//����ֵΪk�Ľڵ�
		data = k;
		next = null;
	}
	
	public OnelinkNode(){
		this(0);
	}
}
