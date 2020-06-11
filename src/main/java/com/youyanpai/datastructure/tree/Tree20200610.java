package com.youyanpai.datastructure.tree;

import com.youyanpai.datastructure.tree.bean.TreeNode;

public class Tree20200610 {

	public static void main(String[] args) {
		TreeNode<Integer> node1 = new TreeNode<Integer>();
		node1.setVal(1);
		TreeNode<Integer> node2 = new TreeNode<Integer>();
		node2.setVal(2);
		TreeNode<Integer> node3 = new TreeNode<Integer>();
		node3.setVal(3);
		TreeNode<Integer> node4 = new TreeNode<Integer>();
		node4.setVal(4);
		TreeNode<Integer> node5 = new TreeNode<Integer>();
		node5.setVal(5);
		TreeNode<Integer> node6 = new TreeNode<Integer>();
		node6.setVal(6);
		TreeNode<Integer> node7 = new TreeNode<Integer>();
		node7.setVal(7);
		node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node7);
        node3.setRight(node6);
        /** ========================== **/
        System.out.println(getBinaryTreeDepth(node1));
        traversalBinaryTree(node1);
	}
	
	/**
	 * 获取二叉树深度
	 * 上海交大严蔚敏版的数据结构中,根节点的深度从1开始;而维基百科则是从0开始;
	 * @param root
	 * @return
	 */
	public static int getBinaryTreeDepth(TreeNode<Integer> root){
		if(null==root){
			return 0;
		}
		int left = getBinaryTreeDepth(root.getLeft());
		int right = getBinaryTreeDepth(root.getRight());
		return left<right?right+1:left+1;
	}
	
	/**
	 * 前序,中序,后序遍历二叉树
	 * @param root
	 */
	public static void traversalBinaryTree(TreeNode<Integer> root){
		if(root==null){ 
			return;  
		}
		//先序遍历 
		System.out.print(root.getVal()+" ");
		traversalBinaryTree(root.getLeft());
		traversalBinaryTree(root.getRight());
		/**
		 * 中序遍历(其实就是把顺序调换一下)
		 * traversalBinaryTree(root.getLeft()); 
		 * System.out.print(root.getVal()+" ");
		 * traversalBinaryTree(root.getRight()); */
		/**  
		 * 后序遍历 
		 * traversalBinaryTree(root.getLeft());
         * traversalBinaryTree(root.getRight());
         * System.out.print(root.getVal()+" "); */
	}
	
	/**
	 * 判断是否是平衡二叉树
	 * @return
	 */
	public static boolean isAvl_1(TreeNode<Integer> root){
		if(null==root){
			return true;
		}
		int left = getBinaryTreeDepth(root.getLeft());
		int right = getBinaryTreeDepth(root.getRight());
		if(left-right>1 || right-left<-1){
			return false;
		}
		return isAvl_1(root.getLeft())&&isAvl_1(root.getRight());
	}

}
