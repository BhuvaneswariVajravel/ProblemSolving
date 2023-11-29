package com.wm_practice.data_structure;

import com.wm_practice.utill.Node;

/*
 * Program:Check palindrome with singly linked list characters.
 * 
 * Agorithom
 * 
 * Time Complexity : O(n)
 * 
 * Space Complexity : O(1)
 * 
 * Note: if we use stack auxilary space will taken by O(n)
 */

public class PalindromeLinkedList {

	Node head, tail, slow, fast, second;

	
	public void push(int data) {

		Node new_node = new Node(data);
		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			tail.next = new_node;
			tail = new_node;
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("null");
	}

	void reverse() {
		Node prev = null;
		Node curr = second;
		Node next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		second = prev;
	}

	boolean compareNodes(Node temp1, Node temp2) {

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else
				return false;

		}
		if (temp1 == null & temp2 == null)
			return true;

		return false;
	}

	void checkPalindrome() {

		if (head != null && head.next != null) {
			Node mid = null;
			Node prev = head;
			slow = head;
			fast = head;

			while (fast != null && fast.next != null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			if (fast != null) {
				mid = slow;
				slow = slow.next;
			}
			second = slow;
			prev.next = null;

			reverse();

			boolean res = compareNodes(head, second);

			reverse();
			if (mid != null) {
				prev.next = mid;
				mid.next = second;
			}else
				prev.next=second;

			if(res)
				System.out.println("given string is polindrome");
			else
				System.out.println("given string is not polindrome");


		}
		
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList list = new PalindromeLinkedList();

		int[] a = { 5};
		for (int i : a) {
			list.push(i);
		}

		list.checkPalindrome();
		list.printList();

	}

}
