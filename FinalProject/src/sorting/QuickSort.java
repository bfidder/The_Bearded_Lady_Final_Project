package sorting;

import java.util.ArrayList;
import java.util.LinkedList;

public class QuickSort extends Sorter {

	public QuickSort(double ... data){
		super(data);
	}
	
	public QuickSort(ArrayList<Double> data){
		super(data);
	}
	
	@Override
	public LinkedList<Swap> sort() {
		sort(0, data.size()-1); 
		return swapList; 
	}
	private int partition(int less, int greater, int pivot) {
		Double pivotValue = data.get(pivot);
		int newPivot;
		doSwap(pivot, greater);
		int curIndex = less;
		for(int i = less; i < greater; i++){
			if(data.get(i) < pivotValue) {
				doSwap(i, curIndex);
				curIndex++;
			}
		}
		doSwap(curIndex, greater);
		return curIndex; 
	}
	
	public void sort(int less, int greater) {
		int pivot;
		if(less < greater) {
			pivot = less;
			
			int newPivot = partition(less, greater, pivot);
			
			sort(less, newPivot - 1);
			sort(newPivot + 1, greater);
		}
	}
	
	@Override
	public String getName() {
		return "Quick Sort";
	}

	@Override
	public Object clone() {
		Sorter out = new QuickSort((ArrayList<Double>)getData().clone());
		out.swapList = (LinkedList<Swap>) swapList.clone();
		out.scrambledData = (ArrayList<Double>) scrambledData.clone();
		return out;
	}

}
