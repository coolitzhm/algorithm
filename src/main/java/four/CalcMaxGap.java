package four;

public class CalcMaxGap {
	static int getMaxGap(int[] array) {
		int min = array[0];
		int max = array[0];
		int size = array.length;
		int i;
		// find the max value and min value in the array
		for (i = 0; i < size; i++) {
			if (array[i] > max) {
				max = array[i];
			} else if (array[i] < min) {
				min = array[i];
			}
		}

		// to put all the values into the bucket
		Bucket[] buckets = new Bucket[size];

		// must initialize the element of buckets for java
		// which is different from C++
		for (i = 0; i < size; i++) {
			buckets[i] = new Bucket();
		}

		int nBuckets;
		int delta = max - min;
		for (i = 0; i < size; i++) {
			nBuckets = (array[i] - min) * size / delta;
			if (nBuckets >= size) // nBuckets最大值是size，即array[i] = max时
				nBuckets = size - 1;
			buckets[nBuckets].add(array[i]);
		}

		// find the max gap,buckets[0] must be valid
		int nGap = delta / size;
		i = 0;
		int gap;
		for (int j = 1; j < size; j++) {
			if (buckets[j].valid) {
				gap = buckets[j].min - buckets[i].max;
				if (gap > nGap)
					nGap = gap;
				i = j;
			}
		}

		return nGap;
	}

	public static void main(String[] args) {
		// int[] array = { 1, 4, 7, 9, 13, 14 };
		// int[] array = { 1, 3, 8, 10, 19 };
		int[] array = { 1, 5 };
		int res = getMaxGap(array);
		System.out.println(res);
	}
}

class Bucket {
	boolean valid = false;
	int min, max;

	void add(int value) {
		if (!valid) {
			min = max = value;
			valid = true;
		} else {
			if (value > max) {
				max = value;
			} else {
				if (value < min) {
					min = value;
				}
			}
		}
	}
}
