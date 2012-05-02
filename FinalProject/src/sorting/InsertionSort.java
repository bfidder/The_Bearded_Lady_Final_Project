package sorting;

import java.util.ArrayList;
import java.util.LinkedList;

public class InsertionSort extends Sorter{
	//Sets the name on the button to Insertion Sort
	public String getName() {
		return "Insertion Sort";
	}
	
	public InsertionSort(double ... data){
		super(data);
	}
	
	public InsertionSort(ArrayList<Double> data){
		super(data);
	}
	/*
	 * sorts the data by checking the current value by  
	 * checking it against previous values until it is 
	 * checked against a value that is smaller than it.
	 * It calls doSwap until it reaches the smaller value.
	 */
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
