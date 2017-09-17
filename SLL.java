package com.ds;

import java.io.IOException;
import java.util.Scanner;

class Node{

	int val;
	Node next;
	
	
	public Node() {
		super();
	}


	public Node(int val, Node next) {
		super();
		this.val = val;
		this.next = next;
	}


	public Node(int i) {
		super();
		this.val = val;
	}


	public int getVal() {
		return val;
	}


	public void setVal(int val) {
		this.val = val;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}
	
	
}


public class SLL {

	public static void main(String[] args) throws IOException, InterruptedException  {
		Node h = null;//new Node(10);
		//h= create(h);
		//display(h);
		//findNthNodeFromEnd(h);
		h= createManual();
		detectAndRemoveLoop(h);	
		display(h);
		
	}
	
    private static Node createManual() {
     	Node n2= new Node(40,null);
    	Node n1= new Node(30,n2);
    	Node n= new Node(20,n1);
    	Node h= new Node(10,n);
    	n2.setNext(h.next.next);
    	return h;
	}

// Function that detects loop in the list
   static void detectAndRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head.next; //geeeksforgeeks ??
       // Node fast = head;
        
        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null && fast.next.next != null) {
            if (slow == fast) {
            	System.out.println("Loop detected: " + fast.val );
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
 
        /* If loop exists */
        if (slow == fast) {
            slow = head;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
 
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
 
        }
    }
 

	private static void findNthNodeFromEnd(Node h) {
		Node p = h;
		Node q =p,r= null;
		System.out.println("Enter the Nth position from end");
		Scanner sc = new Scanner(System.in);
		int NthPos= sc.nextInt();
		int count= 0;
		while(count++ != NthPos){
			q= q.next;
		}
		while(q != null){
			p = p.next;
			q= q.next;
		}
		System.out.println("Nth Node From End : "+p.val);
	}

	private static void display(Node h) throws InterruptedException {
		Node p =h;
		System.out.println("============Display()=====================");
		while(p != null){
			System.out.println(p.getVal());
			p=p.next;
		}
		System.out.println("========================================\n\n");

	}

	private static Node create(Node h) throws IOException {
		Node p =h;
		System.out.println("============Create()=====================");
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = null;
		do{
			Node n = new Node();
			System.out.println("Enter val for Node: ");
			n.setVal(sc.nextInt());
			if(h== null){
				h=n;
				p=n;
			}
			else
			{
				p.next=n; 
				p= n;
			}
			
			System.out.println("Enter y for add more Nodes");
			sc2 = new Scanner(System.in);
		}while(sc2.next().equalsIgnoreCase("y"));
		return h;
}

}
