package four;

/*
 * 循环不变式
 * Java中使用数组，像老师那样处理零位置不太容易，需要新建一个数组才能实现，不过那样空间复杂度就是O(n)了。
 * 所以0位置存1，1位置存2。。。但是方法和老师是一样的。
 */
public class FirstLostInteger {
	static int getFirstLostInteger(int[] array) {

		int size = array.length;
		int i = 0;
		int tmp;
		while (i < size) {
			if (array[i] == i + 1) {
				i++;
			} else {// 在判断条件中，体会循环不变式的思想：感觉是下面两个地方用到了：array[i]< i + 1
					// 时，舍弃掉array[i]；还有最后返回i+1。
				if (array[i] < i + 1 || array[i] > size
						|| array[array[i] - 1] == array[i]) {
					array[i] = array[size - 1];
					size--;
				} else {// array[i] > i
					// 不额外调用swap方法，可能会快一点。
					tmp = array[i];
					array[i] = array[tmp - 1];
					array[tmp - 1] = tmp;
				}
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int[] array = { 3, 5, 1, 2, 4, 7, 14, 8 };
		int res = getFirstLostInteger(array);
		System.out.println(res);
	}

}
