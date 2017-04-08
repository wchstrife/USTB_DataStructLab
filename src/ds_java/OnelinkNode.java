package ds_java;

public class OnelinkNode {
	
	public int data;
	
	public OnelinkNode next;
	
	public int id;
	
	public OnelinkNode(int k){//构造值为k的节点
		data = k;
		next = null;
	}
	
	public OnelinkNode(){
		this(0);
	}
}
