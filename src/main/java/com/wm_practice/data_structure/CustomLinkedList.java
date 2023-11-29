package com.wm_practice.data_structure;

import com.wm_practice.utill.Node;

/*
 * Program:Form a custom Linked List which store a value of integer
 * 
 * Agorithom
 * 
 * Time Complexity : O(n)
 * 
 * Space Complexity
 */

public class CustomLinkedList {

	Node head,tail;	
	
	public void insert(int data) {
		
		Node new_node = new Node(data);
		if(head==null) {
			head=new_node;
			tail=new_node;
		}else {
			tail.next=new_node;
			tail=new_node;
		}
	}
	
	public void printList() {
		Node temp = head;
		while(temp !=null) {
			System.out.print(temp.data +"->");
			temp=temp.next;
		}
		System.out.print("null");
	}
	/**
	 * delete data from linked list	
	 * @param d
	 */
	public void delete(int d) {
		Node temp=head;
		Node prev=head;
		while(temp!=null) {
			if(temp.data==d) {
				prev.next=temp.next;
				temp=temp.next;
			}else {
			 prev = temp;
			 temp=temp.next;
			}
				
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomLinkedList list = new CustomLinkedList();
		
		int[] a= {4,2,7,4,8,1,5,2};
		
		for(int i: a) {
			list.insert(i);
		}
		System.out.println("===after insert===");
		list.printList();
		System.out.println("===after delete===");
		list.delete(2);
		list.printList();
	}

}
