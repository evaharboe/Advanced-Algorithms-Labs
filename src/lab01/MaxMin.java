package lab01;

/**
 * Find the maximum and minimum values in an array using Divide and Conquer
 * 
 * COM2031: Divide and Conquer Labs
 * Autumn Semester 2020
 * Steve Schneider
 */


public class MaxMin {

	public static int[] maxMin(int[] arr){
		return dac_maxMin(arr, 0, arr.length);
	}
	
	/**
	 * 
	 * @param arr  a non-empty array of integers
	 * @param start   an index of arr
	 * @param end     end - 1 is an index of arr and start <= end-1
	 * @return        the minimum and maximum values in arr between start (inclusive) and end (exclusive)
	 */
	
	
	public static int[] dac_maxMin(int[] arr, int start, int end) {
		if (start == end-1) { // BASE CASE
			int[] maxMin = {arr[start],arr[start]};
			return maxMin;
		}
		else { 
			// DIVIDE
			int mid = (start + end) / 2;
			int[] maxMin = new int[2];
			int[] maxMin1 = new int[2];
			int[] maxMin2 = new int[2];
			
			// CONQUER
			maxMin1 = dac_maxMin(arr, start, mid);
			maxMin2 = dac_maxMin(arr, mid, end);
			
			// COMBINE
			maxMin[0] = Math.min(maxMin1[0], maxMin2[0]);
			maxMin[1] = Math.max(maxMin1[1], maxMin2[1]);
			
			return maxMin;
		}
	}
	
	
	// Utilities to assist in testing	
	
		public static void printArray(int[] a) {
			System.out.print("{");
			for(int i = 0; i< a.length-1; i++) {
				System.out.print(a[i] + ", ");			
			}
				if(a.length>0) {
					System.out.print(a[a.length - 1]);
			
				}
			System.out.print("}");
		}
			
		public static void testSum(int[] a, int minexpected, int maxexpected){
		    int[] mm = maxMin(a);
		    if(mm[0]==minexpected && mm[1] == maxexpected) {
		    	System.out.print("  Pass:   ");
		    }
		    else {
		    	System.out.println("*********************");	    	
		    	System.out.print("  Fail:   ");
		    }
		    System.out.print("maxMin(");
		    printArray(a);
		    System.out.print(") is {"+ mm[0] +","+ mm[1] +"}");
		    if(mm[0]!=minexpected || mm[1] != maxexpected) {
		    	System.out.print(", correct value is {"+minexpected+","+maxexpected+"}\n");
		    	System.out.print("*********************");
		    }
		    System.out.print("\n");
			}
			
			
		public static void main(String[] args) {
			System.out.print("Tests for maxmin:\n\n");
			testSum(new int[] {3}, 3, 3);
			testSum(new int[] {1,2,3,4}, 1, 4);
			testSum(new int[] {3, -3, 2, -2, 1, -1, 0}, -3, 3);
			testSum(new int[] {31,2,3,4,5,10,9,8,7,6,20}, 2, 31);	
		}

	}
