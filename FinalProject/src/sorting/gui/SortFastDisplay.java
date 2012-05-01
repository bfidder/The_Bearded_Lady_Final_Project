package sorting.gui;

import java.awt.Color;
import java.util.Collections;
import java.util.LinkedList;

import sorting.Sorter;
import sorting.Swap;

public class SortFastDisplay extends SortDisplay implements Runnable {

	public SortFastDisplay(int numRect, Sorter[] sorter) {
		super(numRect, sorter);
	}
	/*
	 * sorts using all three sorting types until the number of steps 
	 * done is equal to the size of the data to sort. It repaints 
	 * the display every time a swap is executed.  
	 */
	@Override
	public void run() {
		int numDone = 0;


		while(numDone < allTheSorters.size()){
			numDone=0;
			for(Sorter s : allTheSorters){
				if(!s.nextStep()){
					numDone++;
				}
			}
			try {
				repaint();

				Thread.sleep(10);
			} catch (InterruptedException e) {

			}

		}
	}
}
