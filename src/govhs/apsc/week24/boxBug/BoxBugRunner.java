package govhs.apsc.week24.boxBug;

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BoxBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);
        BoxBug bob = new BoxBug(3);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
    
    public static void bubbleSort(String[] a) { // sorts an array of Strings using bubble
		//sort
    	int k = 0;
    	boolean exchangeMade = true;
    	while ((k < a.length) && (exchangeMade)) {
    		exchangeMade = false;
    		k++;
    		for (int j = 0; j < a.length - k; j++) {
    			if ((a[j]).compareTo(a[j + 1]) == 1) { 
    				String temp = a[j];
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
    
    public static void selectionSort(String[] a) {
    	
    	for (int i = 0; i < a.length; i++) {
    		int minIndex = findMinimum(a, i);
    		if (minIndex != i)
    			swap(a, i, minIndex);
    		for (String j : a)
    			System.out.print(j + " ");
    		System.out.println();
    	}
		
	}

	private static <E> void swap(E[] a, int first, int second) {
		E temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}

	private static <E> int findMinimum(String[] a, int first) {
		int minIndex = first;
		
		for (int i = first + 1; i < a.length; i++)
			if (a[i].compareTo(a[minIndex]) < 0)
				minIndex = i;
		return minIndex;
	}
	
	public static void insertionSort(String[] a) {
		
		String itemToInsert;
		int j;
		boolean stillLooking;
		
		for (int k = 1; k < a.length; k++) {
			itemToInsert = a[k];
			j = k - 1;
			stillLooking = true;
			
			while ((j >= 0) && stillLooking)
				if (itemToInsert.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				}
				else stillLooking = false;
			a[j + 1] = itemToInsert;
			for (String s : a)
				System.out.print(s + " ");
			System.out.println();
		}		
	}
}