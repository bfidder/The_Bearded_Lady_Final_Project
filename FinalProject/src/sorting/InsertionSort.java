package sorting;

import java.util.ArrayList;
import java.util.LinkedList;

public class InsertionSort extends Sorter{
	
	public InsertionSort(int ... data){
		super(data);
	}
	
	public InsertionSort(ArrayList<Integer> data){
		super(data);
	}
	
	public LinkedList<Swap> sort(){
		for(int i = 1; i < data.size(); i++){
			for(int j = i; j > 0; j--){
				if(data.get(j) > data.get(j-1)){
					break;
				}
				doSwap(j, j-1);
			}
		}
		return swapList;
	}
}
