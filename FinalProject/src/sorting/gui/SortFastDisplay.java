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

				Thread.sleep(100);
			} catch (InterruptedException e) {

			}

		}
	}
}
