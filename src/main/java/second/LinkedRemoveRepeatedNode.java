package second;

/*
 * remove the consequent node with the same value
 */
public class LinkedRemoveRepeatedNode extends LinkedOperation {
	public static void removeRepeatedNode(LinkedNode head) {
		if (head == null)
			return;
		int val = head.val;
		LinkedNode p1 = head;
		while (p1.next != null) {
			if (p1.next.val != val) {
				p1 = p1.next;
				val = p1.val;
			} else {
				p1.next = p1.next.next;
			}
		}
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
		LinkedNode n2 = new LinkedNode(2);
		n1.next = n2;
		LinkedNode n3 = new LinkedNode(2);
		n2.next = n3;
		LinkedNode n4 = new LinkedNode(3);
		n3.next = n4;
		LinkedNode n5 = new LinkedNode(2);
		n4.next = n5;
		LinkedNode n6 = new LinkedNode(2);
		n5.next = n6;
		print(n1);
		removeRepeatedNode(n1);
		print(n1);
	}
}
