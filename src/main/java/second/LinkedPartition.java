package second;

public class LinkedPartition extends LinkedOperation {

	public static LinkedNode partition(LinkedNode head, int partition) {
		if (head == null)
			return head;
		LinkedNode p1 = new LinkedNode(Integer.MIN_VALUE);
		LinkedNode p2 = new LinkedNode(Integer.MIN_VALUE);
		LinkedNode li = p1;
		LinkedNode la = p2;
		LinkedNode p0 = head;
		while (p0 != null) {
			if (p0.val < partition) {
				p1.next = p0;
				p1 = p0;
			} else {
				p2.next = p0;
				p2 = p0;
			}
			p0 = p0.next;
		}
		p2.next = null;// if we neglect this, it will be an unlimited circular
						// list
		p1.next = la.next;
		return li.next;
	}

	public static void main(String[] args) {
		LinkedNode n1 = new LinkedNode(3);
		LinkedNode n2 = new LinkedNode(4);
		n1.next = n2;
		LinkedNode n3 = new LinkedNode(4);
		n2.next = n3;
		LinkedNode n4 = new LinkedNode(4);
		n3.next = n4;
		LinkedNode n5 = new LinkedNode(4);
		n4.next = n5;
		LinkedNode n6 = new LinkedNode(5);
		n5.next = n6;
		print(n1);
		LinkedNode res = partition(n1, 4);
		print(res);
	}
}
