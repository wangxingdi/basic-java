package com.youyanpai.leetcode.algorithm;

public class Code25 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		ListNode node = reverseKGroup(node1, 3);
		while(node != null){
			System.out.print(node.val);
			node = node.next;
			if (node != null){
				System.out.print(" -> ");
			}
		}
	}
	//25-k个一组翻转链表
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(k==0){
			return head;
		}
		if(head == null || head.next == null){
			return head;
		}
		ListNode tmp = head;
		for(int i=1;i<k&&tmp!=null;i++){
			tmp = tmp.next;
		}
		if(tmp == null){
			return head;
		}
		ListNode t2 = tmp.next;
		tmp.next = null;
		//获取反转后的链表表头
		ListNode newHead = reverseList(head);
		//获取分组
		ListNode newTmp = reverseKGroup(t2, k);
		head.next = newTmp;
		return newHead;
	}
	
	/**
	 * 翻转链表
	 * @param head
	 * @return
	 */
	private static ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode result = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return result;
	}
	
	/**
	 * 链表数据结构
	 * @author wangxd
	 */
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}

}
