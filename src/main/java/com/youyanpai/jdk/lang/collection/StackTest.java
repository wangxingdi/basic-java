package com.youyanpai.jdk.lang.collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node2 = new TreeNode(2, node4, null);
		TreeNode node1 = new TreeNode(1, node2, node3);
		dlr(node1);
		System.out.println("");
		ldr(node1);
		System.out.println("");
		lrd(node1);
	}
	
	public static void dlr(TreeNode root){
		Stack<TreeNode> st = new Stack<TreeNode>();
		while(null!=root || !st.isEmpty()){
			while(null!=root){
				System.out.print(root.val+" , ");
				st.push(root);
				root = root.left;
			}
			if(!st.isEmpty()){
				root = st.pop();
				root = root.right;
			}
		}
	}
	
	public static void ldr(TreeNode root){
		Stack<TreeNode> st = new Stack<TreeNode>();
		while(null!=root || !st.isEmpty()){
			while(null!=root){
				st.push(root);
				root = root.left;
			}
			if(!st.isEmpty()){
				root = st.pop();
				System.out.print(root.val+" , ");
				root = root.right;
			}
		}
	}
	
	public static void lrd(TreeNode root){
		Stack<TreeNode> st = new Stack<TreeNode>();
		Stack<Integer> pre = new Stack<Integer>();
		Integer i = new Integer(1);
        while(root!=null || !st.empty()){
            while(root!=null){
                st.push(root);
                pre.push(new Integer(0));
                root = root.left;
            }
            while(!st.empty() && pre.peek().equals(i)){
                pre.pop();
                System.out.print(st.pop().val);
            }
            if(!st.empty()){
                pre.pop();
                pre.push(new Integer(1));
                root =st.peek();
                root = root.right;
            }
        }
	}
	
	static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val, TreeNode left, TreeNode right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
