package lab02;

/**
 * Kth Smallest element in an array
 * 
 * COM2031: Divide and Conquer Labs
 * Steve Schneider
 */

import java.util.ArrayList;

public class Median {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(3);
        list.add(1);
        
        double median;
        int size = list.size();

        QuickSort.quickSort(list);
        
        if (size % 2 == 0) {
 
            int m1 = list.get(size / 2 - 1);
            int m2 = list.get(size / 2);
            median = (m1 + m2) / 2.0;
        } else {
            median = list.get(size / 2);
        }
        
        System.out.println("Median is " + median);
	}
}