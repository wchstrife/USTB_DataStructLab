/*
 * 用链表实现的二叉树
 * 作者：wchstrife
 * */
package ds_java;

import java.util.Scanner;

import ds_java.TreeNode1;

public class Tree1 {
	
	protected TreeNode1 root;//根节点
	
	public Tree1(){
		root = null;
	}
	
	/*调用二叉树中序遍历算法*/
	public void inorderTraversal(){
		System.out.print("中序遍历结果：");
		if(root != null){
			root.inorder(root);
			System.out.println();
		}
	}
	
	/*
	 * 创建二叉树
	 * 如果字符串的ASCII码小于父节点，在左子树连接，存在左子树就继续向下寻找，不存在就插入节点
	 * 如果字符串的ASCII码大于父节点，在右子树连接，存在右子树就继续向下寻找，不存在就插入节点 
	 * 如果二者相等，就不进入二叉树
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
		Scanner scanner = new Scanner(System.in); 	//分隔输入句子的单词
		String[] ss = scanner.nextLine().split(" ");
		Tree1 tree = new Tree1();
		System.out.print("请输入句子");
		for(int i=0; i<ss.length; i++){
			tree.buildTree(tree.root, ss[i]);
		}
		tree.inorderTraversal();
	}
}
