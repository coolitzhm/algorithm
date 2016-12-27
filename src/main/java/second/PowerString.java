package second;

public class PowerString {
	public static int getMinPeriod(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		int[] next = new int[len + 1];
		// we deliver the parameter len ,so we don't need to calculate again in the
		// function getNext
		getNext(chs, len, next);
		int res = len - next[len];
		//whenever we should make sure the divisor should not be zero
		if (res == 0)
			return -1;
		if (len % res == 0)
			return res;
		return -1;
	}
	// the following is transfered from teacher's code
	// the length of next array should be len
	public static void getNext(char[] chs,int[] next){
		int len = chs.length;
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < len-1){
			if(k == -1 || chs[j+1] == chs[k]){
				k++;
				j++;
				next[j] = k;
			}else{
				k = next[k];
			}
		}
		next[0] = 0;
	}
	
    //  the following has the same function with the above 
	// but I think it's more easier to understand
	public static void getNext(char[] chs, int len, int[] next) {
		next[0] = -1;
		int k = -1;
		int j = 0;
		// j have different range here from KMP
		while (j < len) {
			if (k == -1 || chs[k] == chs[j]) {
				k++;
				j++;
				next[j] = k;

			} else {
				k = next[k];
			}
		}
		// test
		// for (int i : next) {
		// System.out.print(i + " ");
		// }
		// System.out.println();
	}

	// test
	public static void main(String[] args) {
		String stest = "abcabcabcabc";
		int res = getMinPeriod(stest);
		System.out.println(res);
	}
}
