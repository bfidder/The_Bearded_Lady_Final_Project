package sorting.gui;

import java.util.Collections;
import java.util.LinkedList;

import sorting.Sorter;
import sorting.Swap;

public class SortSlowDisplay extends SortDisplay {



	public SortSlowDisplay(int numRect, Sorter[] sorter) {
		super(numRect, sorter);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void run(){
		for(Sorter s : allTheData.keySet()){
			LinkedList<Swap> curSwaps = allTheSwaps.get(s);
			if(!curSwaps.isEmpty()){
				Swap curSwap = curSwaps.pop();
				Collections.swap(allTheData.get(s), curSwap.getStart(), curSwap.getEnd());
			
			}
		}
		repaint();
	}
}
