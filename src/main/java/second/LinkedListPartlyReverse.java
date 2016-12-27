package second;

/*
 * I made it. this code can be used to array partly from one to length - 1 .
 * you should know the relationship between pointer and real node
 */
//import java.util.Random;

public class LinkedListPartlyReverse {

	public static LinkedNode partlyReverse(LinkedNode head, int m, int n) {
		LinkedNode p1 = new LinkedNode(0);
		p1.next = head;
		LinkedNode p0 = p1;
		for (int i = 0; i < m - 1; i++) {
			p1 = p1.next;
		}
		LinkedNode p2 = p1.next;
		LinkedNode p3;
		// 头插法
		for (int i = 0; i < n - m; i++) {
			p3 = p2.next;
			p2.next = p3.next;
			p3.next = p1.next;
			p1.next = p3;
		}
		return p0.next;
	}

	public static void print(LinkedNode head) {
		System.out.print(head.val);
		while (head.next != null) {
			head = head.next;
			System.out.print("->" + head.val);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Random rand = new Random(57);
		// LinkedNode head = new LinkedNode(9);
		// LinkedNode p = head;
		// for (int i = 0; i < 4; i++) {
		// LinkedNode n = new LinkedNode(rand.nextInt(10));
		// p.next = n;
		// p = n;
		// }
		LinkedNode n1 = new LinkedNode(1);
		LinkedNode n2 = new LinkedNode(2);
		n1.next = n2;
		LinkedNode n3 = new LinkedNode(3);
		n2.next = n3;
		LinkedNode n4 = new LinkedNode(4);
		n3.next = n4;
		LinkedNode n5 = new LinkedNode(5);
		n4.next = n5;
		print(n1);
		LinkedNode res = partlyReverse(n1, 2, 5);
		print(res);
	}
}
