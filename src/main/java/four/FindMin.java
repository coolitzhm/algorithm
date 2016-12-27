package four;

/*
 * 二分法,假设没有重复的值,不能处理只有一个元素的值，不过添加上也很简单
 */
public class FindMin {
	static int findMin(int[] array) {
		int n = array.length;
		int left = 0;
		int right = n - 1;
		int mid;
		while (left < right) {
			mid = (left + right) / 2;
			// 不能像老师那样写，否则下面的测试用例会陷入死循环
			// 老师的写法的问题是，当mid = left时，array[mid] = array[left]，这种情况没有进行处理，所以会死循环
			if (array[mid] >= array[left]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return array[left];
	}

	public static void main(String[] args) {
		int[] array = { 4, 2 };
		int res = findMin(array);
		System.out.println(res);
	}
}
