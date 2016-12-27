package second;

/*
 * note : single node to become circle
 */
import InterviewAlgorithm.LinkedNode;

public class LinkedListCycle142 {
	public static LinkedNode detectCycle(LinkedNode head) {
		if (head == null)
			return head;
		LinkedNode p1 = head;
		LinkedNode p2 = head;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
//			 if (p1 == p2)
//			 break;
			if (p1 == p2) {
				p1 = head;
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				return p1;
			}
		}
		//p1 == p2 == head,有两种情况，1.只有head一个节点，2.head是环的开始
//		 if (p1 == p2 && p2.next != null) {
//		 p1 = head;
//		 while (p1 != p2) {
//		 p1 = p1.next;
//		 p2 = p2.next;
//		 }
//		 return p1;
//		 }
		return null;
	}

	public static void print(LinkedNode head) {
		if (head == null) {
			System.out.println("node is null");
			return;
		}
		System.out.print(head.val);
		while (head.next != null) {
			head = head.next;
			System.out.print("->" + head.val);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// [-1,-7,7,-4,19,6,-9,-5,-2,-5]
		// tail connects to node index 6
		// res tail connects to node index 1
		LinkedNode n0 = new LinkedNode(-1);
//		 n0.next = n0;
		LinkedNode n1 = new LinkedNode(-7);
		// n0.next = n1;
		// n1.next = n1;
		LinkedNode n2 = new LinkedNode(7);
		LinkedNode n3 = new LinkedNode(-4);
		LinkedNode n4 = new LinkedNode(19);
		LinkedNode n5 = new LinkedNode(6);
		LinkedNode n6 = new LinkedNode(-9);
		LinkedNode n7 = new LinkedNode(-5);
		LinkedNode n8 = new LinkedNode(-2);
		LinkedNode n9 = new LinkedNode(-5);
//		LinkedNode n10 = new LinkedNode(10);

		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n7.next = n8;
		n8.next = n9;
		n9.next = n6;
//		n9.next = n10;
//		n10.next = n3;

		// print(n0);
		LinkedNode cycle = detectCycle(n0);
		System.out.println(cycle.val);
	}
}
