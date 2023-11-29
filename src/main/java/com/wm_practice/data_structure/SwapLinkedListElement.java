package com.wm_practice.data_structure;

import com.wm_practice.utill.Node;

/*
 * Program:Swap elemets in a linkedlist
 * 
 * Agorithom : 
 * 
 * Time Complexity : O(n)
 * 
 * Auxilary space: O(1)
 * 
 * Notes: in swap by data, If data contains many fields, 
 * there will be many swap operations. instead of that changes links rather than swapping data.
 */

public class SwapLinkedListElement {

	Node head, tail;
	
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

	public void printList(Node temp) {
		System.out.println("===");
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("null");
	}

	public void swapByData(Node temp) {

		while (temp != null) {
			int d = temp.data;
			temp.data = temp.next.data;
			temp.next.data = d;
			temp = temp.next.next;
		}
	}

	public Node swapByReference(Node temp) {

		if (temp == null || temp.next == null)
			return temp;
		Node prev = temp;
		Node curr = temp.next;
		temp = curr;

		while (true) {
			Node next = curr.next;
			curr.next = prev;
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}

			prev.next = next.next;

			prev = next;
			curr = prev.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapLinkedListElement list = new SwapLinkedListElement();

		int[] a = { 2, 7, 4, 8, 1, 5 ,1};
		for (int i : a) {
			list.push(i);
		}
		list.printList(list.head);
		System.out.println("");
		if (a.length % 2 == 0) {
			Node st = list.swapByReference(list.head);
			System.out.println("Linked list after calling swapByReference() ");
			list.printList(st);
			System.out.println("");
			
//			list.swapByData(list.head);
//			System.out.println("Linked list after calling swapByData() ");
//			list.printList(list.head);
		}else {
			Node st = list.swapByReference(list.head.next);
			list.head.next=st;
			System.out.println("Linked list after calling swapByReference() ");
			list.printList(list.head);
			System.out.println("");
			
//			list.swapByData(list.head.next);
//			System.out.println("Linked list after calling swapByData() ");
//			list.printList(list.head);
		}
		
	}
}
