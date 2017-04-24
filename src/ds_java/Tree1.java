/*
 * ������ʵ�ֵĶ�����
 * ���ߣ�wchstrife
 * */
package ds_java;

import java.util.Scanner;
import java.util.Stack;

import ds_java.TreeNode1;

public class Tree1 {
	
	protected TreeNode1 root;//���ڵ�
	
	public Tree1(){
		root = null;
	}
	
	/*���ö�������������㷨*/
	public void inorderTraversal(){
		System.out.print("�ݹ�������������");
		if(root != null){
			root.inorder(root);
			System.out.println();
		}
	}
	
	/*�ǵݹ��㷨�������������
	 * 1.�ڵ�p���գ��ڵ���ջ������������
	 * 2.pΪ�գ�ջ���գ�ջ����ջ������������
	 * 3.pΪ�գ�ջΪ�գ�����
	 * */
	public void inorderNor(){
		Stack s1 = new Stack();
		TreeNode1 p = root;
		System.out.print("�ǵݹ������������� ");
		
		while(p != null || !s1.isEmpty() ){		//p�ǿջ���ջ�ǿ�
			if(p!=null){
				s1.push(p);
				p = p.left;
			}
			else{
				p = (TreeNode1)s1.pop();
				System.out.print(p.data+" ");
				p = p.right;
			}
			
		}
	}
	
	/*
	 * ����������
	 * ����ַ�����ASCII��С�ڸ��ڵ㣬�����������ӣ������������ͼ�������Ѱ�ң������ھͲ���ڵ�
	 * ����ַ�����ASCII����ڸ��ڵ㣬�����������ӣ������������ͼ�������Ѱ�ң������ھͲ���ڵ� 
	 * ���������ȣ��Ͳ����������
	 * */
	public void buildTree(TreeNode1 node,String data){
		if(root == null){
			root = new TreeNode1(data);
		}else{
			if( data.compareTo(node.data)<0 ){
				if(node.left == null){
					node.left = new TreeNode1(data);					
				}else{
					buildTree(node.left,data);
				}
			}else if (data.compareTo(node.data)>0 ){
				if(node.right == null){
					node.right = new TreeNode1(data);
				}else{
					buildTree(node.right,data);
				}
			}else{
				
			}
		}
		
	}
	
	public static void main(String[] args){	
		
		
		String flag = "Yes";
		
		while(flag.equalsIgnoreCase("Yes")){
			System.out.println("���������");
			Scanner scanner = new Scanner(System.in); 	//�ָ�������ӵĵ���
			String[] ss = scanner.nextLine().split(" ");
			Tree1 tree = new Tree1();		
			for(int i=0; i<ss.length; i++){
				tree.buildTree(tree.root, ss[i]);
			}
			tree.inorderTraversal();
			tree.inorderNor();
			System.out.println("�Ƿ����");
			flag = scanner.next();
		}
		
	}
}
