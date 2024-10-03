package lab02;

/**
 * Kth Smallest element in an array
 * 
 * COM2031: Divide and Conquer Labs
 * Steve Schneider
 */


import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Median {

	/**
	 * 
	 * @param arr an arraylist of integers
	 * @param k  an integer between 1 and arr.size()
	 * @return  array of the integers in arr in sorted order
	 */
	
	public static Integer kthSmallest(int k, ArrayList<Integer> arr) {
		return dac_kthSmallest(k, arr);
	}
	
	/**
	 * 
	 * @param arr    arraylist of integers
	 * @param k  	 an integer between 1 and arr.length
	 * @return       sorted arraylist of the integers in arr 
	 */
	
	public static Integer dac_kthSmallest(int k, ArrayList<Integer> arr){
		// BASE CASE
		if (arr.size() == 0) {
			return null;
		}
		if (arr.size() == 1) {
			return arr.get(0);
		}
		else {
			// DIVIDE
			//TODO 
			ArrayList<Integer> leftarr = new ArrayList<Integer>();
			ArrayList<Integer> rightarr = new ArrayList<Integer>();
			
			int pivot = arr.get(0);
			//
			// TODO: create leftarr and rightarr
			for (int i = 1; i < arr.size(); i++) {
				if (arr.get(i) < pivot) {
					leftarr.add(arr.get(i));
				} else {
					rightarr.add(arr.get(i));
				}
			}
			
			int finalK;
			// CONQUER
			if (k-1 < (leftarr.size())) {
				finalK = dac_kthSmallest(k, leftarr);
			} else if (k-1 == (leftarr.size())) {
				finalK = pivot;
			} else {
				int newK = k - leftarr.size() - 1;
				finalK = dac_kthSmallest(newK, rightarr);
			}
			// TODO: find the relevant element of the appropriate sublist 
			// leftarr or rightarr
			
			return finalK;
		}
	}
	

	public static void testKthSmallest(String name, int k, ArrayList<Integer> test, int expected){
	    int ans = kthSmallest(k, test);
	    if (ans==expected){
	    	System.out.println("  Pass:   "+name);
	    }
	    else {
	    	System.out.println("*********************");	    	
	    	System.out.println("  Fail:   "+name);
	    	System.out.println("*********************");
	    }
//	    System.out.print("\n");
	}
	
	
	public static void main(String[] args) {

		// allocate two arrays
		ArrayList<Integer> s = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 5, 6));
		testKthSmallest("test1", 3, s, 3);
		ArrayList<Integer> s2 = new ArrayList<>(Arrays.asList(9,7,5,3,1));
		testKthSmallest("test2", 4, s2, 7);
		ArrayList<Integer> s3 = new ArrayList<>(Arrays.asList(8,6,8,6,4,4,2));
		testKthSmallest("test3", 7, s3, 8);
		ArrayList<Integer> s4 = new ArrayList<>(Arrays.asList(1));
		testKthSmallest("test4", 1, s4, 1);
		ArrayList<Integer> s5 = new ArrayList<>(Arrays.asList(3,3,4,3,3,3));
		testKthSmallest("test5", 1, s5, 3);
		int N = 1000;
		int K = 27;
		ArrayList<Integer> s6 = new ArrayList<>();
		int[] ts6 = new int[N];
		int next;
		Random r = new Random();
			// create new random sequence of 1000 numbers and fill both arrays
			// identically:
			for (int j = 0; j < N; j++) {
				next = r.nextInt(10000000);
				s6.add(next);
				ts6[j] = next;
			}

			// sort s using our implementation:
			Arrays.sort(ts6);
			int e = ts6[K-1];
			testKthSmallest("test6", K, s6, e);
	}

}
