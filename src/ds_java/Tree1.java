/*
 * 用链表实现的二叉树
 * 作者：wchstrife
 * */
package ds_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

import ds_java.TreeNode1;

public class Tree1 {
	
	protected TreeNode1 root;//根节点
	
	public Tree1(){
		root = null;
	}
	
	/*调用二叉树中序遍历算法*/
	public void inorderTraversal(){
		System.out.print("递归中序遍历结果：");
		if(root != null){
			root.inorder(root);
			System.out.println();
		}
	}
	
	/*非递归算法中序遍历二叉树
	 * 1.节点p不空，节点入栈，进入左子树
	 * 2.p为空，栈不空，栈顶出栈，进入右子树
	 * 3.p为空，栈为空，结束
	 * */
	public void inorderNor(){
		Stack s1 = new Stack();
		TreeNode1 p = root;
		System.out.print("非递归中序遍历结果： ");
		
		while(p != null || !s1.isEmpty() ){		//p非空或者栈非空
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
		
		
		String flag = "Yes";
		String ss[] = null;
		String isFile;
		String temp;
		
		while(flag.equalsIgnoreCase("Yes")){
			Scanner scanner = new Scanner(System.in); 	//分隔输入句子的单词
			System.out.println("是否从文件输入?yes");
			isFile = scanner.next();
			if(isFile.equalsIgnoreCase("yes")){
				try{
					BufferedReader br = new BufferedReader(new FileReader("F:\\11.txt"));
					while( (temp = br.readLine()) != null){	
						ss = temp.split(" ");
					}					
					}catch(Exception e){
						System.out.println("读取错误");
					}
			}else{
			System.out.println("请输入句子");			
			ss = scanner.nextLine().split(" ");
			}
			Tree1 tree = new Tree1();		
			for(int i=0; i<ss.length; i++){
				tree.buildTree(tree.root, ss[i]);
			}
			tree.inorderTraversal();
			tree.inorderNor();
			System.out.println("是否继续");
			flag = scanner.next();
		}
		
	}
}
