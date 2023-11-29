package com.wm_practice.data_structure;

import com.wm_practice.utill.Node;

/*
 *Time Complexity : O(n) 
 *Auxilary space : O(1)
 *reg:https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 * /?page=1&company[]=Walmart&category[]=Linked%20List&sortBy=submissions
 * 
 */

public class DetectLoopLinkedList {

	static Node head, tail;

	static void push(int d) {
		Node new_node = new Node(d);
		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			tail.next = new_node;
			tail = new_node;
		}
	}

	static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("null");
	}

	static void makeLoop(int p) {

		Node temp = head;

		if (p == 0)
			return;

		for (int i = 1; i < p; i++) {
			if (temp != null)
				temp = temp.next;
		}
		tail.next = temp;
	}

	static void detectLoop(Node h) {

		boolean flag = false;
		if (h.next == null)
			return;

		Node slow = h, fast = h;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				detectLoopNode(slow);
				break;
			}
		}
		if (flag == false)
			System.out.println("No Loop=====");

	}

	static void detectLoopNode(Node loop) {
		Node ptr1 = loop, ptr2 = loop;
		int k = 1;
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}
		ptr1 = head;
		ptr2 = head;
		while (k > 0) {
			ptr2 = ptr2.next;
			k--;
		}
		while (ptr1 != ptr2) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		while (ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		}

		System.out.println("Loop node is " + ptr1.data);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		DetectLoopLinkedList llist = new DetectLoopLinkedList();
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		int x = 6;
		for (int i = 0; i < arr.length; i++) {
			llist.push(arr[i]);
		}

		/* Create loop for testing */

		printList(head);

		makeLoop(x);
		detectLoop(head);
	}
}
