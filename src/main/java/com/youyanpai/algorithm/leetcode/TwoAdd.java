package com.youyanpai.algorithm.leetcode;

/**
 * 两数相加 =========================================================
 * 给出两个非空的链表用来表示两个非负的整数。 其中，它们各自的位数是按照“逆序”的方式存储的， 并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 您可以假设除了数字0之外，这两个数都不会以0开头。
 * =========================================================
 * 
 * @author wangxd
 */
public class TwoAdd {

	public static void main(String[] args) throws Exception {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(0);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result);
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        //不知道如何在循环中依次将结果放入result中 -20200220 -01
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (a != null || b != null) {
            int a1 = (a == null?0:a.val);
            int b1 = (b == null?0:b.val);
            int sum = a1 + b1 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (carry > 0) {
        	curr.next = new ListNode(carry);
        }
        return result.next;
    }
	
	
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
	}
}


