/*
 * ������ʵ�ֵĶ������ڵ�
 * 
 * ���ߣ�wchstrife
 * */

package ds_java;

import java.util.Stack;

public class TreeNode1 {
	
	public String data;
	
	public TreeNode1 left,right;
	
	public TreeNode1(){
		this("?");
	}
	
	public TreeNode1(String d){
		data = d;
		left = right =null;
	}
	
	/*�ݹ��㷨�������������*/
	public void inorder(TreeNode1 p){
			if(p != null){
				inorder(p.left);
				System.out.print(p.data + " ");
				inorder(p.right);
			}
	}
	
	
}
