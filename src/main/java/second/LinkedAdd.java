package second;

import java.util.Random;

/*
 * the digit is expressed by the linked list reversed(what about the positive sequence)
 * notice:first: carry;second:the linkedList has different length
 * third:the last carry may cause the final length increment one .
 */

public class LinkedAdd {
	public LinkedNode linkedAdd(LinkedNode n1, LinkedNode n2) {
		int sum = n1.val + n2.val;
		int val = sum % 10;
		int carry = sum / 10;
		LinkedNode nodeNew = new LinkedNode(val);
		LinkedNode p1 = nodeNew;
		LinkedNode nodeNext;
		n1 = n1.next;
		n2 = n2.next;
		while (n1 != null && n2 != null) {
			sum = n1.val + n2.val + carry;
			val = sum % 10;
			carry = sum / 10;
			nodeNext = new LinkedNode(val);
			p1.next = nodeNext;
			p1 = nodeNext;
			n1 = n1.next;
			n2 = n2.next;
		}
		LinkedNode n = (n1 == null ? n2 : n1);
		while (n != null) {
			sum = n.val + carry;
			val = sum % 10;
			carry = sum / 10;
			nodeNext = new LinkedNode(val);
			p1.next = nodeNext;
			p1 = nodeNext;
			n = n.next;
		}
		if (carry != 0)
			p1.next = new LinkedNode(carry);
		return nodeNew;
	}

	public static void print(LinkedNode n) {
		System.out.print(n.val);
		n = n.next;
		while (n != null) {
			System.out.print("->" + n.val);
			n = n.next;
		}
		System.out.println();

	}

	public static void main(String[] args) {
		Random rand = new Random(47);
		LinkedNode n1 = new LinkedNode(9);
		LinkedNode p1 = n1;
		LinkedNode nodeNext;
		for (int i = 0; i < 6; i++) {
			nodeNext = new LinkedNode(rand.nextInt(10));
			p1.next = nodeNext;
			p1 = nodeNext;
		}
		LinkedNode n2 = new LinkedNode(8);
		LinkedNode p2 = n2;
		for (int i = 0; i < 9; i++) {
			nodeNext = new LinkedNode(rand.nextInt(10));
			p2.next = nodeNext;
			p2 = nodeNext;
		}
		print(n1);
		print(n2);
		LinkedAdd linkedAdd = new LinkedAdd();
		LinkedNode nodeNew = linkedAdd.linkedAdd(n1, n2);
		print(nodeNew);
	}
}
