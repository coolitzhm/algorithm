package second;

public class KMPnew {
	public static int KMPMatch(String text,String pattern){
		char[] chtext = text.toCharArray();
		char[] chpattern = pattern.toCharArray();
		int lenT = chtext.length;
		int lenP = chpattern.length;
		int[] next = new int[lenP];
		getNext(chpattern, next);
		int ans = -1;
		int i = 0 , j = 0;
        while(i < lenT){
        	if(j == -1 || chtext[i] == chpattern[j]){
        		i++;
        		j++;
        	}else{
        		j = next[j];
        	}
        	if(j == lenP){
    			ans = i - lenP;
    			break;
    		}
        }
		return ans;
	}
	
	public static void getNext(char[] pattern,int[] next){
		int len = pattern.length;
		next[0] = -1;
		int k = -1;
		int j = 0;
		while(j < len - 1){
			if(k == -1 || pattern[k] == pattern[j]){
				k++;
				j++;
				if(pattern[k] == pattern[j])
					next[j] = next[k];
				else{
					next[j] = k;
				}
			}else{
				k = next[k];
			}
		}
//		for(int i: next){
//		System.out.print(i + " ");
//	}
//	System.out.println();
	}
	//text
	public static void main(String[] args) {
		String text = "ababcabcdfe";
		String pattern = "bcabcd";
//		String pattern2 = "aabbb";
		int res = KMPMatch(text, pattern);
		System.out.println(res);
	}

}
