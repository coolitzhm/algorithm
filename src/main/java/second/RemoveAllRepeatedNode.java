package second;

/*
 * made it
 */

public class RemoveAllRepeatedNode extends LinkedOperation {
	public static LinkedNode removeAllRepeatedNode(LinkedNode head) {
		if (head == null)
			return head;
		LinkedNode p1 = new LinkedNode(Integer.MIN_VALUE);
		p1.next = head;
		LinkedNode p0 = p1;
		LinkedNode p2;
		int val = p1.next.val;
		while (p1.next.next != null) {
			if (p1.next.next.val != val) {
				p1 = p1.next;
				val = p1.next.val;
			} else {
				p2 = p1.next;
				while (p2 != null && p2.val == val) {
					p2 = p2.next;
				}
				if (p2 == null) {
					p1.next = null;
					break;
				}
				p1.next = p2;
				val = p2.val;
			}
		}
		// System.out.println(p0.val);
		// System.out.println(p0.next.val);
		return p0.next;
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
		LinkedNode n1 = new LinkedNode(2);
		LinkedNode n2 = new LinkedNode(3);
		n1.next = n2;
		LinkedNode n3 = new LinkedNode(3);
		n2.next = n3;
		LinkedNode n4 = new LinkedNode(2);
		n3.next = n4;
		LinkedNode n5 = new LinkedNode(2);
		n4.next = n5;
		LinkedNode n6 = new LinkedNode(2);
		n5.next = n6;
		print(n1);
		LinkedNode res = removeAllRepeatedNode(n1);
		print(res);
		// System.out.println(java.lang.Integer.MIN_VALUE);
	}
}
