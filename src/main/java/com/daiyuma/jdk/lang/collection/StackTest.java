package com.daiyuma.jdk.lang.collection;

import java.util.LinkedList;
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
		System.out.println("");
		levelTraversal(node1);
	}

	public static void dlr(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		while (null != root || !st.isEmpty()) {
			while (null != root) {
				System.out.print(root.val + " , ");
				st.push(root);
				root = root.left;
			}
			if (!st.isEmpty()) {
				root = st.pop();
				root = root.right;
			}
		}
	}

	public static void ldr(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		while (null != root || !st.isEmpty()) {
			while (null != root) {
				st.push(root);
				root = root.left;
			}
			if (!st.isEmpty()) {
				root = st.pop();
				System.out.print(root.val + " , ");
				root = root.right;
			}
		}
	}

	public static void lrd(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();// 构造一个中间栈来存储逆后序遍历的结果
		TreeNode node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				output.push(node);
				stack.push(node);
				node = node.right;
			} else {
				node = stack.pop();
				node = node.left;
			}
		}
		while (output.size() > 0) {
			System.out.print(output.pop().val + " , ");
		}
	}

	public static void levelTraversal(TreeNode root) {
		if (null == root) {
			return;
		}
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		while (!list.isEmpty()) {
			TreeNode node = list.remove();
			System.out.print(node.val + " , ");
			if (null != node.left) {
				list.add(node.left);
			}
			if (null != node.right) {
				list.add(node.right);
			}
		}
	}

	static class TreeNode {
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
