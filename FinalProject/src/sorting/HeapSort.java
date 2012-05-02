package sorting;

import java.util.ArrayList;
import java.util.LinkedList;

public class HeapSort extends Sorter {

	public HeapSort(double ... data) {
		super(data);
	}
	
	public HeapSort(ArrayList<Double> data) {
		super(data); 
	}
	
	@Override
	public LinkedList<Swap> sort() {
		pileUp();
		
		for(int i = data.size()-1; i > 0; i--) {
			doSwap(0, i);
			heapify(0, i-1);
		}
		
		return swapList; 
	}
	
	private void pileUp() {
		for(int i = data.size()/2 - 1; i >= 0; i--) {
			heapify(i, data.size()-1); 
		}
	}
	
	private void heapify(int start, int end) {
		double here = data.get(start);
		int leftIndex = start*2 + 1;
		int rightIndex = start*2 + 2;
		int largestIndex = start;
		if(leftIndex <= end && data.get(leftIndex) > here) {
			largestIndex = leftIndex;
		}
		if(rightIndex <= end && data.get(rightIndex) > data.get(largestIndex)) {
			largestIndex = rightIndex;
		}
		if(largestIndex != start) {
			doSwap(start, largestIndex);
			heapify(largestIndex, end);
		}
		
	}

	@Override
	public String getName() {
		return "Heap Sort";
	}
}
