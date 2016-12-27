package second;

public class LinkedOperation {
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
	public static int size(LinkedNode n1){
		int size = 0;
		while(n1 != null){
			size++;
			n1 = n1.next;
		}
		return size;
	}
}
