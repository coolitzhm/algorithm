package second;

/*
 * 单链表公共结点的问题
 */
public class FindFirstPublicNode extends LinkedOperation {

	public static LinkedNode firstPublicNode(LinkedNode pA, LinkedNode pB) {
		int nA = size(pA);
		int nB = size(pB);

		if (nA < nB) {
			int tmp = nA;
			nA = nB;
			nB = tmp;

			LinkedNode tmpN = pA;
			pA = pB;
			pB = tmpN;
		}
		System.out.println("nA : " + nA + " nB :" + nB);

		for (int i = 0; i < nA - nB; i++) {
			pA = pA.next;
		}
		while (pA != null) {
			if (pA == pB)
				return pA;
			pA = pA.next;
			pB = pB.next;
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedNode n0 = new LinkedNode(0);
		LinkedNode n1 = new LinkedNode(1);
		LinkedNode n2 = new LinkedNode(1);
		LinkedNode n3 = new LinkedNode(2);
		LinkedNode n4 = new LinkedNode(2);
		LinkedNode n5 = new LinkedNode(3);
		LinkedNode n6 = new LinkedNode(4);
		LinkedNode n7 = new LinkedNode(5);
		n1.next = n3;
		n0.next = n2;
		n2.next = n4;
		n3.next = n5;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		LinkedNode res = firstPublicNode(n1, n0);
		System.out.println(res.val);
		print(res);
	}
}
