package sorting;

import java.util.ArrayList;
import java.util.LinkedList;

public class BubbleSort extends Sorter{
	//Sets the name on the button to bubble sort
	public String getName() {
		return "Bubble Sort";
	}
	
	public BubbleSort(double ... data){
		super(data);
	}
	
	public BubbleSort(ArrayList<Double> data){
		super(data);
	}
	/*
	 * implements bubble sort by checking the current value
	 * against the value before it and swapping them if
	 * it's lower by calling doSwap on the two values
	 */
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
	@Override
	public Object clone() {
		Sorter out = new BubbleSort((ArrayList<Double>)getData().clone());
		out.swapList = (LinkedList<Swap>) swapList.clone();
		out.scrambledData = (ArrayList<Double>) scrambledData.clone();
		return out;
	}
}
