package second.secondlesson;

/*
 * two points:
 * 1.when the stack is empty , what we should do
 * 2.stack s storage the index of histogram
 */
import java.util.Stack;

public class HistogramMaxArea {
	public static int histogramMaxArea(int[] histo) {
		Stack<Integer> s = new Stack<Integer>();
		int n = histo.length;
		int[] test = new int[n + 1];
		for (int i = 0; i < n; i++) {
			test[i] = histo[i];
		}
		test[n] = 0;
		int maxArea = 0;
		int top, width, tmp;
		for (int i = 0; i < n + 1;) {
			if (s.isEmpty() || test[i] >= test[s.peek()]) {
				s.push(i);
				i++;
			} else {
				top = test[s.pop()];
				width = s.isEmpty() ? i : i - 1 - s.peek();
				tmp = top * width;
				maxArea = maxArea > tmp ? maxArea : tmp;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] hesto = { 2, 7, 5, 6, 4 };
		int[] hesto1 = { 1 };
		int maxArea = histogramMaxArea(hesto);
		int maxArea1 = histogramMaxArea(hesto1);
		System.out.println(maxArea);
		System.out.println(maxArea1);
	}
}
