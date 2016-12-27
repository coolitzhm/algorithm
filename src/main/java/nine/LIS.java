package nine;

public class LIS {
	static int getLIS(int[] array){
		
		int len = array.length;
		int max = 1;
		int[] b = new int[len];
		
		//we should initialize every elements of b to be 1
		for(int i = 0 ; i < len; i ++){
			b[i] = 1;
		}
		
		for(int i = 1 ; i < len; i++){
			for(int j = 0; j < i; j++){
				if(array[j] < array[i]){
					b[i] = Math.max(b[j]+1, b[i]);
				}
			}
			max = Math.max(max, b[i]);
		}
		return max;
	}
	public static void main(String[] args) {
//		int[] array = {1,4,6,2,8,9,7};
		int[] array = { 1, 4, 6, 2, 3, 4, 7 };
		int res = getLIS(array);
		System.out.println(res);
	}

}
