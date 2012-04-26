package sorting;

import java.util.ArrayList;
import java.util.LinkedList;

public class BubbleSort extends Sorter{
	
	public BubbleSort(int ... data){
		super(data);
	}
	
	public BubbleSort(ArrayList<Integer> data){
		super(data);
	}
	
	public LinkedList<Swap> sort(){
		for (int len = data.size(); len >= 0; len--) {
			for (int i = 1; i < len; i++) {
				if (data.get(i) < data.get(i - 1)) {
					doSwap(i - 1, i);
				}
			}
		}
		
		return swapList;
	}
}
