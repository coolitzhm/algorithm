package second;

public class StringMatchKMP {

	public static int KMPmatch(String textString,String patternString){
		char[] text = textString.toCharArray();
		char[] pattern = patternString.toCharArray();
	    int lenT = text.length;
	    int lenP = pattern.length;
	    int[] next = new int[lenP];
	    getNext(pattern,next);
	    int i = 0, j = 0;
	    while(i < lenT && j < lenP){
	    	if(j == -1 || text[i] == pattern[j]){
	    		i++;
	    		j++;
	    	}else{
	    		j = next[j];
	    	}
	    }
//	    System.out.println(j);
//	    System.out.println(i);
	    if(j == lenP)
	    	return i - lenP ;
	    else{
	    	return -1;
	    }
	}
	public static void getNext(char[] chs,int[] next){
		int len = chs.length;
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < len - 1){
			if(k == -1 || chs[k] == chs[j]){
				j++;
				k++;
				next[j] = k;
			}else{
				k = next[k];
			}
		}
//		for(int i: next){
//			System.out.print(i + " ");
//		}
//		System.out.println();
	}
	//test
	public static void main(String[] args) {
		String text = "ababcabcdfe";
		String pattern = "bcabcd";
		int res = KMPmatch(text, pattern);
		System.out.println(res);
	}
}
