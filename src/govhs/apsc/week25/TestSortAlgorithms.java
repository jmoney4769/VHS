package govhs.apsc.week25;
/* Author: Jared Moore
 * School: Spaulding High School
 * Date: Tuesday 13 March, 2012
 */

import java.util.Random;
import java.util.Scanner;

public class TestSortAlgorithms {

	public static void main(String[] args) {
		Random gen = new Random(); // the method from the book
		int[] a = new int[20];
		
		for (int i = 0; i < a.length; i++)
			a[i] = gen.nextInt(100);
		
		printArray(a);
		switch (menu()) { // my implementation of a menu
		case 1:
			selectionSort(a, 0, a.length - 1);
			break;
		case 2:
			bubbleSort(a);
			break;
		case 3:
			insertionSort(a);
		case 4: 
			mergeSort(a);
		case 5:
			quickSort(a, 0, a.length - 1);
		}
		printArray(a);
	}

	private static int menu() {
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
		while (choice == 0) {
			System.out.println("\nChoose sort method:\n1) Selection Sort\n2) Bubble Sort\n3) Insertion Sort\n" +
					"4) Merge Sort\n5) Quick Sort");
			choice = input.nextInt();
			choice = ((choice >= 1) && (choice <= 5) ? choice : 0);
			if (choice == 0) 
				System.out.println("Try Again");
		}
		return choice;
	}

	private static void printArray(int[] a) {
		for (int i : a)
			System.out.print(i + " ");
		System.out.println(); // Using the double quotes is unnecessary
		
	}
	// I believe that we were supposed to use the methods from the book, so the ones here are pretty much
		// the ones from the book.  
	public static void bubbleSort(int[] a) { // sorts an array of Strings using bubble
		//sort
    	int k = 0;
    	boolean exchangeMade = true;
    	while ((k < a.length) && (exchangeMade)) {
    		exchangeMade = false;
    		k++;
    		for (int j = 0; j < a.length - k; j++) {
    			if ((a[j]) > (a[j + 1])) { 
    				int temp = a[j];
    				a[j] = a[j + 1];
    				a[j + 1] = temp;
    				exchangeMade = true;
    			} 
    			for (int i = 0; i < a.length; i++) {
    				System.out.println(a[i]);
    			}
    		}
    		System.out.println(exchangeMade);
    	}    	
	}
    
    public static void selectionSort(int[] a, int first, int last) {
    	
    	for (int i = first; i < last; i++) {
    		int minIndex = findMinimum(a, i);
    		if (minIndex != i)
    			swap(a, i, minIndex);
    		for (int j : a)
    			System.out.print(j + " ");
    		System.out.println();
    	}
		
	}

	private static void swap(int[] a, int first, int second) {
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}

	private static <E> int findMinimum(int[] a, int first) {
		int minIndex = first;
		
		for (int i = first + 1; i < a.length; i++)
			if (a[i] < a[minIndex])
				minIndex = i;
		return minIndex;
	}
	
	public static void insertionSort(int[] a) {
		
		int itemToInsert;
		int j;
		boolean stillLooking;
		
		for (int k = 1; k < a.length; k++) {
			itemToInsert = a[k];
			j = k - 1;
			stillLooking = true;
			
			while ((j >= 0) && stillLooking)
				if (itemToInsert < a[j]) {
					a[j + 1] = a[j];
					j--;
				}
				else stillLooking = false;
			a[j + 1] = itemToInsert;
			for (int s : a)
				System.out.print(s + " ");
			System.out.println();
		}		
	}

	private static void mergeSort(int[] a) {
		int middle = a.length / 2;
		int[] copyBuffer = new int[a.length];
		mergeSortHelper(a, copyBuffer, 0, middle);
		
		
	}

	private static void mergeSortHelper(int[] a, int[] copyBuffer, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSortHelper(a, copyBuffer, low, middle);
			mergeSortHelper(a, copyBuffer, middle + 1, high);
			merge(a, copyBuffer, low, middle, high);
		}
		
	}

	private static void merge(int[] a, int[] copyBuffer, int low, int middle, int high) {
		int i1 = low, i2 = middle + 1;
		for (int i = low; i <= high; i++) {
			if (i1 > middle)
				copyBuffer[i] = a[i2++];
			else if (i2 > high)
				copyBuffer[i] = a[i1++];
			else if (a[i1] < a[i2])
				copyBuffer[i] = a[i1++];
			else 
				copyBuffer[i] = a[i2++];
		}
		
		for (int i = low; i <= high; i++)
			a[i] = copyBuffer[i];		
	}

	private static void quickSort(int[] a, int left, int right) {
		
		if (left >= right)
			return;
		
		int i = left;
		int j = right;
		int pivotValue = a[(left + right) / 2];
		while (i < j) {
			while (a[j] < pivotValue)
				i++;
			while (pivotValue < a[j])
				j--;
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		quickSort(a, left, j);
		quickSort(a, i, right);
	}
}
