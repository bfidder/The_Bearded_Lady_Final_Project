package sorting.gui;

import java.awt.Color;
import java.util.Collections;
import java.util.LinkedList;

import sorting.Sorter;
import sorting.Swap;

public class SortFastDisplay extends SortDisplay {
	volatile int numSorts;

	public SortFastDisplay(int numRect, Sorter[] sorter) {
		super(numRect, sorter);
		numSorts = sorter.length;
	}

	@Override
	protected void run() {
		while(numSorts>0){
			for(Sorter s : allTheData.keySet()){
				LinkedList<Swap> curSwaps = allTheSwaps.get(s);
				if(!curSwaps.isEmpty()){
					Swap curSwap = curSwaps.pop();
					Collections.swap(allTheData.get(s), curSwap.getStart(), curSwap.getEnd());
					if(curSwaps.isEmpty()) {
						numSorts--;
					}
				}
				
			}
			try {
				update(getGraphics());
				Thread.sleep(250);
			} catch (InterruptedException e) {
				System.out.println("FFUUUUUU");
			}
		}
	}
}
